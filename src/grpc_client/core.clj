(ns grpc-client.core
  (:require [grpc.transformer :refer [->message <-message]])
  (:import [io.grpc ManagedChannelBuilder]))


(defn grpc-call [method-key client params]
  (let [methods (.getDeclaredMethods (.getClass client))
        method (first (filter (fn [m] (= (name method-key) (.getName m))) methods))
        grpc-request-clazz (first (.getParameterTypes method))
        builder (->message params grpc-request-clazz)
        resp (.invoke method client  (object-array [builder]))]
    (<-message resp)))


(defn create-channel [host port]
  (-> (ManagedChannelBuilder/forAddress host port)
      (.usePlaintext true)
      (.build)))

(defrecord GrpcClient [stub config]
  clojure.lang.IFn
  (invoke [_ method params]
    (grpc-call method stub params)))


(defmacro defgrpc-client [name clz config]
  `(let [stub# ( ~(symbol (str clz "/newBlockingStub")) (create-channel (:host ~config) (:port ~config)))]
     (def ~name (->GrpcClient stub# ~config))))
