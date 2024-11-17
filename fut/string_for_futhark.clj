(require '[clojure.string :as str])

(defn string->futhark-u8 [s]
  (as-> (map #(str (int %) "u8") s) $
    (str/join ", " $)
    (str "[" $ "]")))

(defn futhark-u8->string [s]
  (->> (str/replace s #"u8" "")
       read-string
       (map char)
       str/join))

(let [[filename] *command-line-args*]
  (-> (slurp filename)
      string->futhark-u8
      ; futhark-u8->string
      println))
