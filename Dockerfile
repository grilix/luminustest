FROM clojure
RUN mkdir /app
WORKDIR /app
ADD . /app
RUN ["lein", "deps"]
