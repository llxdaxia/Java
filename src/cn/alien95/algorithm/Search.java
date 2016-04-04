package cn.alien95.algorithm;

/**
 * Created by linlongxin on 2016/3/12.
 */
public class Search {

    public static void main(String[] args) {
        int[] data={1,2,3,4,5,6,7,8,9};
        Search search = new Search();
        System.out.println(search.binarySearch(data,4));
    }

    //折半查找循环实现
    public int binarySearch(int[] data,int target){
        int low = 0;
        int high = data.length - 1;
        int mid = (low + high)/2;
        while (low <= high){
            if(data[mid] > target){
               high = mid -1;
            }else if(data[mid] < target){
                low = mid + 1;
            }else {
                return mid;
            }
            mid = (low + high)/2;
        }
        return -1;
    }


    //折半查找递归实现
    public int search(int[] data,int target,int low,int high){
        int mid = (low + high)/2;
        if (low <= high){
            if(data[mid] == target){
                return mid;
            }else if (data[mid] > target){
                return search(data,target,low,mid - 1);
            }else {
                return search(data,target,mid + 1,high);
            }
        }
        return -1;
    }
}
