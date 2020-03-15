/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    //recursive+memoization approach
    
    static int knapSack(int[] wt, int[] val, int w, int n,int[][] t){
        //base condition: smallest valid input
        if(n==0 || w==0){
            return 0;
        }
        //before calling recursive function we check in our stored t[][] 
        //if val present then we can avoid
        if(t[n][w] != -1){
            return t[n][w];
        }
        
        
        if(wt[n-1]<= w){
            return t[n][w] = Math.max(
                val[n-1]+knapSack(wt,val,w-wt[n-1],n-1,t),
                knapSack(wt,val,w,n-1,t)
                );
        }
        else{
            return t[n][w] = knapSack(wt,val,w,n-1,t);
        }
    }
    
	public static void main (String[] args) {
	    Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wt = new int[n];
		int[] val = new int[n];
		
        for(int i = 0; i< n; i++){
            val[i] = sc.nextInt();
        }
         for(int i = 0; i< n; i++){
            wt[i] = sc.nextInt();
        }
        int w = sc.nextInt(); //capacity or max weight of knapsack bag
        
        //fill t[][] array with -1;
        int[][] t = new int[n+1][w+1];
        
        for(int[] row: t){
            Arrays.fill(row,-1);
        }
        
        System.out.println(knapSack(wt,val,w,wt.length,t));
        
	}
}
