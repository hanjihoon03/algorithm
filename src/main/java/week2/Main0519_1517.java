package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//병합 정렬(nlogn)
//인덱스를 통해 n개 그룹으로 나누어 각 그룹을 정렬하며 합친다. 2개의 그룹 병합은 투 포인터로 진행
public class Main0519_1517 {

    static int[] arr, temp;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //1부터 시작하는 1-indexed 배열을 사용
        arr = new int[n + 1];
        temp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergetSort(1, n);

        System.out.println(result);
    }

    static void mergetSort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        //[s, e]를 절반으로 나누고 재귀 호출
        //분할할 수 없을 때까지 (1개 남을 때까지) 반복
        int m = s + (e - s) /2;
        mergetSort(s, m);
        mergetSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            temp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        //두 그룹 [s, m], [m+1, e]를 투 포인터 방식으로 비교
        //더 작은 값을 arr[k]에 채워 넣고, 포인터 증가
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                arr[k] = temp[index2];
                result += index2 - k;
                k++;
                index2++;
            } else {
                arr[k] = temp[index1];
                k++;
                index1++;
            }
        }
        //한쪽 포인터가 먼저 끝나면 나머지 값을 그대로 복사
        while (index1 <= m) {
            arr[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            arr[k] = temp[index2];
            k++;
            index2++;
        }

    }
}
