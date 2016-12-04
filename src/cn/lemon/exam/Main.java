package cn.alien95.exam;

import java.util.Scanner;

/**
 * Created by linlongxin on 2016/9/17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, n, p;
        int[][] maze;
        n = scanner.nextInt(); //n行
        m = scanner.nextInt(); //m列
        p = scanner.nextInt(); //p体力

        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        Node node = path(maze, n, m);
        print(node);
    }

    //m行，n列
    public static Node path(int[][] data, int m, int n) {
        Node path = new Node();
        path.x = 0;
        path.y = 0;

        Node temp = path;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //向右
                if (data[i][j] == 1 && i - 1 >= 0 && data[i - 1][j] == 1) {
                    temp.next = new Node();
                    temp.next.x = i - 1;
                    temp.next.y = j;
                    temp = temp.next;
                    //向左
                }else if (data[i][j] == 1 && j + 1 < n && data[i][j + 1] == 1) {
                    temp.next = new Node();
                    temp.next.x = i;
                    temp.next.y = j + 1;
                    temp = temp.next;
                    //向上
                }  else if (data[i][j] == 1 && j - 1 >= 0 && data[i][j - 1] == 1) {
                    temp.next = new Node();
                    temp.next.x = i;
                    temp.next.y = j - 1;
                    temp = temp.next;
                    //向下
                } else if (data[i][j] == 1 && i + 1 < m && data[i + 1][j] == 1) {
                    temp.next = new Node();
                    temp.next.x = i + 1;
                    temp.next.y = j;
                    temp = temp.next;
                }else if(i == 0 && j == n - 1){
                    temp.next = new Node();
                    temp.next.x = i;
                    temp.next.y = j;
                    return path;
                }
            }
        }
        return path;
    }

    static class Node {
        public int x;
        public int y;
        public Node next;
    }

    public static void print(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append("[" + node.x + "," + node.y + "]" + ",");
            node = node.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
