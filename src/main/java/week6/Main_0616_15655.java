package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 16.
 */
public class Main_0616_15655 {
  static int[] arr;
  static int N,M;
  static boolean[] visited;
  static int[] result;

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

    dfs(0, 0);

  }

  static void dfs(int depth, int index){
    if (depth == M){
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = index; i < N; i++){
      if (!visited[index]){
        visited[index] = true;
        result[depth] = arr[i];
        dfs(depth + 1, i + 1);
        visited[index] = false;
      }
    }


  }

}
