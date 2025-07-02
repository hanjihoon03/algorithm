package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0630_1987 {
    static char[][] arr;
    static boolean[] used;
    static int R,C,result;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        result = 0;
        used = new boolean[26];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        used[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(result);
    }
    static void dfs(int x, int y, int depth) {
        result = Math.max(result, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            int idx = arr[nx][ny] - 'A';
            if (used[idx]) continue;

            used[idx] = true;
            dfs(nx, ny, depth + 1);
            used[idx] = false;
        }

    }
}
