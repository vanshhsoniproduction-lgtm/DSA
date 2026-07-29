class Solution {
    public int mySqrt(int x) {
    //     if(x== 2147483647){
    //         return 46340;
    //     }
    //     for(int i=0;i<x+1;i++){
    //         if((long)(i * i)==x){
    //             return i;
    //         }
    //         if((long)(i * i)>x)
    //         return i-1;
    //         }
    // return 0;
        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}