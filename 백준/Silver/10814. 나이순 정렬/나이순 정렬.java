
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 08. 04.
 */
public class Main {

  static class Member implements Comparable<Member> {
    int age;
    String name;
    int order;
    Member(int age, String name, int order) {
      this.age = age;
      this.name = name;
      this.order = order;
    }
    @Override
    public int compareTo(Member o) {
      if (this.age != o.age) return this.age - o.age;
      return this.order - o.order;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Member[] arr = new Member[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      arr[i] = new Member(age, name, i);
    }
    Arrays.sort(arr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (Member m : arr) {
      bw.write(m.age + " " + m.name + "\n");
    }
    bw.flush();
  }

}
