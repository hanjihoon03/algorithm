package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0513_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = n - 1;
        int count = 0;

        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] == m) {
                count++;
                startIndex++;
                endIndex--;
            } else if (arr[startIndex] + arr[endIndex] < m) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > m) {
                endIndex--;
            }
        }
        System.out.println(count);
    }
}
