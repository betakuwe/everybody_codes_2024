(->> (slurp "everybody_codes_e2024_q01_p2.txt")
     (transduce (comp
                 (partition-all 2)
                 (map (fn [cs]
                        (cond-> (transduce
                                 (map #(case % \D 5 \C 3 \B 1 (\A \x) 0))
                                 +
                                 cs)
                          (every? #(not= % \x) cs) (+ 2)))))
                +)
     println)
