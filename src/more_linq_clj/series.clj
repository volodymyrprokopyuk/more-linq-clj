(ns more-linq-clj.series)

(defn dot-product [ ]
  (let [ v1 [ 1 2 3 ]
         v2 [ 3 2 1 ] ]
    (map * v1 v2)))

(defn pythagorean-triples [ ]
  (for [ c (range 2, 12) ]
    { :length (* c 2) :height (- (* c c) 1) :hypotenuse (+ (* c c) 1) }))

(defn weighted-sum [ ]
  (let [ values [ 1 2 3 ]
         weights [ 3 2 1 ] ]
    (->> (map * values weights) (apply +))))

(defn percentile [ ]
  (let [ marks [ 20 15 31 34 35 40 50 90 99 100 ]
         marks-count (count marks) ]
    (for [ mark marks ]
      (let [ lo-marks (filter #(< %1 mark) marks)
             percentile (* (/ (count lo-marks) marks-count) 100) ]
        { :mark mark :percentile percentile }))))

(defn rank [ ]
  (let [ percentiles (percentile)
         rank-range (range 1, (+ (count percentiles) 1)) ]
    (as-> percentiles $
      (sort-by :percentile #(compare %2 %1) $)
      (map #(assoc %1 :rank %2) $ rank-range))))

(defn dominator [ ]
  (let [ nums [ 3 4 3 2 3 -1 3 3 ]
         half-nums (/ (count nums) 2) ]
    (->> nums frequencies (filter (fn [ [ _ freq ] ] (>= freq half-nums)))
      first second)))

(defn all-bills-for-amount [ bills amount ]
  (loop [ amount-rem amount
          bill-quantities (sorted-map-by #(compare %2 %1))
          [ bill & bill-rest ] (sort #(compare %2 %1) bills) ]
    (if (nil? bill)
      bill-quantities
      (recur (rem amount-rem bill)
        (assoc bill-quantities bill (quot amount-rem bill))
        bill-rest))))

(defn bills-for-amount [ ]
  (let [ bills [ 500 100 50 20 10 5 2 1 1000 ]
         amount 2548
         all-bills (all-bills-for-amount bills amount) ]
    (remove (fn [ [ _ quantity ] ] (zero? quantity)) all-bills)))

(defn moving-average [ ]
  (let [ nums [ 1 2 3 4 ]
         window 2
         average #(/ (apply + %) (count %)) ]
    (->> nums (partition window 1) (map average))))

(defn comulative-sum [ ]
  (let [ nums (range 1 11) ]
    (loop [ acc (sorted-map)
            sum 0
            [ num & num-rest ] nums ]
      (if (nil? num)
        acc
        (recur (assoc acc num (+ sum num)) (+ sum num) num-rest)))))
