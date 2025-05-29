package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 27.
 */
public class Main_0527_1388 {
  static int N,M,res;
  static String[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new String[N][M];
    visited = new boolean[N][M];
    res = 0;

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = String.valueOf(line.charAt(j));
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          res++;
        }
      }
    }
    System.out.println(res);

  }
  static void dfs(int x, int y) {
    visited[x][y] = true;
    String shape = map[x][y];

    if (shape.equals("-")) {
      int ny = y + 1;
      if (ny < M && !visited[x][ny] && map[x][ny].equals("-")) {
        dfs(x, ny);
      }
    } else if (shape.equals("|")) {
      int nx = x + 1;
      if (nx < N && !visited[nx][y] && map[nx][y].equals("|")) {
        dfs(nx, y);
      }
    }

  }

}
