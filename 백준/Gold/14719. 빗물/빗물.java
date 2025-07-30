
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 30.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[] height = new int[W];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < W; i++) {
      height[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    for (int i = 1; i < W - 1; i++) {
      int leftMax = 0;
      int rightMax = 0;

      for (int l = 0; l < i; l++) {
        leftMax = Math.max(leftMax, height[l]);
      }
      for (int r = i + 1; r < W; r++) {
        rightMax = Math.max(rightMax, height[r]);
      }

      int min = Math.min(leftMax, rightMax);
      if (min > height[i]) {
        result += min - height[i];
      }
    }

    System.out.println(result);
  }
}
