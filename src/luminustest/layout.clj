(ns luminustest.layout
  (:require [selmer.parser :as parser]
            [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]
            [noir.session :as session]))

(def template-path "templates/")

(deftype
  RenderableTemplate
  [template params]
  Renderable
  (render
    [this request]
    (content-type
      (->>
        (assoc
          params
          (keyword (s/replace template #".html" "-selected"))
          "active"
          :dev
          (env :dev)
          :servlet-context
          (if-let [context (:servlet-context request)]
            (try
              (.getContextPath context)
              (catch IllegalArgumentException _ context)))
          :user-id
          (session/get :user-id))
        (parser/render-file (str template-path template))
        response)
      "text/html; charset=utf-8")))

(defn render [template & [params]]
  (RenderableTemplate. template params))

