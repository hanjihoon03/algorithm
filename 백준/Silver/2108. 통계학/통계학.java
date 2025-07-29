
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : hanjihoon
 * @Date : 2025. 07. 29.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    int[] counts = new int[8001];
    int sum = 0;

    int maxFreq = 0;
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
      sum += nums[i];
      counts[nums[i] + 4000]++;

      if (counts[nums[i] + 4000] > maxFreq) {
        maxFreq = counts[nums[i] + 4000];
      }
    }

    Arrays.sort(nums);

    // 산술평균 (소수 첫째 자리에서 반올림)
    int mean = (int) Math.round((double) sum / N);

    // 중앙값
    int median = nums[N / 2];

    // 최빈값
    List<Integer> modes = new ArrayList<>();
    for (int i = 0; i < 8001; i++) {
      if (counts[i] == maxFreq) {
        modes.add(i - 4000);
      }
    }

    int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);

    
    int range = nums[N - 1] - nums[0];
    
    System.out.println(mean);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(range);
  }
}
