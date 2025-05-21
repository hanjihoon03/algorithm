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
public class Main0521_1012 {
  static int[][] map;
  static boolean[][] visited;
  static int M, N, K;
  static int count;

  // 상하좌우 이동 좌표
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int test = 1; test <= t; test++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      map = new int[M][N];
      visited = new boolean[M][N];

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[x][y] = 1;
      }

      count = 0;

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && map[i][j] == 1) {
            dfs(i, j);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
        if (!visited[nx][ny] && map[nx][ny] == 1) {
          dfs(nx, ny);
        }
      }
    }
  }
}
