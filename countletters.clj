; program counts the letters in one to one thousand. spaces are ignored
; ones defines the number of letters in 1 to 9 and 0 for corresponding position
; 0 in the number
; tens defines the number of letters in ten, twenty .. ninety with 0 for corresponding
; position 0 in the number
; tento20 holds number of letters from 10 to 19.
; firstdigit represents the most significant digit in the 3 digit number
; seconddigit indicates the middle digit and thirddigit indicates the
; least significant digit

(def ones [ 0  3  3  5  4  4 3 5 5 4])
(def  tens [0  3 6 6 5  5 5 7 6 6])
(def tento20 [3 6  6 8 8 7 7 9 8 8] )
(def hundredand 10)
(def onethousand 11)
(def hundred 7)

(defn countletters [ ]
     
   (for [number (range 1 1000) 
      :let [  
         firstdigit (quot number 100) 
         seconddigit (quot (mod number 100) 10)
         thirddigit (mod number 10)
         lettercount 
                   (cond 
                        (and (not= firstdigit 0)
                          (= seconddigit 1))
                            (+  (get ones firstdigit) hundredand 
                                     (get tento20 (get ones thirddigit))) 
                         (and (not= firstdigit 0) (= seconddigit 0)
                              (= thirddigit 0))
                             (+ (get ones firstdigit) hundred) 
                         (and (not= firstdigit 0) (or (> seconddigit 1)
                                                  (and  (= seconddigit 0)
                                                    (not= thirddigit 0))))
                             (+ (get ones firstdigit) hundredand 
                                      (get tens seconddigit) 
                                      (get ones thirddigit))  
                          (and (= firstdigit 0) (= seconddigit 1))
                              (get tento20 (get ones thirddigit))
                          (and (= firstdigit 0) (not= seconddigit 1))
                              (+ (get tens seconddigit) (get ones thirddigit)) 
                                         )]] 
             lettercount ))                 
                             

(println (+ (apply + (countletters)) onethousand))
