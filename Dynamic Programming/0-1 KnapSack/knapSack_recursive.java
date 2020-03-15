/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    //recursive approach
    static int knapSack(int[] wt, int[] val, int w, int n){
        //base condition: smallest valid input
        if(n==0 || w==0){
            return 0;
        }
        if(wt[n-1]<= w){
            return Math.max(
                val[n-1]+knapSack(wt,val,w-wt[n-1],n-1),
                knapSack(wt,val,w,n-1)
                );
        }
        else{
            return knapSack(wt,val,w,n-1);
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
        
        System.out.println(knapSack(wt,val,w,wt.length));
        
	}
}
