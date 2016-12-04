package cn.lemon.algorithm;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/3/22.
 */
public class Game {

    public static void main(String[] args) {
        int monsterNum,energyValue;
        Scanner scanner = new Scanner(System.in);
        monsterNum = scanner.nextInt();
        energyValue = scanner.nextInt();
        for(int i = 0;i < monsterNum; i ++){
            int defenseValue = scanner.nextInt();
            if(defenseValue <= energyValue){
                energyValue += defenseValue;
            }else {
                energyValue += getGCD(defenseValue,energyValue);
            }
        }
        System.out.println(energyValue);

    }


    //获取最大公约数
    public static int getGCD(int m,int n){
        int  temp;
        if (m < n){
            temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0 ){
            temp = n;
            n = m % n;
            m = temp;
        }
        return  n;
    }
}
