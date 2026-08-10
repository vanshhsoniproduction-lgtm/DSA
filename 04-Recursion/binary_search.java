public class binary_search {
    public static int binarySearch(int[] arr,int l,int h,int target){
        if(l>h){ return -1;}
        int mid = l + (h-l)/2;
        if(arr[mid]==target){
            return mid;
        }else if(arr[mid]<target){
            return binarySearch(arr,mid+1,h,target);
        }else{
            return binarySearch(arr,l,mid-1,target);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,0,arr.length-1,5));
    }
    
}
