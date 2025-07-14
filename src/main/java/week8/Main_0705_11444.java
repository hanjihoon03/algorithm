package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0705_11444 {
    static long N;
    static final long A = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        // Fn = Fn-1 + Fn-2
        //ex n= 1000 = f999 + f998
        //반 쪼개서 하면 될 듯?
        System.out.println(fib(N)[0]);

    }
    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] half = fib(n/2);
        long a = half[0]; // F(k) = F(n/2)
        long b = half[1]; // F(k+1) = F(n/2 + 1)

        long c = (a * ((2 * b % A - a + A) % A)) % A; // F(2n)
        long d = (a * a % A + b * b % A) % A;// F(2n+1)

        return (n % 2 == 0)
                ? new long[]{c, d}// (F(2n), F(2n+1))
                : new long[]{d, (c + d) % A};//F(2n+1))
    }
}
