package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 07.
 */
public class Main_0607_4963 {
  static int[][] map;
  static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
  static boolean[][] visited;

  static int W,H,result;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    result = 0;

    while (W != 0 || H != 0) {
      map = new int[H][W];
      visited = new boolean[H][W];

      for (int i = 0; i < H; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
            result++;
          }
        }
      }
      System.out.println(result);
      result = 0;

      st = new StringTokenizer(br.readLine());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
    }
  }
  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
        if (map[nx][ny] == 1 && !visited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }
}
