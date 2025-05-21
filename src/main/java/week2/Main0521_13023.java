package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 21.
 */
public class Main0521_13023 {
  static ArrayList<Integer>[] arr;
  static boolean[] visited;

  static int N,M;

  static boolean isArrived = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N];
    visited =  new boolean[N];

    for (int i = 0; i < N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      arr[s].add(e);
      arr[e].add(s);
    }

    for (int i = 0; i < M; i++) {
      visited[i] = true;
      dfs(i,0);
      visited[i] = false;

      if (isArrived) {
        System.out.println(1);
        return;
      }
    }
    System.out.println(0);
  }
  static void dfs(int v, int dept) {
    if (dept == 4) {
      isArrived = true;
      return;
    }

    for (int next : arr[v]) {
      if (!visited[next]) {
        visited[next] = true;
        dfs(next, dept + 1);
        visited[next] = false; // 백트래킹
      }
    }
  }
}
