package cn.alien95.algorithm;

/**
 * Created by linlongxin on 2016/3/12.
 */
public class Search {

    public static void main(String[] args) {
        int[] data={1,2,3,4,5,6,7,8,9};
        Search search = new Search();
        System.out.println(search.binarySearch(data,0,8,4));
    }

    //二分查找递归实现
    public int binarySearch(int[] data,int low,int high,int target){
        if(low <= high){
            int mid = (low + high)/2;
            if(data[mid] == target){
                return mid;
            }else {
                if(data[mid] > target){
                    return binarySearch(data,low,mid - 1,target);
                }else {
                    return binarySearch(data,mid + 1,high,target);
                }

            }
        }
        return -1;
    }
}
