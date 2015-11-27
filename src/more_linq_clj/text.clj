(ns more-linq-clj.text
  (:require [ clojure.string :as str ]))

(def t9
  "2 = ABC2
   3 = DEF3
   4 = GHI4
   5 = JKL5
   6 = MNO6
   7 = PQRS7
   8 = TUV8
   9 = WXYZ9")

(defn parse-t9 [ ]
  (->> t9 str/lower-case (re-seq #"(\d) = (\w+)")
    (mapcat (fn [ [ _ [ d ] ws ] ] (mapcat #(vector %1 d) ws)))
    (apply hash-map)))

(def dictionary
  #{ "gone" "good" "goof" "home" "hone" "hood" "hoof" "select" "reject"
     "textonym" "dictionary" "clojure" })

(defn index-dictionary [ ]
  (let [ char->digit (parse-t9) ]
    (reduce
      (fn [ dict word ]
        (let [ hash (->> word (map char->digit) (apply str))
               words (get dict hash [ ]) ]
          (assoc dict hash (conj words word))))
      { } dictionary)))

(defn t9-dictionary [ ]
  (let [ key "4663" ; "735328"
         dict (index-dictionary) ]
    (get dict key)))
