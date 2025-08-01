
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 08. 01.
 */
public class Main{
  static int T, N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 문서 개수
      M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 인덱스

      Queue<int[]> queue = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int priority = Integer.parseInt(st.nextToken());
        queue.offer(new int[]{j, priority});  // [문서의 위치, 중요도]
        pq.offer(priority);  // 중요도만 저장 (최고 우선순위 확인용)
      }

      int order = 0;

      while (!queue.isEmpty()) {
        int[] current = queue.poll();

        // 현재 문서보다 중요도가 더 높은 문서가 있다면 다시 뒤로 보냄
        if (current[1] < pq.peek()) {
          queue.offer(current);
        } else {
          // 인쇄
          pq.poll();
          order++;

          // 궁금한 문서라면 출력
          if (current[0] == M) {
            System.out.println(order);
            break;
          }
        }
      }
    }
  }
}
