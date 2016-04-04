package cn.alien95.algorithm;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/3/28.
 */
public class Test2 {

    public static void main(String[] args) {
        int legNum; //桌腿总数
        Scanner scanner = new Scanner(System.in);
        legNum = scanner.nextInt();
        int[] legsLength = new int[legNum];
        int[] legsCosts = new int[legNum];
        for(int i =0 ;i < legNum ;i ++){
            legsLength[i] = scanner.nextInt();
        }
        for(int i =0 ;i < legNum ;i ++){
            legsCosts[i] = scanner.nextInt();
        }

        System.out.println(costsSum(legNum,legsLength,legsCosts));



    }

    public static int costsSum(int num,int[] legsLength,int[] legsCosts){
        int[] data = new int[num];
        int cost = 0;

        for(int i =0 ;i < num;i ++){
            for(int j = 0; j < num;j ++){
                if(legsLength[i] == legsLength[j]){
                    data[i] ++;
                }
            }
        }
        int max = getMax(data);
        int index = getIndex(data,max);

        if(max > legsLength.length / 2){
            for(int i =0 ;i < num;i ++){
                if(legsLength[i] < legsLength[index]){
                    cost += legsCosts[i];
                }
            }
            return cost;
        }


        return -1;
    }


    public static int getIndex(int[] data,int max){
        for (int x = 1; x < data.length; x++) {
            if(data[x] == max){
                return x;
            }
        }
        return -1;
    }

    public static int getMax(int[] arr) {

        int max = arr[0];

        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max)
                max = arr[x];

        }
        return max;

    }
}
