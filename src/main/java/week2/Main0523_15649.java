package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 22.
 */
public class Main0523_15649 {
  static int N,M;
  static int[] result;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];
    visited = new boolean[N + 1];

    dfs(0);

  }
  static void dfs(int dept) {

    if (dept == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }


    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[dept] = i;
        dfs(dept + 1);
        visited[i] = false;
      }
    }
  }
}
