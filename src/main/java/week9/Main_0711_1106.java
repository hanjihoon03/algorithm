package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 11.
 */
public class Main_0711_1106 {
  static int C, N;
  static int[] cost;
  static int[] customer;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    cost = new int[N];
    customer = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cost[i] = Integer.parseInt(st.nextToken());
      customer[i] = Integer.parseInt(st.nextToken());
    }

    // dp[i]: i명의 고객을 얻기 위한 최소 비용
    dp = new int[C + 101]; // 여유를 100만큼 줌 (customer[i] 최대 100이므로)
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < N; i++) {
      for (int j = customer[i]; j < dp.length; j++) {
        if (dp[j - customer[i]] != Integer.MAX_VALUE) {
          dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]);
        }
      }
    }

    // 정답: 고객 수가 C 이상인 것 중 최소 비용
    int answer = Integer.MAX_VALUE;
    for (int i = C; i < dp.length; i++) {
      answer = Math.min(answer, dp[i]);
    }

    System.out.println(answer);
  }
}
