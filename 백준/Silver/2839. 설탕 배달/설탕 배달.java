
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 24.
 */
public class Main{

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    int result = -1;

    for (int five = N / 5; five >= 0; five--) {
      int rest = N - (five * 5);
      if (rest % 3 == 0) {
        int three = rest / 3;
        result = five + three;
        break;
      }
    }

    System.out.println(result);
  }
}
