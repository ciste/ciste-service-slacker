(ns ciste.service.slacker
  (:require [ciste.config :refer [config describe-config]]
            [clojure.tools.logging :as log]
            [slacker.client :refer [defn-remote slackerc]]
            [slacker.server :refer [start-slacker-server]]
            [slacker.client.common :refer [invoke-slacker]]))

(describe-config [:slacker :port] :number
  "The port the slacker connection should run on")

(describe-config [:slacker :use-zookeeper] :boolean
  "Should the zookeeper connection be used")

(defn get-client
  ([host] (get-client host (config :slacker :port)))
  ([host port]
     (let [connect-str (str host ":" port)]
       (log/info (str "opening connection for " connect-str))
       (slackerc connect-str))))

(defn send-command
  [client command]
  (invoke-slacker client ["ciste.commands" "parse-command" command]))

(defn start
  []
  (log/info "Starting slacker server")
  (start-slacker-server (the-ns 'ciste.commands) (config :slacker :port)))
