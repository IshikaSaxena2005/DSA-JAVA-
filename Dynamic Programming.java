//Leetcode:509
// class Solution {
//     public int fib(int n) {
//         if(n<=1) return n;
//         return fib(n-1)+fib(n-2);
//     }
// } -->TIME COMPLEXITY VERY BAD

//USING DP:
//Recursion+Memoization
class Solution
{
    
    public int fibo(int n,int[]dp)
    {
            if(n<=1) return n;
            if(dp[n]!=0) return dp[n];  //if dp has the value
             dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
             //store it in the dp
            return dp[n];
    }
    public int fib(int n)
    {
        int dp[]=new int[n+1];
        return fibo(n,dp);
    }
}

//TABULATION:Using itrerative DP: Also  called Bottom UP DP
class Solution
{
    public int fib(int n)
    {
        if(n<=1) return n;
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
 } //->O(n)

//Leetcode 746
// class Solution {
//     public int minCost(int[] cost,int idx )
//     {
//         if(idx==0 || idx==1) return cost[idx];
//         return cost[idx]+ Math.min(minCost(cost,idx-1),minCost(cost,idx-2));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return Math.min(minCost(cost,n-1),minCost(cost,n-2));
//     }
// } time limit exceed

//using DP
// class Solution {
//     public int minCost(int[]cost,int idx,int[] dp)
//     {
//         if(idx==0|| idx==1) return cost[idx];
//         if(dp[idx]!=-1) return dp[idx];
//         return dp[idx] =cost[idx]+ Math.min(minCost(cost,idx-1,dp),minCost(cost,idx-2,dp));

//     }
//     public int minCostClimbingStairs(int[] cost )
//     {

//         int n=cost.length;
//         int [] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
//     }}

//method-3

    class Solution {
         public int minCostClimbingStairs(int[] cost )
    {
        int n= cost.length;
        int[] dp = new int[n];
        dp[0]= cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++)
        {
            dp[i]= cost[i] +Math.min(dp[i-2],dp[i-1]);

        }
        return Math.min(dp[n-2],dp[n-1]);
    }}

//Leetcide 198
class Solution {
    public int amount(int[]nums,int i,int dp[])
    {
        int n=nums.length;
        if(i>=nums.length) return 0;
        if(dp[i]!=-1)  return dp[i];
        int take=nums[i]+ amount(nums,i+2,dp); //after skiiping the next
        int skip=amount(nums,i+1,dp);
        dp[i]=Math.max(take,skip);
        return dp[i];

    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return amount(nums,0,dp);
    }
}
// class Solution {
//       public int rob(int[] nums) {
//         int n=nums.length;
//         if(n==1) return nums[0];
//         int dp[]= new int[n+1];
//         dp[0]=nums[0];
//          dp[1]=Math.max(nums[0],nums[1]);
//         for(int j=2;j<n;j++)
//         {
//             dp[j]=Math.max(nums[j]+dp[j-2],dp[j-1]);
//         }
//         return dp[n-1];
//       }}
