#!/usr/bin/env python
#-*- coding: UTF-8 -*-
import math

_baseprime = [2, 3, 5, 7, 11]


def filter_basic_prime(nums):
    result = []
    for n in nums:
        if not isdivisible_by_baseprime(n):
            result.append(n)
    return result


def isdivisible_by_baseprime(number):
    for i in _baseprime:
        if number != i and isdivisible(number, i):
            return True
    return False


def isdivisible(dividend, divisor):
    return divisor != 0 and dividend % divisor == 0


def isprime(number):
    '''
    >>> isprime(0)
    False
    >>> isprime(1)
    False
    >>> isprime(2)
    True
    >>> isprime(4)
    False
    >>> isprime(7)
    True
    >>> isprime(9)
    False
    '''
    if number == 0 or number == 1:
        return False
    maxnum = int(math.ceil(math.sqrt(number)))
    for n in xrange(2, maxnum + 1):
        if number % n == 0 and n != number:
            return False
    return True


def gen_prime_num_list(max):
    if max < 2:
        return []

    def is_all_prime(last_prime, numlist):
        return pow(last_prime, 2) >= numlist[-1]

    nums = filter_basic_prime(xrange(2, max))
    if is_all_prime(_baseprime[-1], nums):
        #print 'the nums list is all prime number'
        return nums

    index = len(_baseprime) - 1
    while(True):
        #print "index %d" % index
        #print ", ".join((str(i) for i in nums))
        n = nums[index]
        #print "num %d" % n
        if isprime(n):
            temp_nums = []
            for i in nums:
                if n == i or not isdivisible(i, n):
                    temp_nums.append(i)
            nums = temp_nums
            if is_all_prime(n, nums):
                #print 'the nums list is all prime number ...'
                break

        index += 1

    return nums


def _test():
    import doctest
    doctest.testmod()

if __name__ == '__main__':
#        _test()
    print ",".join((str(n) for n in gen_prime_num_list(10000)))
