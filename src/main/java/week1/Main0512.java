package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int req = Integer.parseInt(st.nextToken());
        int[][] arr = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArr = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 1; i <= req; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            long result = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];

            System.out.println(result);
        }


    }
}
