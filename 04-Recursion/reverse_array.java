public class reverse_array {
    public static void reverse(int[] arr,int l,int r){
        if(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            reverse(arr,l+1,r-1);
        }
    }
    public static void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        printarr(arr);
        reverse(arr,0,arr.length-1);
        printarr(arr);
    }
}
