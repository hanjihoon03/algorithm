package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 02.
 */
public class Main_0602_1167 {
  static boolean[] visited;
  static int[] distance;
  static ArrayList<Edge>[] arr;
  static int N,S,E,V;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken());

      while (true) {
        E = Integer.parseInt(st.nextToken());
        if (E == -1) break;

        V = Integer.parseInt(st.nextToken());
        arr[S].add(new Edge(E, V));
      }
    }
    distance = new int[N + 1];
    visited = new boolean[N + 1];

    bfs(1);
    int max = 1;

    for (int i = 2; i <= N; i++) {
      if (distance[max] < distance[i]) max = i;
    }

    distance = new int[N + 1];
    visited = new boolean[N + 1];

    bfs(max);

    int answer = 0;
    for (int d : distance) {
      answer = Math.max(answer, d);
    }
    System.out.println(answer);

  }
  static void bfs(int index) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);

    visited[index] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (Edge i : arr[now]) {
        int e = i.e;
        int v = i.value;

        if (!visited[e]) {
          visited[e] = true;
          queue.add(e);
          distance[e] = distance[now] + v;
        }
      }
    }
  }

}
class Edge {
  int e;
  int value;

  public Edge(int e, int value) {
    this.e = e;
    this.value = value;
  }
}
