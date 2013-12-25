#!/usr/bin/env python
# -*- coding: UTF-8 -*-

'''掷硬币输赢问题
描述：
同为正面：得3元
同为反面：得1元
不同面：  付2元'''

BOTH_FRONT_PAY = 3
BOTH_BACK_PAY = 1
DIFFER_END_PAY = -2

FRONT_RATING = 0.5
BACK_RATING = 0.5

both_front_rating = FRONT_RATING * FRONT_RATING
both_back_rating = BACK_RATING * BACK_RATING
differ_end_rating = FRONT_RATING * BACK_RATING * 2

each_round_pay = (both_front_rating * BOTH_FRONT_PAY +
                both_back_rating * BOTH_BACK_PAY +
                differ_end_rating * DIFFER_END_PAY)

print 'each round pay is: %f' % each_round_pay
