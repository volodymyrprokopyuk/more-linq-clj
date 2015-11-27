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

(def dictionary
  #{ "gone" "good" "goof" "home" "hone" "hood" "hoof" "select" "reject"
     "textonym" "dictionary" "clojure" })

(defn t9-dictionary [ ]
  (let [ key "4663" ] ; "735328"
    key))
