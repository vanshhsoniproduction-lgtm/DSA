import java.util.*;
public class Pascal{
    public static void main(String[] args){
        System.out.println(printPascal(3));
    }

    public static List<List<Integer>> printPascal(int n){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i == j || j ==0){
                    row.add(1);
                }else{
                    row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j)); 
                }
            }
            result.add(row);
        }
    return result;
    }
}

