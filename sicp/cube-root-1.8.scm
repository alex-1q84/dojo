;;exercise 1.7
;;牛顿法计算立方根
;;例如计算x的立方根,则给x的立方根一个猜测值y,辗转计算2y和x/(y^2)的平均值,则这个y就是x的立方根
(define (cube-root-iter guess x)
  (if (good-enough? guess x)
    guess
    (cube-root-iter (improve guess x) x))
  )

(define (good-enough? guess x)
  (< (abs (- (cube guess) x)) 1e-10))

(define (cube guess)
  (* guess guess guess))
;通过比较两次迭代的值来计算是否起到足够优的值
;这种方式误差较大对于很大的数
;(define (good-enough? guess next-guess)
;  (< (abs (- guess next-guess)) 0.000000000000001)
;  )

(define (improve guess x)
  (/ (+ (/ x (square guess))
        (* 2 guess))
     3))

(define (square x)
  (* x x))

(define (cube-root x)
  (cube-root-iter 1.0 x))

(cube-root 8)
(cube-root 3)
(cube-root 1)
(cube-root 4)
(cube-root 2)
(cube-root 0.0000000000000000002)
(* 4.4721378522049606e-10 4.4721378522049606e-10)
(cube-root 0.000000000000000000000000000000000000000000000000002)
(* 1.4210854715202004e-14 1.4210854715202004e-14)
(cube-root 12415155e100)
(* 3.5235145806424586e+53 3.5235145806424586e+53)