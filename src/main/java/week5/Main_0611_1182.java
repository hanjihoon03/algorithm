package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 11.
 */
public class Main_0611_1182 {
  static int N,S,result;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    result = 0;

    dfs(0, 0);

    // 공집합인 경우 (선택 안 한 것) 제외
    if (S == 0) result--;

    System.out.println(result);
  }
  static void dfs(int index, int sum) {
    if (index == N) {
      if (sum == S) result++;
      return;
    }

    dfs(index + 1, sum + arr[index]);

    dfs(index + 1, sum);
  }

}
