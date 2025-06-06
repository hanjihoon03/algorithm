package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 05.
 */
public class Main_0605_7576 {
  static int[][] map;
  static int N, M;
  static int[][] days;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    days = new int[N][M];

    Queue<Point> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          queue.add(new Point(i, j));
        }
      }
    }

    bfs(queue);

    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        result = Math.max(result, days[i][j]);
      }
    }

    System.out.println(result);
  }

  static void bfs(Queue<Point> queue) {

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      for (int d = 0; d < 4; d++) {
        int nx = p.x + dx[d];
        int ny = p.y + dy[d];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (map[nx][ny] == 0) {
            map[nx][ny] = 1; // 익히기
            days[nx][ny] = days[p.x][p.y] + 1;
            queue.add(new Point(nx, ny));
          }
        }
      }
    }
  }

}
