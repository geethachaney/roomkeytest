; This program computes the 10001th prime number;
; it makes use of a function isprime that checks if a number
; is prime or not.  it checks if any number in the range
; 2 to square root of number divides number evenly.

(defn isprime [ number]
   (let [rightindex (Math/ceil (Math/sqrt number))]
   (not-any? #(=(mod number %) 0) (range 2 (inc rightindex)))))

(defn prime10001 []
   ; first prime is 2 
   (loop [primeindex 1 numberchecked 2]
      (cond 
         (= primeindex 10001) 
            numberchecked
         (isprime (inc numberchecked))
            (recur (inc primeindex) (inc numberchecked))
         (not(isprime (inc numberchecked)))
            (recur primeindex (inc numberchecked)) )))

(println (prime10001))
