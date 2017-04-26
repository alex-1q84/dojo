;; Practice 1.11
;; 树形递归版本实现
(define (f n)
  (if (< n 3) n
      (+ (* 1 (f (- n 1)))
         (* 2 (f (- n 2)))
         (* 3 (f (- n 3))))))

(f -2) ;; -2
(f -1) ;; -1
(f 0)  ;; 0
(f 1)  ;; 1
(f 2)  ;; 2
(f 3)  ;; 4
(f 4)
(f 10)
;;(f 100) ;; 这个难以在可接受时间内执行完

;;迭代版本实现
(define (new-f n)
  (if (< n 3)
      n
      ;; f(0) f(1) f(2) f(n)
      (iter-f 0 1 2 n)
      ))

(define (iter-f a b c count)
  (if (< count 3)
      c
       ;;      f(1) f(2) f(3) count-1
       (iter-f b c (+ c (* 2 b) (* 3 a)) (- count 1))))

(new-f -2) ;; -2
(new-f -1) ;; -1
(new-f 0)  ;; 0
(new-f 1)  ;; 1
(new-f 2)  ;; 2
(new-f 3)  ;; 4
(new-f 4)
(new-f 10)
(new-f 100)