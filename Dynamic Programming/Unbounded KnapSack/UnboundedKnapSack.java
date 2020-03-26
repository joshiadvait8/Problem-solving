/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

//Unbounded knapsacck where item can be taken multiple times
class GFG {
    
    static int unboundedKnapsack(int val[],int wt[],int w, int n){
        int[][] t = new int[n+1][w+1];
        //initilization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        //choice code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j){
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        
        return t[n][w];
        
    }
    
    
	public static void main (String[] args) {
	    int w = 8;
	    int val[] = {10, 40, 50, 70};
	    int wt[] = {1, 3, 4, 5};
	    int n = wt.length;
	    System.out.println(unboundedKnapsack(val,wt,w,n));
	}
}
