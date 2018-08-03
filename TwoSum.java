class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // trivial case checks
        if (nums == null || nums.length == 0)
            return null;
        
        // use a hashmap to store the integers
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        // output the result in the form of an array
        // the elements of this array are the required indices
        // complement denotes the complement of the current value
        // eg. if target = 9, complement of 2 will be 9 - 2 = 7
        
        int[] result = new int[2];
        int complement = 0;
        
        for(int i = 0; i < nums.length; i++){
            int el = nums[i];
            complement = target - el;
            
            // if the map has the complement we simply return the indices
            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            
            // else we put the current value in the map and keep iterating
            map.put(el,i);
        }
        
        return result;
    }
}
