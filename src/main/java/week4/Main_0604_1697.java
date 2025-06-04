package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 04.
 */
public class Main_0604_1697 {
  static int N,K;
  static final int MAX = 100001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs(N,K));


  }
  static int bfs(int start, int target) {
    boolean[] visited = new boolean[MAX];
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(start, 0));
    visited[start] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      // 목표 위치 도달 시, 시간 반환
      if (current.pos == target) {
        return current.time;
      }

      int[] next = {current.pos - 1, current.pos + 1, current.pos * 2};
      for (int i : next) {
        if (i >= 0 && i < MAX && !visited[i]) {
          visited[i] = true;
          queue.add(new Node(i, current.time + 1));
        }
      }

    }
      return -1;
  }


}

class Node {
  int pos;
  int time;

  public Node(int pos, int time) {
    this.pos = pos;
    this.time = time;
  }
}

