(ns more-linq-clj.refactoring2)

(defn scan [ ]
  (let [ nums [ 1 2 3 4 ] ]
    (reductions + nums)))

(defn slice [ ]
  (let [ nums [ 1 2 3 4 5 6 7 8 9 10 ] ]
    (subvec nums 3 7)))

(defn xinterleave [ ]
  (let [ nums1 [ 1 3 4 5 ]
         nums2 [ 4 6 ] ]
    (interleave nums1 nums2)))

(defn windowed [ ]
  (let [ nums [ 1 2 3 4 5 6 7 8 9 10 11 ]
         average #(/ (apply + %1) (count %1)) ]
    (->> nums (partition 2 1) (map average))))

(defn cartesian-product [ ]
  (let [ lengths [ 1 2 3 4 5 6 7 ]
         breadths [ 1 1 2 3 1 3 ]
         heights [ 2 1 3 1 4 ] ]
    (for [ l lengths b breadths h heights ]
      (* l b h))))

(defn xpartition [ ]
  (let [ nums [ 1 2 3 4 5 6 7 8 9 10 ]
         percentages [ 0.3 0.6 0.1 ] ]
    (->> percentages (map #(-> nums count (* %1) Math/round))
      (reductions + 0) (partition 2 1) (map #(apply subvec nums %1)))))

(defn index [ ]
  (let [ s "LINQ" ]
    (map vector s (iterate inc 0))))

(defn pair-wise [ ]
  (let [ s "LLIIIINNQQ" ]
    (->> s distinct (apply str))))

(defn for-each [ ]
  (let [ nums [ 1 2 8 7 5 6 4 3 ] ]
    (map #(+ %1 1) nums)))

(defn min-by [ ]
  (let [ distances [ 23 41 11 34 45 ] ]
    (apply min-key #(- %1 10) distances)))
