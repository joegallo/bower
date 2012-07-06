(ns bower.test.core
  (:use [bower.core])
  (:use [clojure.test]))

(def have-time-for-tests false)

(deftest no-tests
  (is (not have-time-for-tests))
  (println "Dammit, Chloe -- we're running out of time!"))
