package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main0517_11399 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sumArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //삽입 정렬 사용해보기
        for (int i = 1; i < n; i++) {
            int index = i;
            int val = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    index = j + 1;
                    break;
                }
                if (j == 0) {
                    index = 0;
                }
            }
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = val;
        }
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sumArr[i];
        }
        System.out.println(sum);
    }
}
