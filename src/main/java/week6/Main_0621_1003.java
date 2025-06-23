package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0621_1003 {
    static int T, N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        arr = new int[41][2];

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());


            int[] result = fibo(N);
            System.out.println(result[0] + " " + result[1]);
        }
    }
    static int[] fibo(int n) {
        if (arr[n][0] != 0 || arr[n][1] != 0 || n == 0) {
            return arr[n];
        }

        int[] left = fibo(n - 1);
        int[] right = fibo(n - 2);

        arr[n][0] = left[0] + right[0];
        arr[n][1] = left[1] + right[1];

        return arr[n];
    }
}
