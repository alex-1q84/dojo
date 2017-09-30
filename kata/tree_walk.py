# -*- coding: utf-8 -*-
from collections import deque
''' a tree like this
             1
        2          3
     4    5     6     7
    8 9 10 11 12 13 14 15
'''


class Node(object):
    def __init__(self, left=None, right=None, value=None):
        self.left = left
        self.right = right
        self.value = value


root = Node(value=1)

root.left = Node(value=2)
root.right = Node(value=3)

root.left.left = Node(value=4)
root.left.right = Node(value=5)
root.right.left = Node(value=6)
root.right.right = Node(value=7)

root.left.left.left = Node(value=8)
root.left.left.right = Node(value=9)
root.left.right.left = Node(value=10)
root.left.right.right = Node(value=11)
root.right.left.left = Node(value=12)
root.right.left.right = Node(value=13)
root.right.right.left = Node(value=14)
root.right.right.right = Node(value=15)


def walk_tree(root):
    if root:
        print root.value
    if root.left:
        walk_tree(root.left)
    if root.right:
        walk_tree(root.right)


def walk_tree_reverser(root):
    if root.left:
        walk_tree_reverser(root.left)
    if root.right:
        walk_tree_reverser(root.right)
    if root:
        print root.value


stack = []


def walk_tree_depth_first(root):
    if root:
        stack.append(root)
    while stack:
        node = stack.pop()
        print node.value
        if node.left:
            stack.append(node.left)
        if node.right:
            stack.append(node.right)


queue = deque()


def walk_tree_width_first(root):
    if root:
        queue.append(root)
    while queue:
        node = queue.popleft()
        print node.value
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)


# walk_tree(root)
# walk_tree_reverser(root)
# walk_tree_depth_first(root)
walk_tree_width_first(root)
