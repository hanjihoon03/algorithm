package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//기수정렬
// 값을 비교하지 않는 정렬 (Okn) k= 데이터 자릿수
//10개의 큐를 사용한다. 각 큐는 값의 자릿수를 대표한다.
public class Main0519_10989 {

    static int[] arr;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radix_Sort(arr, 5);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void radix_Sort(int[] arr, int maxSize) {
        //maxSize = 입력 값 최대 자릿수가 10,000이기 때문에
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) {
            int[] bucket = new int[10];

            for (int i = 0; i < arr.length; i++) {
                bucket[arr[i] / jarisu % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[arr[i] / jarisu % 10] - 1] = arr[i];
                bucket[arr[i] / jarisu % 10]--;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
