package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main0515_17298 {
    static int n = 0;
    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] resultArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                resultArr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            resultArr[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(resultArr[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
