(defproject luminustest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [lib-noir "0.9.4"]
                 [ring-server "0.3.1"]
                 [selmer "0.7.2"]
                 [com.taoensso/timbre "3.3.1"]
                 [com.taoensso/tower "3.0.2"]
                 [markdown-clj "0.9.55"
                  :exclusions [com.keminglabs/cljx]]
                 [environ "1.0.0"]
                 [im.chit/cronj "1.4.2"]
                 [noir-exception "0.2.2"]
                 [prone "0.6.0"]]

  :repl-options {:init-ns luminustest.repl}
  :jvm-opts ["-server"]
  :plugins [[lein-ring "0.8.13"]
            [lein-environ "1.0.0"]
            [lein-ancient "0.5.5"]]
  :ring {:handler luminustest.handler/app
         :init    luminustest.handler/init
         :destroy luminustest.handler/destroy}
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all}
   :production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.3.1"]
                        [pjstadig/humane-test-output "0.6.0"]]
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]
         :env {:dev true}}}
  :min-lein-version "2.0.0")