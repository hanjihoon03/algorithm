package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 05. 22.
 */
public class Main0522_2267 {
  static int[][] map;
  static boolean[][] visited;
  static int N;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    List<Integer> complexList = new ArrayList<>();
    int totalComplex = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          int count = dfs(i, j);
          complexList.add(count);
          totalComplex++;
        }
      }
    }

    System.out.println(totalComplex);
    Collections.sort(complexList);
    for (int count : complexList) {
      System.out.println(count);
    }

  }

  static int dfs(int x, int y) {
    //범위 밖이면 리턴
    if (x < 0 || y < 0 || x >= N || y >= N) return 0;

    //이미 방문했거나 집이 아니면 리턴
    if (visited[x][y] || map[x][y] == 0) return 0;

    visited[x][y] = true;
    int count = 1;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      count += dfs(nx, ny);
    }

    return count;

  }
}
