(defproject grpc-client "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.grpc/grpc-all "1.0.0"
                  :exclusions [io.netty/netty-codec-http2
                               io.grpc/grpc-auth
                               io.grpc/grpc-core]]
                 [io.grpc/grpc-core "1.0.0"]
                 [io.netty/netty-codec-http2 "4.1.3.Final"]
                 [grpc.transformer "0.1.0-SNAPSHOT"]]
  :profiles {:uberjar {:aot :all}}
  :main grpc-client.core
  )
