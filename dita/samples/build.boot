(def +project+ 'foo/bar)
(def +version+ "0.1.0-SNAPSHOT")

(set-env!
 :asset-paths #{"resources"}
 :source-paths #{"src/java"}
 :resource-paths #{"src/clj"}

 :repositories
 #(conj % ["maven-central" {:url "http://mvnrepository.com"}]
        ["central" "http://repo1.maven.org/maven2/"])

 :dependencies '[[org.clojure/clojure RELEASE]
                 [org.clojure/core.async "0.2.395"]
                 [slingshot "0.12.2"]])

(task-options!
 pom  {:project     +project+
       :version     +version+
       :description "My project"
       :url         "https://github.com/..."
       :scm         {:url "https://github.com/..."}
       :license {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}}
 push {:repo "clojars"})

(deftask monitor
  "watch etc."
  []
  (comp (watch)
        (notify :audible true)
        (pom)
        (jar)
        (install)))
