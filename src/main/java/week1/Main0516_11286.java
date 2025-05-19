package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main0516_11286 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<>((first, second) -> {
            int first_abs = Math.abs(first);
            int second_abs = Math.abs(second);

            if (first_abs == second_abs) return first > second ? 1 : -1;
            else return first_abs - second_abs;
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int req = Integer.parseInt(br.readLine());

            if (req == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(req);
            }
        }
    }
}
