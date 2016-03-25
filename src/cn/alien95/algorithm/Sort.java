package cn.alien95.algorithm;

import java.util.Arrays;

/**
 * Created by linlongxin on 2016/3/12.
 */
public class Sort {


    public static void main(String[] args) {
        int[] data={1,2,3,4,5,6,7,8,9};
        Sort sort = new Sort();
        sort.quickSort(data);
        System.out.println(Arrays.toString(data));
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
}
