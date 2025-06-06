package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 06.
 */
public class Main_0606_1303 {
  static char[][] map;
  static int N,M;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    int white = 0;
    int blue = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          int count = bfs(i, j, map[i][j]);
          if (map[i][j] == 'W') {
            white += count * count;
          } else {
            blue += count * count;
          }
        }
      }
    }
    System.out.println(white + " " + blue);

  }

  static int bfs(int x, int y, char color) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;
    int count = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (!visited[nx][ny] && map[nx][ny] == color) {
            visited[nx][ny] = true;
            queue.add(new int[]{nx, ny});
            count++;
          }
        }
      }
    }

    return count;
  }

}
