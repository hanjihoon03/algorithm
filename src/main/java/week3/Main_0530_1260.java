package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 30.
 */
public class Main_0530_1260 {

  static int N,M,V;
  static ArrayList<Integer>[] arr;
  static boolean[] visited;
  static Queue<Integer> queue = new LinkedList<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    arr = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      arr[S].add(E);
      arr[E].add(S);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(arr[i]);
    }

    dfs(V);
    System.out.println();
    visited = new boolean[N + 1];
    bfs(V);
    System.out.println();

  }

  static void dfs(int node) {
    System.out.print(node + " ");

    visited[node] = true;

    for (int i : arr[node]) {
      if (!visited[i]) {
        dfs(i);
      }
    }

  }
  static void bfs(int node) {
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      System.out.print(now + " ");
      for (int i : arr[now]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }

}
