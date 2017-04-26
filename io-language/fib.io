fib := method(num,
        if(num <= 0, return 0)
        if(num == 1, 1, fib(num - 1) + fib(num - 2))
        )

fib2 := method(num,
     prev := 0
     cur := 1
     if(num == 1, return cur, nil)
     for(i, 2, num,
            tmp := prev
            prev = cur
            cur = tmp + cur
     )
     cur
)

for(i, 1, 10,
       fib(i) println
)

for(i, 1, 1000,
       fib2(i) println
)
