
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N,K;
    static long result, start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        start = 1;
        end = K;
        result = 0;

        while (start <= end) {
            long middle = (start + end) /2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }
            if (cnt < K) {
                start = middle + 1;
            } else {
                result = middle;
                end = middle - 1;
            }
        }

        System.out.println(result);
    }
}
