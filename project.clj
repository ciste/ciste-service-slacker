(defproject ciste/ciste-service-slacker "0.4.0-SNAPSHOT"
  :description "Slacker Connector Service for Ciste Applications"
  :url "http://github.com/duck1123/ciste"
  :author "Daniel E. Renfer <duck@kronkltd.net>"
  :min-lein-version "2.0.0"
  :dependencies [[ciste "0.4.0-SNAPSHOT"]
                 [slacker "0.8.5"]]
  :profiles {:dev
             {:dependencies
              [[log4j "1.2.17"]
               [midje "1.5-alpha3"]]}}
  :plugins [[codox "0.6.4"]
            [lein-midje "2.0.3"]]
  :autodoc {:name "Ciste Service Slacker"
            :copyright "2012 KRONK Ltd."}
  :warn-on-reflection true
  :jvm-opts ["-server"])
