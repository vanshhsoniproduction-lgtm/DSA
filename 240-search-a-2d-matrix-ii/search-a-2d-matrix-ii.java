class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

            int j=matrix[0].length-1;
        for(int i=0; i<matrix.length; i++){
            if (j < 0) return false;
            if(matrix[i][j]==target){return true;}
            else if(matrix[i][j]>target){j--; i--;}
            else if(matrix[i][j]<target){}
        }return false;
    }
}