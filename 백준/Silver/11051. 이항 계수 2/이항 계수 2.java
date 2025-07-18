
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 18.
 */
public class Main {
  static int N,K;
  static int[][] arr;
  static final int MOD = 10007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      arr[i][1] = i;
      arr[i][0] = 1;
      arr[i][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 1; j < i; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
        arr[i][j] = arr[i][j] % MOD;
      }
    }

    System.out.println(arr[N][K]);
  }

}
