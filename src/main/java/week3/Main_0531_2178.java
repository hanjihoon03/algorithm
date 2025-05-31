package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 31.
 */
public class Main_0531_2178 {
  static int N,M;
  static int[][] map;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    bfs(0,0);
    System.out.println(map[N - 1][M - 1]);

  }

  static void bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {i, j});

    while (!queue.isEmpty()) {
      int now[] = queue.poll();
      visited[i][j] = true;

      for (int k = 0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];
        if (x >= 0 && y >= 0 && x < N && y < M) {
          if (map[x][y] != 0 && !visited[x][y]) {
            visited[x][y] = true;
            map[x][y] = map[now[0]][now[1]] + 1;
            queue.add(new int[] {x, y});
          }
        }
      }
    }
  }

}
