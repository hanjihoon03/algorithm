
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 17.
 */
public class Main {
  static int N, answer, deletedNode;
  static ArrayList<Integer>[] tree;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    answer = 0;
    deletedNode = 0;
    N = Integer.parseInt(br.readLine());

    tree = new ArrayList[N];

    visited = new boolean[N];

    int root = 0;

    for (int i = 0; i < N; i++) {
      tree[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int p = Integer.parseInt(st.nextToken());
      if (p != -1) {
        tree[i].add(p);
        tree[p].add(i);
      } else {
        root = i;
      }
    }

    deletedNode = Integer.parseInt(br.readLine());

    if (deletedNode == root) {
      System.out.println(0);
    } else {
      dfs(root);
      System.out.println(answer);
    }

  }
  static void dfs(int num) {
    visited[num] = true;
    int cNode = 0;
    for (int i : tree[num]) {
      if (!visited[i] && i != deletedNode) {
        cNode++;
        dfs(i);
      }
    }

    if (cNode == 0) {
      answer++;
    }
  }
}
