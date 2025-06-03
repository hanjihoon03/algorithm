package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 03.
 */
public class Main_0603_1920 {
  static int N,M,S;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    Arrays.sort(arr);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      S = Integer.parseInt(st.nextToken());
      boolean find = false;

      int start = 0;
      int end = arr.length - 1;
      while (start <= end) {
        int mid = (start + end) / 2;
        int midV = arr[mid];

        if (midV > S) {
          end = mid - 1;
        } else if (midV < S) {
          start = mid + 1;
        } else {
          find = true;
          break;
        }
      }
      if (find) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
      }
  }

}
