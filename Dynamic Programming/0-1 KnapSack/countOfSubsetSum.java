/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
    static int countOfSubset(int[] arr,int sum,int n){
        int[][] t = new int[n+1][sum+1];
        //1.Initilaize t[][]
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
        
        //2.code choice based
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
        
    }
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		
		System.out.println(countOfSubset(arr,sum,arr.length));
	}
}
