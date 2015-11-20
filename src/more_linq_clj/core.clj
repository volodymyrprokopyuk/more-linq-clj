(ns more-linq-clj.core
  (:require [ more-linq-clj.series :as series]))

(defn xtest [ ]
  (let [ item (series/dot-product) ]
    (println item)))
