
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 23.
 */
public class Main{
  static int l;
  static int sx, sy, dx, dy;
  static int[][] dist;
  static int[] dxs = {1,2,2,1,-1,-2,-2,-1};
  static int[] dys = {2,1,-1,-2,-2,-1,1,2};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

    while (T-- > 0) {
      l = Integer.parseInt(br.readLine());
      dist = new int[l][l];
      for (int i = 0; i < l; i++) Arrays.fill(dist[i], -1);

      StringTokenizer st = new StringTokenizer(br.readLine());
      sx = Integer.parseInt(st.nextToken());
      sy = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      dx = Integer.parseInt(st.nextToken());
      dy = Integer.parseInt(st.nextToken());

      System.out.println(bfs());
    }
  }

  static int bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sx, sy});
    dist[sx][sy] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0], y = cur[1];

      if (x == dx && y == dy) {
        return dist[x][y];
      }

      for (int dir = 0; dir < 8; dir++) {
        int nx = x + dxs[dir];
        int ny = y + dys[dir];

        // 체스판 밖 벗어나면 스킵
        if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;

        if (dist[nx][ny] == -1) {
          dist[nx][ny] = dist[x][y] + 1;
          q.add(new int[]{nx, ny});
        }
      }
    }
    return -1;
  }
}

