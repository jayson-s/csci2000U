(ns query-1
  (:require [ca-cities :as ca]))

; check if the city has more than 0.5E6 people
(defn large? [city]
	(let [x 500000]
  		(cond
   			(> city x) "city has more than 500,000 people")))

; check if the two cities are no more than 600 km apart
(defn close? [c1 c2]
	(if (< (and c1 c2) 600)))

; find distinct pairs of city names of *large* cities
; that are close.
(defn closest-city-pairs []
  (with-open [rdr (reader)]
    (vec
      (for [line (drop 1 (line-seq rdr))
            :let [y (string/split line #",")]
            :when (= true (large(y 0)))]
        (let [newVec (conj [] (y 0))]
          (for[x newVec
               y newVec
               :when (= true (close x y))]
            	:let [newNewVec (conj [] (x y))]
              	(println newNewVec)))))))