package cn.alien95.collections;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(main.binarySearch(data,0,12,8));
    }

    public int binarySearch(int[] data,int low,int high,int target){
        if(low <= high){
            int mid = (low + high)/2;
            if(data[mid] > target){
                return binarySearch(data,low,mid - 1,target);
            }
            else if(data[mid] < target){
                return binarySearch(data,mid+1,high,target);
            }else
                return mid;

        }
        return -1;
    }

}
