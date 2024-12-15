//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.palinArray(arr) ? "true" : "false");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the Function below*/
class Solution {
    public static boolean checkPalindrome(int n){
        int num = n;
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return n == rev;
    }
    public static boolean palinArray(int[] arr) {
        
        for(int i : arr){
            if(checkPalindrome(i) == false)return false;
        }
        return true;
    }
}