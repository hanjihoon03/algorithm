
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 19.
 */
public class Main {
  static int N, res;
  static int[] diff;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    int[] curr = new int[N];
    int[] target = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      curr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      target[i] = Integer.parseInt(st.nextToken());
    }

    diff = new int[N];
    for (int i = 0; i < N; i++) {
      diff[i] = target[i] - curr[i];
    }

    res = 0;
    for (int i = 0; i < N; ) {
      if (diff[i] == 0) {
        i++;
        continue;
      }

      int sign = diff[i] > 0 ? 1 : -1;
      int j = i;
      int min = Math.abs(diff[i]);

      // 연속된 같은 방향(+/-) 찾기
      while (j < N && diff[j] * sign > 0) {
        min = Math.min(min, Math.abs(diff[j]));
        j++;
      }

      // 해당 구간 처리
      for (int k = i; k < j; k++) {
        diff[k] -= sign * min;
      }
      res += min;
    }

    System.out.println(res);
  }
}
