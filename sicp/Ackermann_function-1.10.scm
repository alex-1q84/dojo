;;exercise 1.10
(define (A x y)
  (cond ((= y 0) 0)
        ((= x 0) (* 2 y))
        ((= y 1) 2)
        (else (A (- x 1)
                 (A x (- y 1))))))

(A 1 10)
(A 1 4)
(A 2 4)
(A 1 16)
(A 3 3)
(A 2 5) ;;超大值

;;see https://en.wikipedia.org/wiki/Ackermann_function
(define (nA m n)
  (cond ((= m 0) (+ n 1))
        ((= n 0) (nA (- m 1) 1))
        (else (nA (- m 1) (nA m (- n 1))))))

(nA 1 2)
(nA 1 10)
(nA 1 4)
(nA 1 15)
(nA 3 3)
;(nA 4 3)