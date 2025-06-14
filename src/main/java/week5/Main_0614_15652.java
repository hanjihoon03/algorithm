package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 14.
 */
public class Main_0614_15652 {
  static int[] arr;
  static int N,M;

  static boolean[] visited;
  static int[] res;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    res = new int[M];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    dfs(0);

  }

  static void dfs(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(res[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        res[depth] = arr[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }


  }

}
