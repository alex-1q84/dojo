;; practice 1.3
;; 定义一个过程，它以三个数未参数，返回其中较大的两个数之和
(define (my-min a b)
  (if (< a b) a b))

(define (sum-max-two x y z)
  (- (+ x y z)
     (my-min x (my-min y z))))

(sum-max-two 3 1 2)
(sum-max-two 2 2 3)
(sum-max-two 1 1 3)
(sum-max-two 0 0 3)
