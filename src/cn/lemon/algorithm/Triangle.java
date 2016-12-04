package cn.lemon.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * Created by linlongxin on 2016.11.21.
 */
public class Triangle {

    public static void main(String[] args) {
        List<int[]> data = triangle(10);
        for (int[] array : data) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                System.out.printf(array[i] + " ");
            }
            System.out.println();
        }

        System.out.println(new int[]{1, 2, 3, 4, 5, 6, 7, 8}[5]);

    }


    public static List<int[]> triangle(int n) {
        List<int[]> result = new ArrayList<>();
        int[] cache = new int[0];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[i + 1];
            if (i == 0) {
                temp[i] = 1;
            } else if (i == 1) {
                temp[0] = 1;
                temp[1] = 1;
                cache = temp;
            } else {

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        temp[j] = 1;
                    } else{
                        temp[j] = cache[j - 1] + cache[j];
                    }
                }
                cache = temp;
            }
            result.add(temp);
        }
        return result;
    }
}