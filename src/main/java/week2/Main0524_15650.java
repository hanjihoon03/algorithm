package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 24.
 */
public class Main0524_15650 {
  static int N,M;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];

    dfs(1, 0);

  }
  static void dfs(int start, int dept) {
    if (dept == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i <= N; i++) {
      System.out.println("삽입 인덱스: " + dept + " 삽입 값: " + i);
      result[dept] = i;
      System.out.println("재귀: start: " + (i + 1) + ", dept: " + (dept + 1));
      dfs(i + 1, dept + 1);
      System.out.println("재귀 이후 처리 i: " + i + ", dept: " + dept);
    }
  }


}
