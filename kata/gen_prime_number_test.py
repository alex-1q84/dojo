#!/usr/bin/env python
#-*- coding: UTF-8 -*-
import unittest
import gen_prime_number as g


class GenPrimeNumberTest(unittest.TestCase):

    def test_gen_prime_number_200(self):
        primes = g.gen_prime_num_list(200)
        for n in primes:
            self.assertEqual(True, g.isprime(n), n)
        #print ", ".join((str(n) for n in primes))

    #@unittest.skip("demonstrating skipping")
    def test_gen_prime_number_1000(self):
        primes = g.gen_prime_num_list(1000)
        for n in primes:
            self.assertEqual(True, g.isprime(n), n)

    #@unittest.skip("demonstrating skipping")
    def test_gen_prime_number_10000(self):
        primes = g.gen_prime_num_list(10000)
        for n in primes:
            self.assertEqual(True, g.isprime(n), n)

    #@unittest.skip("demonstrating skipping")
    def test_gen_prime_number_100000(self):
        primes = g.gen_prime_num_list(100000)
        for n in primes:
            self.assertEqual(True, g.isprime(n), n)

    #@unittest.skip("demonstrating skipping")
    def test_gen_prime_number_1000000(self):
        primes = g.gen_prime_num_list(1000000)
        for n in primes:
            self.assertEqual(True, g.isprime(n), n)

if __name__ == '__main__':
    unittest.main()
