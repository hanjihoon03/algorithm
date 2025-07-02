package week8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_0701_9466 {
    static int[] arr;
    static int T,N, result;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            result = 0;

            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 1; k <= N; k++) {
                if (!visited[k]) dfs(k);
            }

            System.out.println(N - result);

        }

    }
    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) {            // 처음 가는 정점
            dfs(next);
        } else if (!finished[next]) {    // 방문했지만 아직 DFS가 끝나지 않은 정점
            result++;                 // next부터 cur까지 차례로 세기
            for (int v = next; v != cur; v = arr[v]) result++;
        }

        finished[cur] = true;           // 이 정점의 DFS 종료
    }
}
