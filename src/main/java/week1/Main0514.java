package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 인덱스
 */
public class Main0514 {
    static int checkArr[];
    static int statusArr[];
    static int checkPassword;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] str = new char[s];
        checkArr = new int[4];
        statusArr = new int[4];
        checkPassword = 0;
        int result = 0;

        str = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkPassword++;
            }
        }

        for (int i = 0; i < p; i++) {
            Add(str[i]);
        }
        if (checkPassword == 4) result++;

        for (int i = p; i < s; i++) {
            int removeIndex = i - p;
            Add(str[i]);
            Remove(str[removeIndex]);
            if (checkPassword == 4) result++;
        }
        System.out.println(result);

    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (statusArr[0] == checkArr[0]) checkPassword--;
                statusArr[0]--;
                break;
            case 'C':
                if (statusArr[1] == checkArr[1]) checkPassword--;
                statusArr[1]--;
                break;
            case 'G':
                if (statusArr[2] == checkArr[2]) checkPassword--;
                statusArr[2]--;
                break;
            case 'T':
                if (statusArr[3] == checkArr[3]) checkPassword--;
                statusArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                statusArr[0]++;
                if (statusArr[0] == checkArr[0]) checkPassword++;
                break;
            case 'C':
                statusArr[1]++;
                if (statusArr[1] == checkArr[1]) checkPassword++;
                break;
            case 'G':
                statusArr[2]++;
                if (statusArr[2] == checkArr[2]) checkPassword++;
                break;
            case 'T':
                statusArr[3]++;
                if (statusArr[3] == checkArr[3]) checkPassword++;
                break;
        }
    }
}
