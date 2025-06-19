package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 19.
 */
public class Main_0619_14891 {
  static int[][] gears;
  static int K,index,score,spin;
  final static int LEFT = 6;
  final static int RIGHT = 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    gears = new int[4][8];

    score = 0;

    for (int i = 0; i < 4; i++){
      String line = br.readLine();
      for (int j = 0; j < 8; j++){
        gears[i][j] = line.charAt(j) - '0';
      }
    }

    K = Integer.parseInt(br.readLine());

    for (int i = 1; i <= K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      index = Integer.parseInt(st.nextToken()) - 1;
      spin = Integer.parseInt(st.nextToken());

      int[] spinGears = new int[4];
      spinGears[index] = spin;

      for (int j = index - 1; j >= 0; j--) {
        if (gears[j][RIGHT] == gears[j + 1][LEFT]) break;
        spinGears[j] = - spinGears[j + 1];
      }

      for (int j = index + 1; j < 4; j++) {
        if (gears[j - 1][RIGHT] == gears[j][LEFT]) break;
        spinGears[j] = - spinGears[j - 1];
      }

      for (int j = 0; j < 4; j++) {
        if (spinGears[j] == 1) clockwise(gears[j]);
        else if (spinGears[j] == -1) counterClockwise(gears[j]);
      }

    }

    for (int i = 0; i < 4; i++) {
      if (gears[i][0] == 1) score += (1 << i);
    }
    System.out.println(score);

  }
  static void clockwise(int[] gear) {
    int temp = gear[7];
    for (int i = 7; i > 0; i--) {
      gear[i] = gear[i - 1];
    }
    gear[0] = temp;

  }
  static void counterClockwise(int[] gear) {
    int temp = gear[0];
    for (int i = 0; i < 7; i++) {
      gear[i] = gear[i + 1];
    }
    gear[7] = temp;
  }

}
