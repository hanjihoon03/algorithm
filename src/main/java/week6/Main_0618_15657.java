package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 18.
 */
public class Main_0618_15657 {
  static int[] arr;
  static int N,M;
  static int[] result;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    result = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    dfs(0,0);

    System.out.print(sb);
  }
  static void dfs(int depth, int index){
    if (depth == M){
      for (int i = 0; i < M; i++){
        sb.append(result[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = index; i < N; i++){
      result[depth] = arr[index];
      dfs(depth + 1, index);
      index += 1;
    }
  }

}
