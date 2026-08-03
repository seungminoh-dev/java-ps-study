import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int ele : nums){
            myMap.put(ele,1);
        }
        return Math.min(myMap.keySet().size(),nums.length/2);
    }
}