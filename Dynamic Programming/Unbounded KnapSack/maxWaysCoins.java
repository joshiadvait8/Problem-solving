/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

//max no of ways of coin to make sum
//link: https://www.geeksforgeeks.org/coin-change-dp-7/
class GFG {
    
    static int maxWays(int[] coin,int sum,int n){
        int[][] t = new int[n+1][sum+1];
        //initilization
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
        
        //choice code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coin[i-1]<=j){
                    t[i][j] = t[i][j-coin[i-1]]+t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
        
    }
    
    
	public static void main (String[] args) {
	    int sum = 4;
	    int[] coin = {1,2,3};
	    int n = coin.length;
	    System.out.println(maxWays(coin,sum,n));   
	}
}
