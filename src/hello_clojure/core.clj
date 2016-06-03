(ns hello-clojure.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [hiccup.page :refer [html5 include-js]]
            [ring.middleware.reload :refer [wrap-reload]])    
  (:gen-class))

(def my-page
 [:html [:head [:title "hekllo-clojure"]]
        [:body (include-js "/js/app.js")]]) 

(defn my-handler [request]
 {:status 200
  :headers {"Content-Type" "text/html"}
  :body (html5 my-page)})

(def handler (wrap-reload #'my-handler)) 

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [server (run-jetty handler {:port 8080})]
   (.addShutdownHook (Runtime/getRuntime) (Thread. #(.stop server))))) 