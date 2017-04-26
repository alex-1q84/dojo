;;exercise 1.7
;;牛顿法计算平方根
;;例如计算x的平方根,则给x的平方根一个猜测值y,辗转计算y和x/y的平均值,则这个y就是x的平方根
(define (sqrt-iter guess x)
  (if (good-enough? guess (improve guess x))
    guess
    (sqrt-iter (improve guess x) x))
  )

;通过比较两次迭代的值来计算是否起到足够优的值
;这种方式误差较大对于很大的数
(define (good-enough? guess next-guess)
  (< (abs (- guess next-guess)) 0.00000000000001)
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
(my-sqrt 0.0000000000000000002)
(* 4.4721378522049606e-10 4.4721378522049606e-10)
(my-sqrt 0.000000000000000000000000000000000000000000000000002)
(* 1.4210854715202004e-14 1.4210854715202004e-14)
(my-sqrt 12415155e100)
(* 3.5235145806424586e+53 3.5235145806424586e+53)