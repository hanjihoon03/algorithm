
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 25.
 */
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int count = 0;
    int number = 666;

    while (true) {
      if (String.valueOf(number).contains("666")) {
        count++;
        if (count == n) {
          System.out.println(number);
          break;
        }
      }
      number++;
    }
  }

}
