package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main0513Refac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;

        while (startIndex < n) {
            if (sum == n) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > n) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < n) {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);
    }
}
