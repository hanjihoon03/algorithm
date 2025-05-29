package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 29.
 */
public class Main_0529_2468 {

  static int N, MAX;
  static boolean[][] visited;
  static int[][] map;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];

    int maxHeight = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, map[i][j]);
      }
    }

    MAX = 0;

    for (int h = 0; h <= maxHeight; h++) {
      visited = new boolean[N][N];
      int cnt = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && map[i][j] > h) {
            dfs(i, j, h);
            cnt++;
          }
        }
      }

      MAX = Math.max(MAX, cnt);
    }

    System.out.println(MAX);
  }
  static void dfs(int x, int y, int height) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
        if (!visited[nx][ny] && map[nx][ny] > height) {
          dfs(nx, ny, height);
        }
      }
    }

  }
}

