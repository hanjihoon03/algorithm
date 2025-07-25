package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0704_1929 {
    static int[] arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;

            for (int j = i + i; j <= N; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] != 0) System.out.println(arr[i]);
        }
    }
}
