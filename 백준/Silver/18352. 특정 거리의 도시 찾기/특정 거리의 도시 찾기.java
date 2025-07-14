
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 14.
 */
public class Main {
  static int[] visited;
  static ArrayList<Integer>[] arr;
  static int N,M,K,X;
  static List<Integer> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N + 1];

    answer = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      arr[S].add(E);
    }
    visited = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      visited[i] = -1;
    }

    BFS(X);

    for (int i = 0; i <= N; i++) {
      if (visited[i] == K) answer.add(i);
    }

    if (answer.isEmpty()) {
      System.out.println("-1");
    } else {
      Collections.sort(answer);
      for (int temp:answer) {
        System.out.println(temp);
      }
    }
  }

  static void BFS(int Node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(Node);
    visited[Node]++;

    while (!queue.isEmpty()) {
      int now_Node = queue.poll();
      for (int i : arr[now_Node]) {
        if (visited[i] == -1) {
          visited[i] = visited[now_Node] + 1;
          queue.add(i);
        }
      }
    }
  }
}
