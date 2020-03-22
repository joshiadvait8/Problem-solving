import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int subSetSum(int[] arr,int sum, int n){
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }
        //choice
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        //check only last row of t[][] wherever true re only possibles subsets withthat can take sum
        List<Integer> v = new ArrayList<>();
        for(int i=0;i<=(sum)/2;i++){
            if(t[n][i] == true){
                v.add(i);
            }
        }

        int mn = Integer.MAX_VALUE;
        for(int i=0;i<v.size();i++){
            mn = Math.min(mn,sum-(2*v.get(i)));
        }
        return mn;
        

    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        // int[] arr = {1,6,11,5};
         int[] arr = {3, 1, 4, 2, 2, 1};
        int sum = 0;
        for(int i : arr) sum+=i;
        //System.out.println("sum"+sum); range
        System.out.println(subSetSum(arr,sum,arr.length));

    }
}
