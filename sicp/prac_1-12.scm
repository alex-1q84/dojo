;; Practice 1.12
;; 帕斯卡三角形
;;            1
;;          1   1
;;        1   2   1
;;      1   3   3   1
;;    1   4   6   4   1
;;  1   5  10  10   5   1
;; 递归版本实现
(define (pascal-tri row col)
  (if (or (= col 1) (= col row))
      1
      (+ (pascal-tri (- row 1) (- col 1))
         (pascal-tri (- row 1) col))))

(pascal-tri 1 1)
(pascal-tri 2 1)
(pascal-tri 2 2)
(pascal-tri 3 2)
(pascal-tri 4 2)
(pascal-tri 4 3)
(pascal-tri 5 3)
(pascal-tri 5 4)
(pascal-tri 6 3)
(pascal-tri 6 4)
(pascal-tri 6 5)
(pascal-tri 6 6)
(pascal-tri 10 5)
;; (pascal-tri 100 50) ;; 这个难以在可接受时间内执行完成

;; 迭代版本实现
(define (pascal-tri row col)
  (if (or (= col 1) (= col row))
      1
      (+ (pascal-tri (- row 1) (- col 1))
         (pascal-tri (- row 1) col))))