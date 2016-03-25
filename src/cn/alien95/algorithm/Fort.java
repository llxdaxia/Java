package cn.alien95.algorithm;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/3/22.
 */
public class Fort {

    public static void main(String[] args) {
        int killValue = 0;
        int killabilityRadius;
        Coordinate firstFort = new Coordinate();
        Coordinate secondFort = new Coordinate();
        Coordinate thirdFort = new Coordinate();
        Coordinate enemyFort = new Coordinate();
        Scanner scanner = new Scanner(System.in);
        killabilityRadius = scanner.nextInt();
        firstFort.x = scanner.nextInt();
        firstFort.y = scanner.nextInt();
        secondFort.x = scanner.nextInt();
        secondFort.y = scanner.nextInt();
        thirdFort.x = scanner.nextInt();
        thirdFort.y = scanner.nextInt();
        enemyFort.x = scanner.nextInt();
        enemyFort.y = scanner.nextInt();
        if(getDistance(firstFort,enemyFort) <= killabilityRadius){
            killValue++;
        }
        if(getDistance(secondFort,enemyFort) <= killabilityRadius){
            killValue++;
        }
        if(getDistance(thirdFort,enemyFort) <= killabilityRadius){
            killValue++;
        }
        System.out.println(killValue + "x");

    }

    public static float getDistance(Coordinate a,Coordinate b){
        return (float) Math.sqrt((a.x-b.x)*(a.x - b.x)+(a.y - b.y)*(a.y - b.y));
    }



    static class Coordinate{
        public float x;
        public float y;
        public Coordinate(){
            x = 0;
            y = 0;
        }
        public Coordinate(float x,float y){
            this.x = x;
            this.y = y;
        }
    }
}
