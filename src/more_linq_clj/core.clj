(ns more-linq-clj.core
  (:require [ more-linq-clj.series :as series]))

(defn xtest [ ]
  ; SERIES
  ;(let [ item (series/dot-product) ]
  ;(doseq [ item (series/pythagorean-triples) ]
  ;(let [ item (series/weighted-sum) ]
  ;(doseq [ item (series/percentile) ]
  ;(doseq [ item (series/rank) ]
  ;(let [ item (series/dominator) ]
  ;(doseq [ item (series/bills-for-amount) ]
  ;(doseq [ item (series/moving-average) ]
  ;(doseq [ item (series/comulative-sum) ]
  (doseq [ item (series/l-system) ]
  ;(let [ item (series/koch-curve) ]
  ;  (spit "koch-curve.txt" item)))
  ;(let [ item (series/sierpinski-triangle) ]
  ;  (spit "sierpinski-triangle.txt" item)))
  ;(doseq [ item (series/fibonacci) ]
  ;(doseq [ item (series/permutations) ]
  ;(doseq [ item (series/power-set) ]
  ;(doseq [ item (series/nth-element) ]
  ;(doseq [ item (series/max-of-seqs) ]
  ;(doseq [ item (series/armstrong-nums) ]
  ;(doseq [ item (series/dudeney-nums) ]
  ;(doseq [ item (series/sum-product-nums) ]
  ;(doseq [ item (series/factorion-nums) ]
    (println item)))
