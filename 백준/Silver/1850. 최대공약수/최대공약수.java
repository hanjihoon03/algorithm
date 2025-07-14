
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 10.
 */
public class Main {
  static long A,B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    A = Long.parseLong(st.nextToken());
    B = Long.parseLong(st.nextToken());
    
    
    long result = gcd(A,B);

    while (result > 0) {
      bw.write("1");
      result--;
    }
    bw.flush();
    bw.close();
    
  }
  static long gcd(long a, long b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }

}
