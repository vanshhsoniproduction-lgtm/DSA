class Solution {
    public int maxArea(int[] height) {
        if(height.length==0){return 0;}
        int i = 0;
        int j = height.length-1;
        int area = Math.min(height[i],height[j])*(j-i);
       
        while (i < j){
            int new_area = (Math.min(height[i],height[j]))*(j-i);
            if(height[i]<height[j]){
                if(new_area>area){
                    area = new_area;
                }
                i++;
            }else{
                if(new_area>area){
                    area = new_area;
                }
                j--;
            }
        }
        
    return area;

    }
}