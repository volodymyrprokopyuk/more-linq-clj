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
