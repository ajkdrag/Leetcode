/*
  Problem at : 
*/

// 1. Using Binary Search
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int l = A.length - 1;
        int m = B.length - 1;
        int totalA = 0;
        int totalB = 0;
        for(int i = 0; i <= l; ++i){
            totalA += A[i];
        }
        for(int i = 0; i <= m; ++i){
            totalB += B[i];
        }
        int diff = totalA - totalB;
        if(diff > 0){
            Arrays.sort(A);
            for(int i = 0; i <= m; ++i){
                int target = (diff>>1) + B[i];
                if(search(A, 0, l, target) >= 0)
                    return new int[]{target, B[i]};
            }
        }
        else {
            diff = -diff;
            Arrays.sort(B);
            for(int i = 0; i <= l; ++i){
                int target = (diff>>1) + A[i];
                if(search(B, 0, m, target) >= 0)
                    return new int[]{A[i], target};
            }
        }
        
        return new int[2];
    }
    
    int search(int arr[], int first, int last, int key){  
       if(key > arr[last] || key < arr[first])
            return -1;
       int mid = (first + last)>>1;  
       while( first <= last ){  
          if ( arr[mid] < key ){  
            first = mid + 1;     
          }else if (arr[mid] == key ){  
            return mid;
          }else{  
             last = mid - 1;  
          }  
          mid = (first + last)>>1;  
       }  
       return -1;
    }  
}

// 2. Same thing but using a HashSet to 'lookup'/ can also use a boolean array
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0; 
        Set<Integer> setB = new HashSet();
        for (int x: A) sa += x;
        for (int x: B){
            setB.add(x);
            sb += x;
        } 
        int delta = (sb - sa)>>1;
        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};
        throw null;
    }
}

