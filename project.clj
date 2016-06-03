(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0-RC1"]
                 [ring/ring-jetty-adapter "1.5.0-RC1"]
                 [org.clojure/clojurescript "1.9.14"]
                 [hiccup "1.0.5"]]                 
  :plugins [[lein-cljsbuild "1.1.3"]]
  :main ^:skip-aot hello-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds [{:id "app"
                        :source-paths ["src-cljs"]
                        :compiler {:output-to "target/js/app.js"
                                   :optimizations :none}}]})   