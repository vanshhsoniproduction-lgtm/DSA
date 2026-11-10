class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
for(int key : map.keySet()){
    if(map.get(key) > nums.length / 3){
        ans.add(key);
    }
}

        return ans;
        
        
    }
}