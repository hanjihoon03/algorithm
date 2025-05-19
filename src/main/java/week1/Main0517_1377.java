package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main0517_1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i) max = arr[i].index - i;
        }
        System.out.println(max + 1);
    }
}

class Data implements Comparable<Data> {
    int val;
    int index;

    public Data(int val, int index) {
        super();
        this.val = val;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.val - o.val;
    }
}
