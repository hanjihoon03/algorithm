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
public class MainEx {
  static ArrayList<Integer>[] arr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int dept = Integer.parseInt(br.readLine());

    arr = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<Integer>();
    }

    for (int i = 1; i <= dept; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      arr[s].add(e);
      arr[e].add(s);
    }

    int count = 0;
    dfs(1);
    for (int i = 2; i <= n; i++) {
      if (visited[i]) {
        count++;
      }
    }
    System.out.println(count);

  }
  static void dfs(int v) {
    //1 -> 2, 5
    //2 -> 1, 3, 5
    visited[v] = true;
    for (int i : arr[v]) {
      if (!visited[i]) {
        dfs(i);
      }
    }

  }

}
