(ns more-linq-clj.series
  (:require [ clojure.string :as str ])
  (:require [ clojure.set :as set ]))

(defn dot-product [ ]
  (let [ v1 [ 1 2 3 ]
         v2 [ 3 2 1 ] ]
    (map * v1 v2)))

(defn pythagorean-triples [ ]
  (let [ nums (range 2 12)
         create-triple
         (fn [ num ] { :length (* num 2) :height (- (* num num) 1)
                       :hypotenuse (+ (* num num) 1) }) ]
    (map create-triple nums)))

(defn weighted-sum [ ]
  (let [ values [ 1 2 3 ]
         weights [ 3 2 1 ] ]
    (->> (map * values weights) (apply +))))

(defn percentile [ ]
  (let [ marks [ 20 15 31 34 35 40 50 90 99 100 ]
         marks-count (count marks)
         caclulate-percentile
         (fn [ mark ]
           (let [ lo-marks (filter #(< %1 mark) marks)
                  percentile (* (/ (count lo-marks) marks-count) 100) ]
             { :mark mark :percentile percentile })) ]
    (map caclulate-percentile marks)))

(defn rank [ ]
  (let [ percentiles (percentile)
         rank-range (range 1 (->> percentiles count inc))
         add-rank (fn [ perc rank ] (assoc perc :rank rank)) ]
    (as-> percentiles $
      (sort-by :percentile #(compare %2 %1) $)
      (map add-rank $ rank-range))))

(defn dominator [ ]
  (let [ nums [ 3 4 3 2 3 -1 3 3 ]
         half-nums (-> nums count (/ 2))
         is-dominator (fn [ [ _ freq ] ] (>= freq half-nums)) ]
    (->> nums frequencies (filter is-dominator) first first)))

(defn all-bills-for-amount [ bills amount ]
  (loop [ amount-rem amount
          added-bills (sorted-map-by #(compare %2 %1))
          [ bill & bill-rest ] (sort #(compare %2 %1) bills) ]
    (if (nil? bill)
      added-bills
      (recur (rem amount-rem bill)
        (assoc added-bills bill (quot amount-rem bill)) bill-rest))))

(defn bills-for-amount [ ]
  (let [ bills [ 500 100 50 20 10 5 2 1 1000 ]
         amount 2548
         all-bills (all-bills-for-amount bills amount)
         has-bills? (fn [ [ _ num ] ] (-> num zero? not)) ]
    (filter has-bills? all-bills)))

(defn moving-average [ ]
  (let [ nums [ 1 2 3 4 ]
         window 2
         average (fn [ nums ] (/ (apply + nums) (count nums))) ]
    (->> nums (partition window 1) (map average))))

(defn comulative-sum [ ]
  (let [ nums (range 1 11) ]
    (loop [ acc (sorted-map)
            sum 0
            [ num & num-rest ] nums ]
      (if (nil? num)
        acc
        (recur (assoc acc num (+ sum num)) (+ sum num) num-rest)))))

(defn next-algae [ algae ]
  (-> algae (str/replace "B" "[B]")
    (str/replace "A" "AB") (str/replace "[B]" "A")))

(defn raw-l-system [ steps ]
  (loop [ step 0
          algae "A"
          algaes [ ] ]
    (if (> step steps)
      algaes
      (recur (inc step) (next-algae algae)
        (conj algaes { :step step :algae algae })))))

(defn l-system [ ]
  (let [ steps 7
         algaes (raw-l-system steps)
         add-length
         (fn [ { :keys [ algae ] :as step } ]
           (assoc step :length (count algae))) ]
    (map add-length algaes)))

(defn next-koch [ curve ]
   (str/replace curve "F" "F+F-F-F+F"))

(defn raw-koch-curve [ steps ]
  ;(reduce
  ;  (fn [ curve _ ]
  ;    (str/replace curve "F" "F+F-F-F+F"))
  ;  "F" (range steps)))
  (loop [ step 0
          curve "F" ]
    (if (> step steps)
      curve
      (recur (inc step) (next-koch curve)))))

(defn koch-curve [ ]
  (let [ steps 3
         curve (raw-koch-curve steps)
         init "home\nsetxy 10 340\nright 90\n" ]
    (-> curve (str/replace #"^" init) (str/replace "F" "forward 15\n")
      (str/replace "+" "left 90\n") (str/replace "-" "right 90\n"))))

(defn raw-sierpinski-triangle [ steps ]
  (reduce
    (fn [ triangle _ ]
      (-> triangle (str/replace "B" "[B]")
        (str/replace "A" "B-A-B") (str/replace "[B]" "A+B+A")))
    "A" (range steps)))

(defn sierpinski-triangle [ ]
  (let [ steps 5
         triangle (raw-sierpinski-triangle steps) ]
    (-> triangle (str/replace #"A|B" "forward 5\n")
      (str/replace "+" "left 60\n") (str/replace "-" "right 60\n"))))

(defn fibonacci-seq [ ]
  (map first
    (iterate (fn [ [ prev curr ] ] [ curr (+ prev curr) ]) [ 0 1 ])))

(def fib-seq
  (lazy-cat [ 0 1 ] (map + (rest fib-seq) fib-seq)))

(defn fibonacci [ ]
  ;(take 11 (fibonacci-seq)))
  (take 11 fib-seq))

(defn permutations [  ]
  [ "TODO" ])

(defn power-set [ ]
  [ "TODO" ])

(defn nth-element [ ]
  (take-nth 20 (range 1 101)))

(defn max-of-seqs [ ]
  (let [ as [ 1 2 3 4 5 ]
         bs [ 2 1 4 5 6 ]
         cs [ 4 0 6 8 1 ]
         ds [ 9 2 4 1 6 ] ]
    (map max as bs cs ds)))

(defn num->ditits [ num ]
  (->> num str (map #(->> %1 str Integer/parseInt))))

(defn is-armstrong? [ num ]
  (let [ digits (num->ditits num)
         pow-sum (->> digits (map #(Math/pow %1 3)) (apply +)) ]
    (== num pow-sum)))

(defn armstrong-nums [ ]
  (->> 1001 range (filter is-armstrong?)))

(defn is-dudeney? [ num ]
  (let [ digits (num->ditits num)
         sum-pow (as-> digits $ (apply + $) (Math/pow $ 3)) ]
    (== num sum-pow)))

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
  (reduce (fn [ fac n ] (* fac n))
    1 (range 1 (inc num))))

(defn is-factorion? [ num ]
  (let [ digits (num->ditits num)
         fac-sum (->> digits (map factorial) (apply +)) ]
    (== num fac-sum)))

(defn factorion-nums [ ]
  (->> 1001 range (filter is-factorion?)))
