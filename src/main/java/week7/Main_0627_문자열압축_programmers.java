package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0627_문자열압축_programmers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));

    }
    static int solution(String s) {
        //dp -> 0으로 초기화 후 중복만 카운트 하면?
        //aabbaccc
        //2일때 11110011 -> 2a2bac2c
        //3일때 00000111 -> aabba3c
        // 만약 aabbacccc(9)라면?
        // 2일때 2a2ba4c -> 12/12/0/1234 [2+2+1+2] -> 7

        //ex) aabbaccc
        // 2로 자르면 인덱스 2개씩 잘라서 같은지 보고 바꿔야함 -> aabb -> 2a2b
        //3이면 -> aabba3c
        // aabbaccc
        // 2로 자르면 2a2bac2c -> 8
        // 3은 aabba3c -> 7

        int minLength = s.length(); // 기본값: 압축이 안 되는 경우

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int i = len; i < s.length(); i += len) {
                // 다음 블록 추출
                String current;
                if (i + len <= s.length()) {
                    current = s.substring(i, i + len);
                } else {
                    current = s.substring(i);
                }

                // 이전 블록과 같으면 count 증가
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 다르면 지금까지 압축하고 초기화
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 블록 처리
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
