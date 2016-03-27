; Author : Geetha Chaney
; This program computes the two largest 3-digit number whose
; product is a palindrome
; Method : Largest 3 digit number starts at 999 and continue
;          downwards by 1 all the way to 100 if not found
;          and it stops once a palindrome is found for a product.
;          Since it starts from 999, the pair found is the highest
;          ones. Two helper functions are written : one to find the
;          reverse of a 6 digit number (max length of the product of
;          two 3 digit number is 6 digits) and another to check if
;          a number (6 digit) is a palindrome. 

( defn revers1 [number] ;reverse a number (6 digit)
   (loop [n number revers 0]
      ( if (= 0 n) 
         revers
         (recur(quot n 10)(+ (* revers 10)(mod n 10))))))
;
(defn ispalindrome [number]
   (if (= number (revers1 number))
      true
      false))
;
(defn testproduct []
   (loop [m 999 n 999]
      (cond
         (ispalindrome (* m n)) [m n (* m n)]
         (or (< m 100)(and (= m 100)(< n 100))) [0 0 0]
         (and (>= m 100) (< n 100)) (recur (dec m)  m) ;sufficient check 
                                                       ;m*n = n*m
         (and (>= m 100)(>= n 100)) (recur m (dec n))))) 
(println (testproduct))

