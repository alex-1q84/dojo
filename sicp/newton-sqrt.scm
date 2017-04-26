;;牛顿法计算平方根
;;例如计算x的平方根，则给x的平方根一个猜测值y，辗转计算y和x/y的平均值，则这个y就是x的平方根
(define (sqrt-iter guess x)
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x))
  )

(define (good-enough? guess x)
  (< (abs (- (* guess guess) x)) 0.0001)
  )

(define (improve guess x)
  (avarage guess (/ x guess)))

(define (avarage x y)
  (/ (+ x y) 2))

(define (my-sqrt x)
  (sqrt-iter 1.0 x))

(sqrt-iter 1.0 3)
(sqrt-iter 1.0 1)
(sqrt-iter 1.0 4)
(sqrt-iter 1.0 2)

(my-sqrt 3)
(my-sqrt 1)
(my-sqrt 4)
(my-sqrt 2)