package cn.alien95.exam;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/9/18.
 */
public class Path {

    public static void main(String[] args) {
        int num;
        int distance[][];
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        distance = new int[num][num];
        scanner.nextLine();
        for (int i = 0; i < num; i ++){
            String s = scanner.nextLine();
            String[] strs = s.split(",");
            int[] temp = new int[num];
            for(int k = 0; k < strs.length; k ++){
                temp[k] = Integer.parseInt(strs[k]);
                for (int j = 0; j < num; j++){
                    distance[i][j] = temp[k];
                }
            }

        }

        int sum = 0;
        for(int i = 0; i < num - 1; i ++){
            sum += distance[i][i+1];
        }
        System.out.println(sum);
    }
}
