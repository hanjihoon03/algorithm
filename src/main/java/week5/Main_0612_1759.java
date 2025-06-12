package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : hanjihoon
 * @Date : 2025. 06. 12.
 */
public class Main_0612_1759 {
  static int L,C;
  static char[] arr;

  static final String vowels = "aeiou";
  static char[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new char[C];
    result = new char[L];

    String[] tokens = br.readLine().split(" ");
    for (int i = 0; i < C; i++) {
      arr[i] = tokens[i].charAt(0);
    }

    Arrays.sort(arr);
    dfs(0, 0);

  }
  static void dfs(int depth, int start) {
    if (depth == L) {
      // 모음, 자음 개수 세기 → 조건 만족하면 출력
      if (isValid()) {
        System.out.println(new String(result));
      }
      return;
    }

    for (int i = start; i < C; i++) {
      result[depth] = arr[i];
      dfs(depth + 1, i + 1); //다음 인덱스부터 시작
    }

  }
  static boolean isValid() {
    int vowel = 0;
    int con = 0;

    for (char c : result) {
      if (vowels.indexOf(c) >= 0) {
        vowel++;
      } else {
        con++;
      }
    }
    return vowel >= 1 && con >= 2;

  }


}
