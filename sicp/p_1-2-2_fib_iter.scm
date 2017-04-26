;;define using iteration
(define (fib n)
  (define (fib-iter a b count)
    (if (= count 0)
        b
        (fib-iter (+ a b) a (- count 1))))
  (fib-iter 1 0 n))

(fib 0)
(fib 1)
(fib 2)
(fib 3)
(fib 5)
(fib 30)
(fib 100)
(fib 1000)
(fib 10000)