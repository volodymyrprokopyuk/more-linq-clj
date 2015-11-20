(ns more-linq-clj.series)

(defn dot-product [ ]
  (let [ v1 [ 1 2 3 ]
         v2 [ 3 2 1 ] ]
    (map * v1 v2)))
