(require '[clojure.string :as str])

(defn poses [s p]
  (when (not= p "")
    (->> (str/index-of s p)
         (iterate #(some-> %
                           (->> inc
                                (str/index-of s p))))
         (take-while some?))))

(let [[words-string sentence]
      (-> #_(slurp "everybody_codes_e2024_q02_p2.txt")
       "WORDS:THE,OWE,MES,ROD,HER,QAQ

AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE
THE FLAME SHIELDED THE HEART OF THE KINGS
POWE PO WER P OWE R
THERE IS THE END
QAQAQ"
          (str/split #"\n\n"))
      words (-> (str/split words-string #":")
                second
                (str/split #","))
      ; rev-words (map str/reverse words)
      ; big-regex (re-pattern (str "(" (str/join "|" (concat words rev-words)) ")"))
      ]
  (println sentence)
  (println words)
  (println (poses sentence (get words 0)))
  #_(println (transduce
              (map #(count (re-seq (re-pattern %) sentence)))
              +
              words)))


