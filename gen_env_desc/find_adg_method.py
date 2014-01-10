#!/usr/bin/env python
#encoding: UTF-8

__author__ = 'bl02515'


def find_adg_method(to_find_list, configed_adg_method_list):
    if not to_find_list or not configed_adg_method_list:
        return ""

    with open(configed_adg_method_list) as ref:
        ref_list = ref.readlines()

    with open(to_find_list) as to_find:
        #[(package, method), (package, method)]
        check_list = [(line.split(".")[-2][:5], line.split(".")[-1].strip(), line.strip())
            for line in to_find.readlines() if line.strip()]

    for check in check_list:
        for ref_line in ref_list:
            if check[0] in ref_line and check[1] in ref_line:
                print "#", check[2]
                break
        else:
            print check[2]

if __name__ == "__main__":
    find_adg_method(ur"f:\tmp\long_sql_methods.txt",
        ur"f:\tmp\adg_methods.txt")

