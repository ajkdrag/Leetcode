class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // n = sum of the lengths of the two arrays
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n = l1+l2;
        
        // trivial case check
        if(n == 0) return 0;
        
        // if one of the arrays is empty, median is simply the median of the other array
        if(l1 == 0) return (n%2==0?(nums2[n>>1] + nums2[(n>>1)-1])/2.0 : nums2[n>>1]);
        if(l2 == 0) return (n%2==0?(nums1[n>>1] + nums1[(n>>1)-1])/2.0 : nums1[n>>1]);
        
        // we want nums1 to be the smaller array in this algorithm
        if(l2 < l1) return findMedianSortedArrays(nums2,nums1);
        
        // algo works this way: 
        // define split point as the value that equals to the number of elements to the left of the split
        // all elements to the left of the split are less that all elements to the right of the split
        // choose a split point in the shorter array (nums1)
        // since the split point (for the median) of the combined array has predefined number of elements to its left and right
        // we can compute the appropriate split point in the 2nd array
        // suppose nums1 = [2, 3, 7]; nums2 = [1, 4, 6, 8, 9] Hence, combined will be = [1, 2, 3, 4, 6, 7, 8, 9]
        // the split point in the combined array is as follows : 1, 2, 3, 4 | 6, 7, 8, 9
        // here, the split point = 4 (since, 4 elements are to the left of it)
        // if we had an odd lengthed combined array such as [1, 2, 3]
        // the split point for the median should be as follows : 1, 2 | 3
        // thus, in even lengthed combined array, median = (max # of left side of the split + min # of right side of the split)/2.0
        // and in odd lengthed combined array, median = max # of left side of the split
        // i.e in the example of [1, 2, 3, 4 | 6, 7, 8, 9] median = (4+6)/2 = 5
        // and in the example of [1, 2 | 3] median = 2
        // thus, we can say split point = (n+1)/2 , we can confirm this by checking with above two examples
        // set the split1 to be say index 1 in nums1 i.e [2, 3 | 7]
        // now we need to find split2. We already know split point = (n+1)/2 i.e this # of elements must be to the left of split point
        // clearly 2 elements are to the left of split1. Therefore split2 should be such that
        // there are (n+1/2) - 2 elements to the left of split2 i.e (split point - split1) 
        // thus, split2 = (split point - split1)
        // now we only need to check that all elements to the left of the split <= all elements to the right of the split
        // since nums1 and nums2 are sorted, this is satisfied locally
        // to satisfy this globally, we only check if max(left side of split1) <= min(right side of split2)
        // AND max(left side of split2) <= min(right side of split1)
        // if that's not the case, we recompute the splits again (using a binary search approach)
        
        // split1 can be anywhere from 0 to l1
        int start = 0;
        int end = l1;
        
        // we pre compute this "split point" i.e (n+1)/2
        int half_len = (n+1)>>1;
        // initialize varibles
        int split1 = -1;
        int split2 = -1;
        
        // maxLeft is the maximum element in the left side of the split point
        // minRight is the minimum element in the right side of the split point
        int maxLeft = 0;
        int minRight = Integer.MAX_VALUE;
        
        while(start <= end){
            // choose split1 as the middle element and compute split2 accordingly
            split1 = (start+end)>>1; 
            split2 = half_len - split1;
            
            // if the split1 was too low, we find the split in the subarray (split1 + 1, end)
            if(split1 < l1 && nums2[split2-1] > nums1[split1]){
                start = split1 + 1;
                continue;
            }
            
            // if the split1 was too high, we find the split in the subarray (start, split1 - 1)
            if(split1 > 0 && nums1[split1-1] > nums2[split2]){
                end = split1 - 1;
                continue;
            }
            
            // check the edge cases 
            if(split1 == 0) maxLeft = nums2[split2-1]; 
            else if(split2 == 0) maxLeft = nums1[split1-1];
            else maxLeft = Math.max(nums1[split1-1],nums2[split2-1]);
            
            // if n is odd, median is the maxLeft
            if((n&1) == 1) return maxLeft;
            
            if(split1 == l1) minRight = nums2[split2];
            else if(split2 == l2) minRight = nums1[split1];
            else minRight = Math.min(nums1[split1],nums2[split2]);
            
            // else median is avg of maxLeft and minRight
            return (maxLeft + minRight)/2.0;            
        } 
        
        // default return value
        return -1;
    }
}
