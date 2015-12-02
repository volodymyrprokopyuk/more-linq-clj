(ns more-linq-clj.refactoring1
  (:require [ clojure.set :as set ]))

(defn any [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (some #(and (>= %1 150) %1) nums)))

(defn all [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (every? #(< %1 150) nums)))

(defn xtake [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (take 4 nums)))

(defn skip [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (drop 4 nums)))

(defn xtake-while [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (take-while #(< %1 50) nums)))

(defn skip-while [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (drop-while #(zero? (mod %1 7)) nums)))

(defn where [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (filter #(> %1 50) nums)))

(defn zip [ ]
  (let [ sals [ "Mr. " "Mrs. " "Master. " "Ms. " ]
         names [ "Patrick" "Nancy" "Jon" "Jane" ] ]
    (map str sals names (repeat " Smith"))))

(defn order-by [ ]
  (let [ words [ "abc" "bc" "a" "d" "abcd" ] ]
    (sort-by count #(compare %2 %1) words)))

(defn xdistinct [ ]
  (let [ names [ "Sam" "David" "Sam" "Eric" "Daniel" "Sam" ] ]
    (distinct names)))

(defn xunion [ ]
  (let [ names1 [ "Sam" "David" "Sam" "Eric" "Daniel" "Sam" ]
         names2 [ "David" "Eric" "Samuel" ] ]
    (set/union (set names1) (set names2))))

(defn xintersect [ ]
  (let [ names1 [ "Sam" "David" "Sam" "Eric" "Daniel" "Sam" ]
         names2 [ "David" "Eric" "Samuel" ] ]
    (set/intersection (set names1) (set names2))))

(defn except [ ]
  (let [ names1 [ "Sam" "David" "Sam" "Eric" "Daniel" "Sam" ]
         names2 [ "David" "Eric" "Samuel" ] ]
    (set/difference (set names1) (set names2))))

(defn xconcat [ ]
  (let [ names1 [ "Sam" "David" "Sam" "Eric" "Daniel" "Sam" ]
         names2 [ "David" "Eric" "Samuel" ] ]
    (concat names1 names2)))

(defn sequence-equal [ ]
  (let [ nums1 [ 343 2132 12 32143 234 ]
         nums2 [ 343 12 2132 32143 234 ] ]
    ;(= nums1 nums2)))
    (= (sort nums1) (sort nums2))))

(defn type-of [ ]
  (let [ items [ "Sam" 1 "Eric" ] ]
    (filter string? items)))

(defn xcast [ ]
  (let [ items [ "Sam" "Dave" "Greg" "Travis" "Dan" 2 ] ]
    (map str items)))

(defn aggregate [ ]
  (let [ names [ "Greg" "Travis" "Dan" ] ]
    (reduce (fn [ new-names name ] (str new-names ", " name)) names)))

(defn select-many-chars [ ]
  (let [ words [ "dog" "elephant" "fox" "bear" ] ]
    (mapcat #(map identity %1) words)))

(defn select-many-nums [ ]
  (for [ x (range 11) y (range 11) ]
    (+ x y)))

(defn prime-seq [ [ f & r ] ]
  (cons f (lazy-seq (prime-seq (filter #(not= (mod %1 f) 0) r)))))

(defn prime-numbers [ ]
  (prime-seq (iterate inc 2)))
