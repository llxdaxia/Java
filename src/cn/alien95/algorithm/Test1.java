package cn.alien95.algorithm;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/3/28.
 */
public class Test1 {

    public static void main(String[] args) {
        int arrayNum;

        Scanner scanner = new Scanner(System.in);
        arrayNum = scanner.nextInt();
        int[][] data = new int[arrayNum][1000];
        int[] exchagenum = new int[arrayNum];

        for (int k = 0 ;k < arrayNum; k ++) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                data[k][i] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arrayNum; i++) {
            exchagenum[i] = bubbleSort(data[i]);
        }

        for(int i = 0 ;i < arrayNum ;i ++){
            System.out.println(exchagenum[i]);
        }

    }

    public static int bubbleSort(int[] data) {

        int temp;
        int exchange = 0;

        for (int i = 0; i < data.length && data[i] != '\0'; i++) {

            for (int j = i + 1; j < data.length && data[j] != '\0'; j++) {

                if (data[i] > data[j]) {

                    temp = data[i];

                    data[i] = data[j];

                    data[j] = temp;

                    exchange++;
                }

            }

        }

        return exchange;

    }


}
