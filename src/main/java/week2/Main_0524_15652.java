package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 24.
 */
public class Main_0524_15652 {
  static int N,M,start;
  static int[] result;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];
    start = 0;

    dfs(0,1);

  }

  static void dfs(int dept, int start) {
    if (dept == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      start = 0;
      System.out.println();
      return;
    }


    for (int i = start; i <= N; i++) {
      result[dept] = i;
      dfs( dept + 1, i);
    }
  }

}
