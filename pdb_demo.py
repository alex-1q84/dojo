'''
c: continue execution
w: shows the context of the current line it is executing.
a: print the argument list of the current function
s: Execute the current line and stop at the first possible occasion.
n: Continue execution until the next line in the current function is reached or it returns.
The difference between [n]ext and [s]tep is that step stops inside a called
function, while next executes called functions at (nearly) full speed, only
stopping at the next line in the current function.
'''
import pdb


def make_bread():
    pdb.set_trace()
    return "I don't have time"

print(make_bread())
