//{ Driver Code Starts
// // Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution ob = new Solution();
            ob.rotate(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// // User function Template for Java

class Solution {
    public void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr,int i,int j){
        while(i < j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    // public void rotate(int[] nums, int k) {
    //      k = k % nums.length;
    //     if(k == 0)return;

    //     reverse(nums,0,nums.length - 1);
    //     reverse(nums,0,k - 1);
    //     reverse(nums,k,nums.length - 1);
    // }
    public void rotate(int[] arr) {
        int k = 1 % arr.length;
        if(k == 0)return;

        reverse(arr,0,arr.length - 1);
        reverse(arr,0,k - 1);
        reverse(arr,k,arr.length - 1);
    }
}