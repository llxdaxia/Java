package cn.lemon.algorithm;

import java.util.Arrays;

/**
 * Created by linlongxin on 2016/3/12.
 */
public class Sort {


    public static void main(String[] args) {
        int[] data={1,2,3,4,5,6,7,8,9};
        Sort sort = new Sort();
//        sort.quickSort(data);
//        System.out.println(Arrays.toString(data));

        int[] data2 = {3,5,3,5,1,336,43,56,43,5};
        sort.insertSort(data2);
        System.out.println(Arrays.toString(data2));

    }

    //快速排序
    public void quickSort(int[] data){
        try {
            sort(data,0,data.length-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //排序
    public void sort(int[] data,int low,int high) throws Exception {
        if(low < high){
            int pivot = partition(data,low,high);
            sort(data,low,pivot-1);
            sort(data,pivot + 1,high);
        }
    }

    //返回分割的位置，把数组分成两个子数组
    public int partition(int[] data,int low,int high) throws Exception {
        if(data.length == 0 || low > high || low < 0 || high <0){
            throw new Exception("参数错误。。。");
        }
        int index = data[low];  //枢轴记录
        while (low < high){
            while (low < high && data[high] >= index){  //从右端开始向左扫描，如果比枢轴大，则指针左移一位
                high --;
            }
            data[low] = data[high];  //这里说明，data[high] < data[index],所以应该交换比枢轴小的记录到左端
            while (low < high && data[low] <= index){
                low ++;
            }
            data[high] = data[low];//这里说明，data[low] > data[index],所以应该交换比枢轴大的记录到右端
        }
        data[low] = index;
        return low;

    }

    public int fenge(int data[],int low,int high){
        int index = data[low]; //第一个数作为轴
        if(low < high){
            while (low < high && data[high] >= index){  //从右端开始扫描，如果比轴大，则指针左移一位
                high --;
            }
            data[low] = data[high];
            while (low < high && data[low] <= index){  //从左端开始扫描，如果比轴小，则指针右移一位
                low ++;
            }
            data[high] = data[low];
        }
        data[low] = index;
        return low;
    }

    public void insertSort(int[] data){
        for (int i = 1; i < data.length; i ++) {
            insert(data,data[i],i);
        }
    }

    public void insert(int[] data,int target,int position){
        for(int i = 0; i < position; i ++){
            if(target <= data [i + 1] && target >= data[i]){

                for (int k = position - 1; k > i ; k --){
                    data[k + 1] = data[k];
                }
                data[i] = target;
            }
        }
    }
}
