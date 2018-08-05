/*
 *This algorithm uses the Binary Search approach
 *For a "guess", we can check if it is the median in constant time 
 *The middle element in the array is taken as the guess and accordingly the left and right boundaries are adjusted
 *If none of the guesses in the 1st array turn out to be the median, we move to the second array
 */
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {      
    int l1 = nums1.length;
    int l2 = nums2.length;

    int n = l1 + l2;
    int half_n = n>>1;  // just a shorthand since we will be using n/2 a lot in the code
    double result = 0;
    if (n==0) return 0;  // trivial case when both the arrays are empty
    if (n==2 && l1 != 0 && l2 != 0)return (nums1[0] + nums2[0])/2.0;  // case when both arrays have only one element
    
    // case when n is even
    if (n%2 == 0) {
      if (l1 == 0) {
        return (nums2[half_n -1] + nums2[half_n])/2.0; // if 1st array is empty, we find median of the 2nd array
      }
      if (l2 == 0) {
        return (nums1[half_n -1] + nums1[half_n])/2.0; // if 2nd array is empty, we find median of the 1st array
      }
      if (l1 == 1) {
      
        // if the 1st array has only one element we do a check
        // check : if that element is one of the "medians" (even sized arrays have 2 medians and result is avg of them)
        // else the two medians have to be in the 2nd array       
        if (nums2[half_n -2] <= nums1[0] && nums1[0] <= nums2[half_n - 1]) {
          result = nums1[0] + findKthSmallest(half_n +1, nums2, nums1);
          return result/2;
        } else if (nums2[half_n -1] <= nums1[0] && nums1[0] <= nums2[half_n]) {
          result = nums1[0] + findKthSmallest(half_n, nums2, nums1);
          return result/2;
        } else {
          result = findKthSmallest(half_n, nums2, nums1) + findKthSmallest(half_n + 1, nums2, nums1);
          return result/2;
        }
      } else if (l2 == 1) {
      
        // same case check as above, but this time for the 2nd array
        if (nums1[half_n-2] <= nums2[0] && nums2[0] <= nums1[half_n - 1]) {
          result = nums2[0] + findKthSmallest(half_n +1, nums1, nums2);
          return result/2;
        } else if (nums1[half_n-1] <= nums2[0] && nums2[0] <= nums1[half_n]) {
          result = nums2[0] + findKthSmallest(half_n, nums1, nums2);
          return result/2;
        } else {
          result = findKthSmallest(half_n, nums1, nums2) + findKthSmallest(half_n + 1, nums1, nums2);
          return result/2;
        }
      } else {
      
        // Being in this code block implies both arrays have more than one element hence, the median can be in any of the two
        result = findKthSmallest(half_n, nums1, nums2);     
        if (result == -1) result = findKthSmallest(half_n, nums2, nums1);
        double result2 = findKthSmallest(half_n+1, nums1, nums2);    
        if (result2 == -1) result2 = findKthSmallest(half_n+1, nums2, nums1);
        return (result + result2)/2;
      }
    } else {
      
      // cases when n is odd
      if (l1 == 0) {
        return  nums2[half_n];
      }
      if (l2 == 0) {
        return  nums1[half_n];
      }
      if (l1 == 1) {
        if (nums2[half_n-1] <= nums1[0] && nums1[0] <= nums2[half_n]) {
          result = nums1[0];
          return result;
        } else {
          result = findKthSmallest(half_n+1, nums2, nums1);
          return result;
        }
      } else if (l2 == 1) {
        if (nums1[half_n-1] <= nums2[0] && nums2[0] <= nums1[half_n]) {
          result = nums2[0];
          return result;
        } else {
          result = findKthSmallest(half_n + 1, nums1, nums2);
          return result;
        }
      } else {
        result = findKthSmallest(half_n+1, nums1, nums2);
        if (result == -1) result = findKthSmallest(half_n+1, nums2, nums1);

        return result;
      }
    }
  }
  
  // this function is the core behind the solution
  // as the name says, it finds the Kth smallest element (IF IT EXISTS IN THE 1ST ARRAY)
  // hence we need to call this function again with nums2 as the earlier parameter, if the search fails for the nums1 array
  // eg: nums1 = {2,3,7,10}, nums2 = {1,4} , k = 3
  // combining these two would produce = {1,2,3,4,7,10} and 3rd smallest element will be 3 
  // this algo finds that element in logarithmic time complexity using binary search
  
  int findKthSmallest(int k, int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    
    // these checks are not needed since we have already checked them before
    if (l1 == 0) return nums2[k-1];
    if (l2 == 0) return nums1[k-1];

    if (k == 1) return Math.min(nums1[0], nums2[0]);
    else if (k == l1 + l2) return Math.max(nums1[l1 - 1], nums2[l2-1]);
    // search in 1st array

    int start = 0;
    int end = l1 - 1;
    int split = 0;
    int remaining = 0;

    while (start <= end) {

      split = (start+end)>>1; // split at the middle i.e array[split] will act as our "guess" for the kth smallest element

      // we make sure that our "guess" isn't too high 
      // eg nums1 = {2,3,7,10} , k = 3 and our split is say at index 3 which has the element 10
      // kth smallest element will have k elements <= itself
      // eg: 3 is the answer, and elements <= 3 are {1,2,3} 
      // 10 can never be the 3rd smallest because it itself has 4 elements <= itself  and 4 > k, hence we should keep the split < k
 
      if (split >= k) {    
        end = split - 1;
        continue;
      }
      
      // elements <= our "guess" in the 1st array are [split+1]
      // hence, number of elements remaining that must be <= guess are [k - (split + 1)]
      remaining = k - (split + 1);
      
      // if the number of remaining elements is > size of the other array, then our split position is too low,
      // the guess must somehwere in the subarray after the split (if it exists in the 1st array). (Binary search approach)
      if (remaining > l2) {
        start = split + 1;
        continue;
      } else if (remaining == 0) {
        // in this case the guess must not have any element <= itself. i.e all other elements must be > guess
        // hence we only check the smallest element (i.e nums2[0]) in the other array to be > guess , since arrays are sorted
           if (nums1[split] < nums2[0]) return nums1[split];
           else {
          // if that's not the case, our split pos was too high
          // hence we search in the subarray before the split (binary search approach)
          end = split-1;
          continue;
         }
      } else {
        // this is the case when 0 < remaining <= l2
        // check if our guess is the required element in constant time
        // nums2[remaining-1] <= guess <= nums2[remaining]  <-- if this is the case, our guess is correct!!
        if (nums1[split] >= nums2[remaining - 1]) {
          if (remaining == l2 || nums1[split] <= nums2[remaining]) return nums1[split];
          else end = split-1;  // our split was too high since [ guess > nums2[remaining] and remaining != l2 ]
        } else {
          // our split was too low since [ guess < nums2[remaining-1] ]
          // we can add "continue" here, but no need since these are the last statements anyway
          start = split + 1;
        }
      }
    }
    
    // indicate that the required element doesn't exist in the nums1 array
    return -1;
  }
}
