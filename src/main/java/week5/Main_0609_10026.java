package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 09.
 */
public class Main_0609_10026 {
  static int N,result,cvd;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    result = 0;
    cvd = 0;

    map = new char[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i,j,map[i][j]);
          result++;
        }
      }
    }


    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 'G') {
          map[i][j] = 'R'; // R과 G를 같은 색으로 취급
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i, j, map[i][j]);
          cvd++;
        }
      }
    }

    System.out.println(result + " " + cvd);
  }
  static void dfs(int x, int y, char color) {
    visited[x][y] = true;

    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
        if (map[nx][ny] == color && !visited[nx][ny]) {
          dfs(nx, ny, color);
        }
      }
    }

  }

}
