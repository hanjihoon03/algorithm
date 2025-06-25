package week5;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 14.
 */
public class Solution {
  private static final long MOD = 10_000L;

  public long solution(long a, long b) {
    if (b == 0) return 1;
    a = a % MOD;
    if (a == 0) return 0;

    return modPow(a, b, MOD);
  }

  private long modPow(long base, long exp, long mod) {
    long result = 1;
    long cur = base;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * cur) % mod;
      }
      cur = (cur * cur) % mod;
      exp >>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.solution(2, 26)); // 8864
    System.out.println(sol.solution(123456789, 12345)); // 38549
  }
}

