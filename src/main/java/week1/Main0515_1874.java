package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main0515_1874 {
    static int n = 0;
    static int count = 1;
    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean result = true;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int key = arr[i];

            if (key >= count) {
                while (key >= count) {
                    stack.push(count++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();

                if (pop > key) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) System.out.println(sb);

    }
}
