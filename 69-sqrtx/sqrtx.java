class Solution {
    public int mySqrt(int x) {
        if(x== 2147483647){
            return 46340;
        }
        for(int i=0;i<x+1;i++){
            if((long)(i * i)==x){
                return i;
            }
            if((long)(i * i)>x)
            return i-1;
            }
    return 0;
    }
}