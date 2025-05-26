package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 26.
 */
public class Main_0526_1926 {
  static int N,M,CNT,MAX;
  static int[][] map;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    CNT = 0;
    MAX = 0;

    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          CNT++;
          MAX = Math.max(MAX, dfs(i, j));
        }
      }
    }


    System.out.println(CNT);
    System.out.println(MAX);
  }

  static int dfs(int x, int y) {
    visited[x][y] = true;
    int size = 1;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
        if (!visited[nx][ny] && map[nx][ny] == 1) {
          size += dfs(nx, ny);
        }
      }
    }
    return size;
  }

}
