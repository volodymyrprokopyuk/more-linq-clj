(ns more-linq-clj.core
  (:require [ more-linq-clj.series :as series]))

(defn xtest [ ]
  ; SERIES
  ;(let [ item (series/dot-product) ]
  ;(doseq [ item (take 10 (series/pythagorean-triples)) ]
  ;(let [ item (series/weighted-sum) ]
  ;(doseq [ item (series/percentile) ]
  ;(doseq [ item (series/rank) ]
  ;(let [ item (series/dominator) ]
  ;(doseq [ item (series/bills-for-amount) ]
  ;(doseq [ item (series/moving-average) ]
  ;(doseq [ item (take 11 (series/comulative-sum)) ]
  ;(doseq [ item (take 8 (series/l-system)) ]
  ;(let [ item (series/koch-curve) ]
  ;  (spit "koch-curve.txt" item))) ; http://logo.twentygototen.org/
  ;(let [ item (series/sierpinski-triangle) ]
  ;  (spit "sierpinski-triangle.txt" item))) ; http://logo.twentygototen.org/
  ;(doseq [ item (take 11 (series/fibonacci)) ]
  ;(doseq [ item (series/permutations) ] ; TODO
  ;(doseq [ item (series/power-set) ] ; TODO
  ;(doseq [ item (series/nth-element) ]
  ;(doseq [ item (series/max-of-seqs) ]
  ;(doseq [ item (series/armstrong-nums) ]
  ;(doseq [ item (series/dudeney-nums) ]
  ;(doseq [ item (series/sum-product-nums) ]
  ;(doseq [ item (series/factorion-nums) ]
  ;(doseq [ item (take 11 (series/pascal-triangle)) ]
  ;(doseq [ item (series/tic-tac-toe) ]
  ;(doseq [ item (series/go-figure) ] ; TODO
  ;(doseq [ item (series/matching-pairs) ]
  ;(doseq [ item (series/hash-approach) ]
  ;(doseq [ item (series/fizz-buzz) ]
  (doseq [ item (series/fizz-buzz-set) ]
    (println item)))
