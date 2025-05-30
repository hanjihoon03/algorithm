package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main0517_1427 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i,i + 1));
        }
        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j =  i + 1; j < str.length(); j++) {
                if (arr[j] > arr[max]) max = j;
                if (arr[i] < arr[max]) {
                    temp = arr[i];
                    arr[i] = arr[max];
                    arr[max] = temp;
                }
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
