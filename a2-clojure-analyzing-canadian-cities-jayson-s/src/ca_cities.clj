(ns ca-cities
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def csv-file "data/ca.csv")
(defn- rad [degree] (* Math/PI (/ degree 180.)))

(defn reader []
  (io/reader "data/ca.csv"))

(defn parse-float [x]
  (Float/parseFloat x))

(defn parse-int [x]
  (Integer/parseInt x))

(defn parse-record [line]
    (map zipmap
      (->> (first line)
        (map keyword)
        repeat)
        (rest line)))

(defn cities []
  (with-open [rdr (reader)]
    (doall (next (line-seq rdr)))))

(defn city [name]
    (with-open [rdr (reader)]
    (first
      (for [line (drop 1 (line-seq rdr))
        :let [y (string/split line #",")]
        :when (= name (y 0))]
        line))))

(defn distance [record1 record2]
  (let [R 6371
       dlat (Math/toRadians (record1))
        dlon (Math/toRadians (record2))
        lolnice (Math/toRadians (record1))
        dnice (Math/toRadians (record2))
        a (+ (* (Math/sin (/ dlat 2)) (Math/sin (/ dlat 2))) (* (Math/sin (/ dlon 2)) (Math/sin (/ 
dlon 2)) (Math/cos lolnice) (Math/cos dnice)))]
    (* R 2 (Math/asin (Math/sqrt a)))))