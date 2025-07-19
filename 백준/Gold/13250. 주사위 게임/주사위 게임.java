
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 19.
 */
public class Main {
  static int N;
  static final int DICE = 6;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());


    double[] dp = new double[N + DICE + 1];

    for (int i = N - 1; i >= 0; i--) {
      double sum = 0;
      for (int j = 1; j <= DICE; j++) {
        sum += dp[i + j];
      }
      dp[i] = 1 + sum / DICE;
    }

    System.out.printf("%.10f\n", dp[0]);
  }

}
