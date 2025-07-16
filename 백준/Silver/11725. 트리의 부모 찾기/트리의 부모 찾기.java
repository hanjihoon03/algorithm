
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 16.
 */
public class Main {
  static int N;
  static boolean[] visited;
  static ArrayList<Integer>[] tree;
  static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1];
    tree = new ArrayList[N +1];
    answer = new int[N + 1];

    for (int i = 0; i < tree.length; i++) {
      tree[i] = new ArrayList<>();
    }


    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      tree[n1].add(n2);
      tree[n2].add(n1);
    }

    dfs(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(answer[i]);
    }
  }

  static void dfs(int num) {
    visited[num] = true;

    for (int i : tree[num]) {
      if (!visited[i]) {
        answer[i] = num;
        dfs(i);
      }
    }
  }

}
