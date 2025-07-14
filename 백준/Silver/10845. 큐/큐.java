
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 08.
 */
public class Main {
  static int N;
  static Deque<Integer> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    queue = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      String commandLine = br.readLine();
      String[] parts = commandLine.split(" ");

      String command = parts[0];

      switch (command){
        case "push":
          int value = Integer.parseInt(parts[1]);
          queue.offer(value);
          break;
        case "pop":
          System.out.println(queue.isEmpty() ? -1 : queue.poll());
          break;
        case "size":
          System.out.println(queue.size());
          break;
        case "empty":
          System.out.println(queue.isEmpty() ? 1 : 0);
          break;
        case "front":
          System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
          break;
        case "back":
          System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
          break;
      }
    }
  }

}
