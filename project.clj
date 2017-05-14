(defproject grpc-client "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [grpc.transformer "0.1.0-SNAPSHOT"]]
  :profiles {:uberjar {:aot :all}}
  :main grpc-client.core
  )
