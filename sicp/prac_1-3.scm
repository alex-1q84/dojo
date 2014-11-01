;; practice 1.3
;; 定义一个过程，它以三个数未参数，返回其中较大的两个数之和
(define (min a b) (if (< a b) a b))
(define (sum-max-tow x y z) (- (+ x y z)
                             (min x (min y z))))
