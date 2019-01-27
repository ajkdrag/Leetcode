/*
  Problem at : 
*/

// Using a HashSet with two passes is the obvious solution. Here is a little different one
class Solution {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0; i < n; ++i) {
            char c = arr[i];
            int temp = s.indexOf(c);
            if(temp == s.lastIndexOf(c)){
                return temp;
            }
        }
        return -1;
    }
}

// This one is faster because there is no array indexing inside the loop
class Solution {
    public int firstUniqChar(String s) {
        int pos = Integer.MAX_VALUE;
        for(char i='a';i<='z';i++) {
            int temp = s.indexOf(i);
            if(temp!=-1 && temp == s.lastIndexOf(i))
                pos = pos < temp ? pos : temp;
        }
        return (pos == Integer.MAX_VALUE) ? -1 : pos;
    }
}

// Here is another bootlegged solution that scans through the array only once but runtime is very poor
// even though the time complexity isn't.
class Solution {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(n == 0)
            return -1;
        q.add(0);
        set.put(arr[0], 1);
        for(int i = 1; i < n; ++i){
            char c = arr[i];
            if(!q.isEmpty() && arr[q.peek()] == c){
                q.poll();
                set.put(c, set.get(c) + 1);
                continue;
            }
            
            if(set.containsKey(c)){
                set.put(c, set.get(c) + 1);
                continue;
            }
            set.put(c, 1);
            q.offer(i);
        }
        while(!q.isEmpty()){
            if(set.getOrDefault(arr[q.peek()], 0) > 1)
               q.poll();
            else
               break;
        }
        return q.isEmpty() ? -1 : q.poll();
    }
}




