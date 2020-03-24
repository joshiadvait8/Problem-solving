/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    //count no. subsets with given diffrence.
    
    
    static int countSubsetWithGivenDiff(int[] arr, int diff, int n){
        int Arrsum = 0;
        for(int i : arr) Arrsum+=i;
        
        int subsetSum = (diff + Arrsum)/2;
        
        return CountsubSetSum(arr,subsetSum,n);
    }
    
    static int CountsubSetSum(int[] arr,int sum, int n){
        int[][] t = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }
        
        //code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {1,1,2,3};
		int diff = 1;
		
		System.out.println(countSubsetWithGivenDiff(arr,diff,arr.length));
		
		
	}
}

