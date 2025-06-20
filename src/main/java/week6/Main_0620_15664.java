package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 20.
 */
public class Main_0620_15664 {

  static int[] arr,result;
  static int N,M;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    result = new int[M];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    dfs(0,0);
    System.out.print(sb);
  }
  static void dfs(int depth, int start) {
    if (depth == M){
      for (int i = 0; i < M; i++) {
        sb.append(result[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    int last = -1;

    for (int i = start; i < N; i++) {
      if (arr[i] == last) continue;

      result[depth] = arr[i];
      last = arr[i];

      dfs(depth + 1, i + 1);

    }
  }

}
