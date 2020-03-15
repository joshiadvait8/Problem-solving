/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    //recursive+memoization approach
    
    static int knapSack(int[] wt, int[] val, int w, int n){
        
        //base condition: smallest valid input
        //fill first row col to 0
        int[][] t = new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        //i-->n  j-->w
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<= j){
                    t[i][j] = Math.max(
                        val[i-1]+t[n-1][j-wt[i-1]],
                        t[i-1][j]
                        );
                }
                else{
                     t[n][w] =t[i-1][j];
                }
            }
        }
        
        return t[n][w];
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
        
        
        
        System.out.println(knapSack(wt,val,w,wt.length));
        
	}
}
