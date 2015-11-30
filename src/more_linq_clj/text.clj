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

(defn gesture-keyboard [ ]
  (let [ gest "ujnbvcderesdftrewazxcvbnhgfds" ]
    [ "TODO" ]))

(defn spelling-correction [ ]
  [ "TODO" ])

(defn reverse-sentence [ ]
  (let [ sentence "nothing know I" ]
    (->> sentence (re-seq #"\S+") reverse)))

(defn word-triangle [ ]
  (let [ word "umbrella"
         up (->> word count (range 1)
              (map #(take %1 word)) (map #(apply str %1)))
         down (as-> word $ (count $) (range $ 0 -1)
                (map #(take %1 word) $) (map #(apply str %1) $)) ]
    (concat up down)))

(defn anagram-sort [ ]
  (let [ line1 "the eyes," ; "oriental"
         line2 "they see." ; "relation"
         is-alpha #(->> %1 str (re-find #"\w")) ]
    (= (->> line1 (filter is-alpha) sort)
      (->> line2 (filter is-alpha) sort))))

(defn anagram-freq [ ]
  (let [ line1 "the eyes," ; "oriental"
         line2 "they see." ; "relation"
         is-alpha #(->> %1 str (re-find #"\w")) ]
    (= (->> line1 (filter is-alpha) frequencies)
      (->> line2 (filter is-alpha) frequencies))))

(defn syntax-highlighter [ ]
  [ "TODO" ])

(defn word-ladder [ ]
  [ "TODO" ])

(defn format-on-the-fly [ ]
  (let [ nums [ "234567890" "345678901" "456789012" ]
         sample "123456789=>123-456-789" ]
    [ "TODO" ]))

(defn coma-quibbling [ ]
  (let [ words [ "ABC" "DEF" "G" "H" ]
         a (as-> words $ (count $) (dec $) (take $ words) (str/join ", " $))
         b (last words) ]
    (->> [ a b ] (remove #(or (nil? %1) (empty? %1)))
      (str/join " and ") (format "{ %s }"))))

(defn random-serials [ ]
  (let [ new-serial
         (fn [ length ]
           (->> #(rand-int 255) repeatedly (map #((comp str char) %1))
           (filter #(re-find #"[\w\[\]\(\)]" %1)) (take length) (apply str))) ]
     (repeatedly #(new-serial 8))))

(defn all-substrings [ ]
  (let [ s "LINQ" ]
    (->> s count inc (range 1) (mapcat #(partition %1 1 s))
      (map #(apply str %1)))))

(defn scrabble-cheater [ ]
  [ "TODO" ])

(defn all-subsequences [ ]
  [ "TODO" ])

(defn paragraph-fill [ ]
  (let [ length 35
         s "Almost any text editor provides a fill
operation. The fill operation transforms raggedy-looking text
with lines of
different lengths into nicely formatted text with lines
nearly the same length." ]
    (->> s (re-seq #"\S+")
      (reduce
        (fn [ [ ws len ] w ]
          (if (< (+ (count w) len) length)
            [ (str ws " " w) (+ (count w) len) ]
            [ (str ws "\n" w) (count w) ]))
        [ "" 0 ]) first str/trim)))

(defn bottles-of-milk [ ]
  (let [ num 5 ]
    (->> (range num -1 -1)
      (map
        #(if (zero? %1)
           "No more bottles of milk on the wall"
           (format "%s bottles of milk on the wall" %1)))
      (str/join "\n"))))

(defn abbreviations [ ]
  (let [ s "This is an effort by the World Health Organization (WHO) and
Fédération Internationale de Football Association (FIFA) to help
footballers in poor nations. Associated Press (AP) reports" ]
    (->> s (re-seq #"([A-Z]\w+(?:(?: | de | of )[A-Z]\w+)*) \(([A-Z]+)\)")
      (map (fn [ [ _ desc abbr ] ] [ abbr desc ])) (into { }))))
