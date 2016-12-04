package cn.alien95.exam;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/9/18.
 */
public class Search {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(result(n));
    }

    static int result(int n)
    {
        int num = 0;
        int i, j;

        for (i = 5; i <= n; i += 5)
        {
            j = i;
            while (j % 5 == 0)
            {
                num++;
                j /= 5;
            }
        }

        return num;

    }
}
