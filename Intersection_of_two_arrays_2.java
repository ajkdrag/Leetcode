/*
  Problem at : https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        while((pnt1 < len1) &&(pnt2< len2)){
            if(nums1[pnt1]<nums2[pnt2]){
                ++pnt1;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    ++pnt2;
                }
                else{
                    myList.add(nums1[pnt1]);
                    ++pnt1;
                    ++pnt2;
                }
            }
        }
        
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = myList.get(i);
        }
        return res;
    }
}


