(require '[clojure.string :as str])

(let [[words-string sentence]
      (-> (slurp "everybody_codes_e2024_q02_p1.txt")
          (str/split #"\n\n"))
      words (-> (str/split words-string #":")
                second
                (str/split #","))]
  (println (transduce
            (map #(count (re-seq (re-pattern %) sentence)))
            +
            words)))
