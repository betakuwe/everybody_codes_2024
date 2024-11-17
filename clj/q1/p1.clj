(->> (slurp "everybody_codes_e2024_q01_p1.txt")
     (transduce (map #(case % \C 3 \B 1 \A 0))
                +)
     println)
