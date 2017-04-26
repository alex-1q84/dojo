# -*- coding: utf-8 -*-


class Node(object):
    def __init__(self, left=None, right=None, value=None):
        self.left = left
        self.right = right
        self.value = value

# a tree like this
#        1
#      2   3
#     4 5 6 7

root = Node(value=1)
root.left = Node(value=2)
root.right = Node(value=3)
root.left.left = Node(value=4)
root.left.right = Node(value=5)
root.right.left = Node(value=6)
root.right.right = Node(value=7)
