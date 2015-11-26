(ns more-linq-clj.series
  (:require [ clojure.string :as str ])
  (:require [ clojure.set :as set ]))

(defn dot-product [ ]
  (let [ v1 [ 1 2 3 ]
         v2 [ 3 2 1 ] ]
    (map * v1 v2)))

(defn pythagorean-triples [ ]
  (->> 2 (iterate inc)
    (map #(vector (* %1 2) (- (* %1 %1) 1) (+ (* %1 %1) 1)))))

(defn weighted-sum [ ]
  (let [ values [ 1 2 3 ]
         weights [ 3 2 1 ] ]
    (->> (map * values weights) (apply +))))

(defn percentile [ ]
  (let [ marks [ 20 15 31 34 35 40 50 90 99 100 ]
         caclulate-percentile
         (fn [ mark ]
           (let [ lo-marks (filter #(< %1 mark) marks)
                  percentile (* (/ (count lo-marks) (count marks)) 100) ]
             [ mark percentile ])) ]
    (->> marks (map caclulate-percentile))))

(defn rank [ ]
  (as-> (percentile) $
    (sort-by second #(compare %2 %1) $)
    (map conj $ (iterate inc 1))))

(defn dominator [ ]
  (let [ nums [ 3 4 3 2 3 -1 3 3 ]
         half (-> nums count (/ 2))
         is-dominator? (fn [ [ _ freq ] ] (>= freq half)) ]
    (->> nums frequencies (filter is-dominator?) first first)))

(defn all-bills-for-amount [ bills amount ]
  (let [ add-bill
         (fn [ { :keys [ amount bills ] :as total } bill ]
           (assoc total
             :amount (rem amount bill)
             :bills (conj bills [ bill (quot amount bill) ]))) ]
    (->> bills (sort #(compare %2 %1))
      (reduce add-bill { :amount amount :bills [ ] }))))

(defn bills-for-amount [ ]
  (let [ bills [ 500 100 50 20 10 5 2 1 1000 ]
         amount 2548
         has-bills? (fn [ [ _ num ] ] (-> num zero? not)) ]
    (->> amount (all-bills-for-amount bills) :bills (filter has-bills?))))

(defn moving-average [ ]
  (let [ nums [ 1 2 3 4 ]
         window 2
         average (fn [ nums ] (/ (apply + nums) (count nums))) ]
    (->> nums (partition window 1) (map average))))

(defn comulative-sum [ ]
  (iterate (fn [ [ i sum ] ] [ (inc i) (-> i inc (+ sum)) ]) [ 0 0 ]))

(defn next-algae [ algae ]
  (-> algae
    (str/replace "B" "[B]")
    (str/replace "A" "AB")
    (str/replace "[B]" "A")))

(defn l-system [ ]
  (->> "A" (iterate next-algae)
    (map-indexed (fn [ i algae ] [ i algae (count algae) ]))))

(defn next-koch [ curve ]
  (str/replace curve "F" "F+F-F-F+F"))

(defn translate-koch [ curve ]
  (let [ init "home\nsetxy 10 340\nright 90\n" ]
    (-> curve
      (str/replace #"^" init)
      (str/replace "F" "forward 15\n")
      (str/replace "+" "left 90\n")
      (str/replace "-" "right 90\n"))))

(defn koch-curve [ ]
  (let [ steps 3 ]
    (->> "F" (iterate next-koch) (drop (dec steps)) first translate-koch)))

(defn next-sierpinski [ triangle ]
  (-> triangle
    (str/replace "B" "[B]")
    (str/replace "A" "B-A-B")
    (str/replace "[B]" "A+B+A")))

(defn translate-sierpinski [ triangle ]
  (-> triangle
    (str/replace #"A|B" "forward 5\n")
    (str/replace "+" "left 60\n")
    (str/replace "-" "right 60\n")))

(defn sierpinski-triangle [ ]
  (let [ steps 6 ]
    (->> "A" (iterate next-sierpinski) (drop (dec steps)) first
      translate-sierpinski)))

(defn fib-seq-fn [ ]
  (->> [ 0 1 ] (iterate (fn [ [ prev curr ] ] [ curr (+ prev curr) ]))
    (map first)))

(def fib-seq
  (lazy-cat [ 0 1 ] (map + (rest fib-seq) fib-seq)))

(defn fibonacci [ ]
  ;(fib-seq-fn))
  fib-seq)

(defn permutations [  ]
  [ "TODO" ])

(defn power-set [ ]
  [ "TODO" ])

(defn nth-element [ ]
  (->> 1 (iterate inc) (take-nth 20)))

(defn max-of-seqs [ ]
  (let [ as [ 1 2 3 4 5 ]
         bs [ 2 1 4 5 6 ]
         cs [ 4 0 6 8 1 ]
         ds [ 9 2 4 1 6 ] ]
    (map max as bs cs ds)))

(defn num->ditits [ num ]
  (->> num str (map #(->> %1 str Integer/parseInt))))

(defn is-armstrong? [ num ]
  (== num (->> num num->ditits (map #(Math/pow %1 3)) (apply +))))

(defn armstrong-nums [ ]
  (->> 1001 range (filter is-armstrong?)))

(defn is-dudeney? [ num ]
  (== num (as-> num $ (num->ditits $) (apply + $) (Math/pow $ 3))))

(defn dudeney-nums [ ]
  (->> 1001 range (filter is-dudeney?)))

(defn is-sum-product? [ num ]
  (let [ digits (num->ditits num)
         sum (apply + digits)
         prod (apply * digits)
         sum-prod (* sum prod) ]
    (== num sum-prod)))

(defn sum-product-nums [ ]
  (->> 1001 range (filter is-sum-product?)))

(defn factorial [ num ]
  (->> num inc (range 1) (apply *)))

(defn is-factorion? [ num ]
  (== num (->> num num->ditits (map factorial) (apply +))))

(defn factorion-nums [ ]
  (->> 1001 range (filter is-factorion?)))

(defn next-pascal [ nums ]
  (as-> nums $
    (partition 2 1 $)
    (map #(apply + %1) $)
    (concat [ 1 ] $ [ 1 ])))

(defn pascal-triangle [ ]
  (->> [ 1 ] seq (iterate next-pascal)))

(defn tic-tac-toe [ ]
  (let [ size 3
         board (->> (* size size) inc (range 1))
         hor (->> board (partition size))
         ver (->> hor (apply map vector))
         diag (->> board (take-nth (inc size)) vector)
         rev (->> hor (mapcat reverse) (take-nth (inc size)) vector) ]
    (concat hor ver diag rev)))

(defn go-figure [ ]
  [ "TODO" ])

(defn matching-pairs [ ]
  (let [ words1 [ "orange" "herbal" "rubble" "indicative" "mandatory"
                  "brush" "golden" "diplomatic" "pace" ]
         words2 [ "verbal" "rush" "pragmatic" "story" "race" "bubble"
                  "olden" ] ]
    (for [ w1 words1 w2 words2
           :when (= (re-find #".{3}$" w1) (re-find #".{3}$" w2)) ]
      [ w1 w2 ])))

(defn hash-approach [ ]
  (let [ words1 [ "orange" "herbal" "rubble" "indicative" "mandatory"
                  "brush" "golden" "diplomatic" "pace" ]
         words2 [ "verbal" "rush" "pragmatic" "story" "race" "bubble"
                  "olden" ]
         hash-word
         (fn [ words word ]
           (let [ hash (re-find #".{3}$" word)
                  hash-words (get words hash [ ]) ]
             (assoc words hash (conj hash-words word)))) ]
    (->> (concat words1 words2) (reduce hash-word { }) vals
      (filter #(>= (count %1) 2)))))
