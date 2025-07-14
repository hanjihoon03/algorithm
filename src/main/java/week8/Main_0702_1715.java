package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_0702_1715 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int N,A,B, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        result = 0;

        while (pq.size() != 1) {
            A = pq.remove();
            B = pq.remove();
            result += A + B;
            pq.add(A + B);
        }

        System.out.println(result);


    }
}
