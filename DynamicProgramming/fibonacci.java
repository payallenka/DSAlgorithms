package DynamicProgramming;

import java.util.Arrays;

public class fibonacci {
    static int f(int n, int[] dp){
        
        if(n<=1) return n;

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = f(n-1,dp) + f(n-2, dp);

    }

    public static void main(String[] args){
        int n = 5;
        int[] dp = new int[n+1];

        Arrays.fill(dp,-1);

        System.out.println(f(n,dp));



        //tabulation


        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
