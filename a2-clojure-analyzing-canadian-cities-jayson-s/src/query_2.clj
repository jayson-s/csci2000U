(ns query-2
  (:require [ca-cities :as ca]))

; returns the total population of the cities
(defn total-population [cities]
	#(reduce + %)
	(map #(% cities)))

; list of sorted [province-name population] pairs
(defn provincial-population []
	(seq (into (sorted-map) {:key1 "pair1" :key2 "pair2"}))
  )
