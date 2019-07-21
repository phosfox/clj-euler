(ns project-euler.problems
  (:import (java.lang Math)))


(defn prime?
  [n]
  (every? false? (map #(= 0 (mod n %)) (range 2 (Math/sqrt n)))))


(defn petersburg
  []
  (loop [payoff 1.0]
    (if (> (rand)  0.5)
      (recur (* 2 payoff))
      payoff)))


(defn digits [n]
  (->> n
       str
       (map (comp read-string str))))

(defn pow
  "Returns the result of n^x"
  [n x]
  (reduce * (repeat x n)))


(defn sum-fifth-pow
  [n]
  (->> n
       digits
       (map #(pow % 5))
       (reduce +)))


(defn fifth-pow?
  [n]
  (if (and (= n (sum-fifth-pow n)) (> n 1)) true))


(defn digits-two [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))


(defn p30
  "Find the sum of all the numbers that can be written as the sum of fifth powers of their digits."
  []
  (reduce +
          (take 6
                (filter fifth-pow? (range)))))
