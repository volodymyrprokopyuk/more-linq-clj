(ns more-linq-clj.refactoring1)

(defn any [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (some #(and (>= %1 150) %1) nums)))

(defn all [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (every? #(< %1 150) nums)))

(defn xtake [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (take 4 nums)))

(defn skip [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (drop 4 nums)))

(defn xtake-while [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (take-while #(< %1 50) nums)))

(defn skip-while [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (drop-while #(zero? (mod %1 7)) nums)))

(defn where [ ]
  (let [ nums [ 14 21 24 51 131 1 11 54 ] ]
    (filter #(> %1 50) nums)))

(defn zip [ ]
  (let [ sals [ "Mr. " "Mrs. " "Master. " "Ms. " ]
         names [ "Patrick" "Nancy" "Jon" "Jane" ] ]
    (map str sals names (repeat " Smith"))))
