package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main0514_2 {
    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    push(value);
                    break;
                case "pop":
                    pop();
                    break;
                case "top":
                    top();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
    }

    static void push(int num) {
        stack.add(num);
    }

    static void pop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.remove(stack.size() - 1));
        }
    }

    static void top() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.get(stack.size() - 1));
        }
    }

    static void size() {
        System.out.println(stack.size());
    }

    static void empty() {
        System.out.println(stack.isEmpty() ? 1 : 0);
    }
}
