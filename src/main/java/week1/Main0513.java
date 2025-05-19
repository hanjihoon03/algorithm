package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int startIndex = 1;
        int endIndex = 1;
        int sum = 0;
        int count = 1;

        while (startIndex < n) {
            if (sum == n) {
                count++;
                sum = 0;
                startIndex++;
                endIndex = startIndex;
            } else if (sum > n) {
                sum = 0;
                startIndex++;
                endIndex = startIndex;
            } else if (sum < n) {
                sum += endIndex;
                endIndex++;
            }
        }
        System.out.println(count);
    }
}
