
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 07.
 */
public class Main {
  static long min,max;
  static long[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    min = Long.parseLong(st.nextToken());
    max = Long.parseLong(st.nextToken());

    arr = new long[10000001];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    for (int i = 2; i <= Math.sqrt(arr.length); i++) {
      if (arr[i] == 0) continue;

      for (int j = i + i; j < arr.length; j += i) arr[j] = 0;
    }

    int count = 0;
    for (int i = 2; i < 10000001; i++) {
      if (arr[i] != 0) {
        long temp = arr[i];
        while ((double)arr[i] <= (double)max /(double)temp) {
          if ((double) arr[i] >= (double) min / (double) temp) {
            count++;
          }
          temp = temp * arr[i];
        }
      }
    }

    System.out.println(count);

  }

}
