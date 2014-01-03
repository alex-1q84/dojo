#!/usr/bin/env python
#encoding: UTF-8
__author__ = 'bl02515'

import functools
import sys


def factor(number, function):
    return functools.reduce(lambda a, b: function(a, b), xrange(1, number + 1))

functions = {'*':(lambda a, b: a*b), '+': (lambda a, b: a + b)}
num = raw_input("please enter a number: ")
while True:
    try:
        if 'q' == num:
            break
        num = num.strip()
        method = raw_input('please chose a function * or + : ')
        operator = functions.get(method.strip(), None)
        if operator:
            print('the factor multi of {0} is {1}'.format(num, factor(operator, int(num))))
        num = raw_input("please enter a number: ")
    except:
        print("you've enter an incorrect nubmer")
        num = raw_input("please enter a number: ")
        print(sys.exc_info()[0])
