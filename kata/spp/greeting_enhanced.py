#!/usr/bin/env python
#coding: UTF-8
__author__ = 'bl02515'

greeting_people = ['Alice', 'Bob', 'Bruce Lee']
while True:
    name = raw_input("what's your name: ")
    if 'q' == name:
        break
    if name in greeting_people:
        print("welcome {0}".format(name))
    else:
        print('sorry! you are not he people we want find')
