#!/usr/bin/env python
#encoding: UTF-8
__author__ = 'bl02515'

import functools


def factor(number):
    return functools.reduce(lambda a, b: a * b, xrange(1, number + 1))

num = raw_input("please enter a number: ")
while True:
    try:
        if 'q' == num:
            break
        print('the factor multi of {0} is {1}'.format(num.strip(), factor(int(num.strip()))))
        num = raw_input("please enter a number: ")
    except:
        print("you've enter an incorrect nubmer")
        num = raw_input("please enter a number: ")
