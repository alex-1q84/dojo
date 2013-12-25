#!/usr/bin/env python
#coding: UTF-8
__author__ = 'bl02515'

while True:
    name = raw_input("what's your name: ")
    if 'q' == name:
        break
    if name:
        print("welcome {0}".format(name))
