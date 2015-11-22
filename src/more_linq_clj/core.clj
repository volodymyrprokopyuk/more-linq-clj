(ns more-linq-clj.core
  (:require [ more-linq-clj.series :as series]))

(defn xtest [ ]
  ;(let [ item (series/dot-product) ]
  ;(doseq [ item (series/pythagorean-triples) ]
  ;(let [ item (series/weighted-sum) ]
  ;(doseq [ item (series/percentile) ]
  ;(doseq [ item (series/rank) ]
  ;(let [ item (series/dominator) ]
  ;(doseq [ item (series/bills-for-amount) ]
  ;(doseq [ item (series/moving-average) ]
  (doseq [ item (series/comulative-sum) ]
    (println item)))
