package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0512_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long[] count = new long[m];

        long result = 0;

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) (arr[i] % m);
            if (remainder == 0) result++;
            count[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (count[i] > 1) {
                result += (count[i] * (count[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}
