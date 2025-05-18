package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main0513_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        for (int i = 0; i < n; i++) {
            long find = arr[i];

            int startIndex = 0;
            int endIndex = n - 1;

            while (startIndex < endIndex) {
                if (arr[startIndex] + arr[endIndex] == find) {
                    if (startIndex != i && endIndex != i) {
                        count++;
                        break;
                    }else if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                } else if (arr[startIndex] + arr[endIndex] < find) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }
        System.out.println(count);


    }
}
