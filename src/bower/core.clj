(ns bower.core
  (:use [clojure.math.combinatorics]))

;; I see four numbers sitting in a row, and everything else goes out
;; the window. I will do whatever it takes to solve them, and I mean
;; whatever it takes.

(def operations ['+ '- '* '/])

(defn forms [[o1 o2 o3] [n1 n2 n3 n4]]
  [`(~o1 (~o2 ~n1 ~n2) (~o3 ~n3 ~n4))
   `(~o1 ~n1 (~o2 ~n2 (~o3 ~n3 ~n4)))])

(defn candidates [numbers]
  (apply concat
         (for [o (selections operations 3)
               n (permutations numbers)]
           (forms o n))))

(defn solves? [candidate]
  (try
    (= 24 (eval candidate))
    ;; inevitable division by zero
    (catch Exception e
      false)))

(defn pprint [solutions]
  (doseq [s solutions]
    (println s)))

(defn solutions [numbers]
  (filter solves? (candidates numbers)))

(defn twenty-four [numbers]
  (pprint (solutions numbers)))
