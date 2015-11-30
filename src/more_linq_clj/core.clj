(ns more-linq-clj.core
  (:require [ more-linq-clj.series :as series ])
  (:require [ more-linq-clj.text :as text ]))

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
  ;(doseq [ item (series/fizz-buzz-set) ]
  ; TEXT
  ;(doseq [ item (text/t9-dictionary) ]
  ;(doseq [ item (text/gesture-keyboard) ] ; TODO
  ;(doseq [ item (text/spelling-correction) ] ; TODO
  ;(doseq [ item (text/reverse-sentence) ]
  ;(doseq [ item (text/word-triangle) ]
  ;(let [ item (text/anagram-sort) ]
  ;(let [ item (text/anagram-freq) ]
  ;(doseq [ item (text/syntax-highlighter) ] ; TODO
  ;(doseq [ item (text/word-ladder) ] ; TODO
  ;(doseq [ item (text/format-on-the-fly) ] ; TODO
  ;(let [ item (text/coma-quibbling) ]
  ;(doseq [ item (take 4 (text/random-serials)) ]
  ;(doseq [ item (text/all-substrings) ]
  ;(doseq [ item (text/scrabble-cheater) ] ; TODO
  ;(doseq [ item (text/all-subsequences) ] ; TODO
  ;(let [ item (text/paragraph-fill) ]
  ;(let [ item (text/bottles-of-milk) ]
  (doseq [ item (text/abbreviations) ]
    (println item)))
