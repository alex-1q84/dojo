#!/usr/bin/env python
#encoding: UTF-8

"""检出执行时间很长的sql"""

__author__ = 'bl02515'

import re
import sys


begin = re.compile(r'.*DAO.*\|(\d+)\|\s+ms$')

end_keyword = re.compile(r'.*(\bINFO\b|\bWARN\b|\bERROR\b).*')
select_sql_keyword = re.compile(r'.*\bselect\b.*', re.IGNORECASE)


def pick_long_time_sql(log_file, valve=0, out=sys.stdout):
    enter_sql = False
    with open(log_file) as log:
        sql = []
        for line in log:
            try:
                striped = line.strip()[25:]
            except IndexError:
                striped = ""
            begin_match = begin.match(striped)
            if striped and begin_match and int(begin_match.groups()[0]) > valve:
                enter_sql = True
            elif (striped and end_keyword.match(striped)
                    and not select_sql_keyword.match(striped)):
                enter_sql = False

            if striped and enter_sql:
                sql.append(striped)

            if not enter_sql and sql:
                # write out sql then empty the sql list
                out.write('\n'.join(sql).decode('UTF-8').encode('GBK'))
                out.write('\n')
                sql = []


if __name__ == '__main__':
    import sys
    if len(sys.argv) > 1:
        for logfile in sys.argv[1:]:
            pick_long_time_sql(logfile, valve=1000000)
    else:
        print "Usage: {0} log1 [log2 log3 ...]".format(sys.argv[0])
