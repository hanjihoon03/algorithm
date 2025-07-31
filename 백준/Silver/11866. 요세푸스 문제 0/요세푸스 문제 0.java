
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 31.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();

    
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    while (!queue.isEmpty()) {
      for (int i = 0; i < k - 1; i++) {
        queue.offer(queue.poll());
      }
      
      sb.append(queue.poll());

      if (!queue.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append(">");
    System.out.println(sb);
  }
}
