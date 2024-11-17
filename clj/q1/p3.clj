(->> (slurp "everybody_codes_e2024_q01_p3.txt")
     #_"xBxAAABCDxCC"
     (transduce (comp
                 (partition-all 3)
                 (map (fn [cs]
                        (+ (transduce
                            (map #(case % \D 5 \C 3 \B 1 (\A \x) 0))
                            +
                            cs)
                           (case (count (remove (partial = \x) cs))
                             3 6
                             2 2
                             (1 0) 0)))))
                +)
     println)
