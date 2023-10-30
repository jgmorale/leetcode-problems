
https://leetcode.com/problems/count-good-numbers/
class Solution {
    public int countGoodNumbers(long n) {
        // 1-digit primes [2, 3, 5, 7];
        // 1-digit evens  [0, 2, 4, 6, 8];
        // 1 digit 
        // 0, 2, 4, 6, 8
        // 2 digits
        // 02, 03, 05, 07, 22, 23, 25, 27, 42, 43, 45, 47, 62, 63, 65, 67, 82, 83, 85, 87
        /*
        long count = 1;
        long ansMod = Math.pow(10,9) + 7;
        for(long i = 0; i < n; i++){
            if (i % 2 == 0){
                count *= 5;
            } else {
                count *= 4;
            }
            count = (count % ansMod);
        }
        return (int) count;
        */
        return (int)(modPow(5, (n+1)/2) * modPow(4, n/2) % 1000000007);
        // Divide and conquer approach
        // (p*p*p*p)^2 = (p*p*p*p)*(p*p*p*p)
        // time complexity reduces to log(n)
    }

    long modPow(long x, long y){
        if (y == 0)
            return 1;
        long p = modPow(x, y/2);
        return p * p * (y % 2 > 0 ? x : 1) % 1000000007;
    }
}

// Notes:
// First though was about having an algorithm to know if a number was prime or not reread the problem)
// Second though was about checking all the numbers up to size n and see which ones are good number (felt not correct)
// Third though was about: "generating is faster than checking!" (we have the rules)
// How can we generate the numbers?
// Fourth though: Is it necessarily to generate the numbers? can we use recursion?
// countGoodNumbers = countGoodNumbers(n-1) + ???
// Fifth though: it seems is going to take me less time to generate them instead of finding the pattern for the recursive approach, so I am taking the generation approach.
// Sixth though: I think I can get the number of combinations per size because I have the rules.
// Some coding... debugging....aha! 
// hmm... time exceeded for case n = 806166225460393.... Do I need a formula to multiply faster?
// 4^n = (2^2)^n = 2^(2n) 00000000001 << 2n long primitive type has 64 of length
// 5^n = (2^2+1)^n ..... 