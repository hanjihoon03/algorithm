package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main0521_2606 {
    static ArrayList<Integer>[] arr;
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }
        int count = 0;
        dfs(1);
        for (int i = 2; i <= n; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count);
    }
    static void dfs(int v) {
        visited[v] = true;
        for (int next : arr[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
