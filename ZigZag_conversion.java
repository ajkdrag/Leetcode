/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this :
  
    P   A   H   N
    A P L S I I G
    Y   I   R
    
    And then read line by line: "PAHNAPLSIIGYIR"
    
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I

    Method 1: 
        
        Notice the 1st row have alphabets that belong to indices 0,6,12... i.e the gap is 6 which is 2*(numRows - 1)
        Also note that, we can visualize the zig zag as : 
        
        P     I    N                    P     I     N
        A   L S  I G        ==>          A   L S   I G
        Y A   H R                         Y A   H R
        P     I                            P     I

        The new visualization of the problem represents a graph whose nodes are the characters of the string given
        We need to traverse this graph level by level and print the characters as we encounter them.
        Thus, if we use BFS approach, we can solve this problem. For this we will use a queue and a HashSet/ a boolean array
        The queue will hold the nodes which we need to visit, while the hashset/boolean array keeps track of the nodes we have
        already visited. Note that instead of actually placing the nodes in these data structures, we only place their indices.
        At first, we fill the empty queue with indices of nodes that belong to the 1st level. i.e :
        
        Queue = {0, 6, 12}              We fill these by using the previous observation of gap being 2*(numRows - 1)
        
        Next we poll from the queue and obtain the index 0, we append the character at index 0 to our result.
        We add the children of this polled index/node to the queue. Note that the children of any index/node in this problem is defined
        as : left node/index = parent - 1; right node/index = parent + 1
        Thus in this way, left child of 0 is -1 and right child will be 1. We add these two 'children' to the queue.
        Add nodes to the queue only if they haven't been visited (which can be checked by means of the hashset/boolear array)
        Make sure to add the left child only if it's >= 0 and right child only if it's < length of the string
        This check allows us to be 'within' the bounds of the string, and also nicely deals with edge cases which we will talk about later.
        After adding an univisted node to the queue, make sure to add it to the set of visited nodes as well.
        
        Queue = {6, 12, 1}              result = "P"                                    Visited = {0,6,12,1}
        Queue = {12, 1, 5, 7}           result = "PI"                                   Visited = {0,6,12,1,5,7}
        Queue = {1, 5, 7, 11, 13}       result = "PIN"                                  Visited = {0,6,12,1,5,7,11,13}    
        Queue = {5, 7, 11, 13, 2}       result = "PINA"                                 Visited = {0,6,12,1,5,7,11,13,2}
        Queue = {7, 11, 13, 2, 4}       result = "PINAL"                                Visited = {0,6,12,1,5,7,11,13,2,4}
        Queue = {11, 13, 2, 4, 8}       result = "PINALS"                               Visited = {0,6,12,1,5,7,11,13,2,4,8}
        Queue = {13, 2, 4, 8, 10}       result = "PINALSI"                              Visited = {0,6,12,1,5,7,11,13,2,4,8,10}
        Queue = {2, 4, 8, 10}           result = "PINALSIG"                             Visited = {0,6,12,1,5,7,11,13,2,4,8,10}
        Queue = {4, 8, 10, 3}           result = "PINALSIGY"                            Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3}
        Queue = {8, 10, 3}              result = "PINALSIGYA"                           Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3}
        Queue = {10, 3, 9}              result = "PINALSIGYAH"                          Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3,9}
        Queue = {3, 9}                  result = "PINALSIGYAHR"                         Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3,9}
        Queue = {9}                     result = "PINALSIGYAHRP"                        Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3,9}
        Queue = {}                      result = "PINALSIGYAHRPI"                       Visited = {0,6,12,1,5,7,11,13,2,4,8,10,3,9}
        
        Thus, we now have an understanding of how this algorithm works. Let us now consider the edge case as follows :
        n = 5, numRows = 4
        
        A           
         B 
          C E
           D
          
        In the above case, the node 4 i.e character 'E' has no parent in the level above it, hence the result will be wrong!
        In order to take care of this; when we first added the level 1 indices to our queue, we also add one extra node/index
        i.e we imagine that character to be some dummy character say '#', thus  we have :       
        Initially Queue = {0, 6}  Here, 6 is the 'extra' node we added.
        
        Queue = {6, 1}                  result = "A"                                    Visited = {0,6,1}
        
        When 6 will be polled, it's children will be {5,7}
        Now, since 6 >= n, it's beyond the string bounds, i.e there is no character at that index, so nothing will be appended to result.
        7 will not added to the queue because it is right child and right child can't be >= n according to our algo
        5 will be added to the queue because it is left child and >= 0
        
        Queue = {1, 5}                  result = "A"                                    Visited = {0,6,1,5}
        Queue = {5, 2}                  result = "AB"                                   Visited = {0,6,1,5,2}
        Queue = {2, 4}                  result = "AB"                                   Visited = {0,6,1,5,2,4}
        Queue = {4, 3}                  result = "ABC"                                  Visited = {0,6,1,5,2,4,3}
        Queue = {3}                     result = "ABCE"                                 Visited = {0,6,1,5,2,4,3}
        Queue = {}                      result = "ABCED"                                Visited = {0,6,1,5,2,4,3}
        
    Thus, in this way, we are able to deal with edge cases as such.
*/



class Solution {
    
    public String convert(String s, int numRows) {  
        int n = s.length();
        // trivial cases
        if(n == 0) return "";
        if(numRows == 1) return s;
        
        // visited holds the indices of the visited nodes
        HashSet<Integer> visited = new HashSet<Integer>();
        // charQueue holds the indices nodes yet to be visited
        Queue<Integer> charQueue = new LinkedList<Integer>();
        // characters will be appended to the res string; after being polled from the queue
        StringBuilder res = new StringBuilder("");
        
        int start = 0;
        // gap is used to get the level 1 indices
        int gap = 2*(numRows - 1);
    
        // add level 1 indices to the queue as well as the visited set
        while(start < n){
            charQueue.offer(start);
            visited.add(start);
            start += gap;
        }
        
        // add one extra index to deal with the edge case as described in the algo
        charQueue.offer(start);
        
        // perform the steps as long as the queue isn't empty
        while(charQueue.size() > 0){
            // poll the index from the head of the queue
            int id = charQueue.poll();
            
            // if the index is within the string bounds, then only append it to the result string
            if(id < n)  {
                res.append(s.charAt(id));
            }
            // if the left child's index >= 0 and it hasn't yet been visited
            if(id-1 >= 0 && !visited.contains(id-1)) {
                // add it to the queue and to the set of visited indices
                charQueue.offer(id-1);
                visited.add(id-1);
            }
            // if the right child's index < n and it hasn't yet been visited
            if(id + 1 < n && !visited.contains(id+1)){
                // add it to the queue and to the set of visited indices
                charQueue.offer(id+1);
                visited.add(id+1);
            } 
            
        }
        // return the result string
        return res.toString();
    }
}
