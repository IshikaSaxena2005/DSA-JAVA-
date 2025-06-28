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

//Leetcode 1137
class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        int[]dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}









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

// FRIENDS PAIRING PROBLEM
// you are given a number 'n', Denoting that there are n friends. Find out the number of ways in 
// which a person can either pair up or stay single.
// // not necessary ki sab pair up hii ho
// //give the number of ways
// //either pair up or not
// a(b,c,d)  ab(c,d)   ac(d,b)
// either alone or together
// pair(n-1)+(n-1)* pair(n-2)
class Solution
{
 public int pair(int n,int[]dp)
{
if(n<=2) return n; //for 2 either they can be together or not hence return statement
if(dp[n]!=-1) retur dp[n];
return dp[n]= pair(n-1) + (n-1)* pair(n-2); //combination
                //single    //pair

}
  public int PairFriend(int n)
{
    int dp[]= new int[n+1];
    Arrays.fill(dp[n],-1);
    return pair(n,dp);
}
}

//Tabulation:
public int PairFreind(int n)
{
int dp[]=new int[n+1];
dp[1]=1;
if(n>1) dp[2]=2;
for(int i=3;i<n;i++)
{
  dp[i]=dp[i-1]+ (i-1)* dp[i-2];
}
return dp[n];
}

// COUNT DEARRANGEMENTS:
// there are n postcards:
// the postman delivers wrong postcards to very house and every house has incorrect postcard
public int dearrange(int n)
{
  if(n==0) return 0;
  if(n==1) return 1;
    return (n-1) * (dearrange(n-1)+ dearrange(n-2));
}

//using dp:
public int dearrange(int n)
{
int dp= new int[n+1];
    dp[0]=0;
  dp[1]=0;
dp[2]=1;

for(int i=3;i<n;i++)
{
    dp[i]=(i-1) * (dp[i-1]+dp[i-2]);
}
return dp[n];
}

//Leetcode 70
class Solution {
    //one step or 2 step
    public int stairs(int n,int[]dp)
    {
         if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=-1) return dp[n];
        int step1= stairs(n-1,dp);
        int step2=stairs(n-2,dp);
        dp[n]= step1+step2;
       return dp[n];
    }
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return stairs(n,dp);
    }
};

//subset Sum -GFG
class Solution {
    public static Boolean subsetSum(int i,int[]arr,int target,int[][]dp)
    {
        if(target<0) return false;
        //dpp[i][target]
        if(i==arr.length)
        {
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1;
        Boolean skip= subsetSum(i+1,arr,target,dp);
        Boolean ans=false;
        Boolean pick=subsetSum(i+1,arr,target-arr[i],dp);
        ans = pick||skip;
        
        dp[i][target]=(ans)?1:0;
        return ans;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][]dp= new int[arr.length][sum+1];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return  subsetSum(0,arr,sum,dp);
        
        
    }
}



//Leetcode 62
// class Solution {
//     public int uniquePaths(int m, int n) {
//         //row vary from 0 to m-1
//         //col vary form 0 to n-1
//         int [][] dp = new int[m][n];
//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 dp[i][j]=-1; 
//             }
//         }
//         return paths(0,0,m,n,dp);
//     }
//     private int paths(int row,int col,Integer m,Integer n, int[][]dp)  //the Integer will go pass by reference since its value is not change
//     {
//         if(row>=m|| col>=n) return 0;
//         if(row==m-1 && col==n-1) return 1;
//         if(dp[row][col]!=-1) return dp[row][col];
//         int rightWays=paths(row,col+1,m,n,dp);
//         int downWays = paths(row+1,col,m,n,dp);
//         return dp[row][col]=rightWays+ downWays;
//     }
// }//recusion gives time limit exceed
// // usng dp : TC:O(mn) SC:O(mn)

//method -2 using tabulation

class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0||j==0) dp[i][j]=1;
                else dp[i][j]= dp[i][j-1]+dp[i-1][j];
            }
        }
    return dp[m-1][n-1];
    }}

//Leetcode 64
class Solution {
    public int minPathSum(int[][] grid) {
        //down and right
        //find the path such that the sum of path is minimum
        //tabulation method
        //greedy approach ->check for right and down
        //optimal substructure-> placing checkpoints
        //make a prefix sum for 1st row and 1st col
        //then out of the rightways and downways we take the one with min
        //dp[i][j]+min(dp[i-1][j],dp[i][j-1])
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]= grid[i][j];
                if(i==0 & j==0) continue;
                else if(i==0)dp[i][j]+= dp[i][j-1];
                else if(j==0) dp[i][j]+= dp[i-1][j];
                else dp[i][j]= dp[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];

    }
}

//resursion+memoization

class Solution {
    public int paths(int row,int col,int m,int n,int[][]grid,int[][]dp)
    {
        if(row>=m || col>=n) return Integer.MAX_VALUE;
        int sum=0;
        if(row==m-1 && col == n-1) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int downways=paths(row+1,col,m,n,grid,dp);
        int rightways=paths(row,col+1,m,n,grid,dp);
        return dp[row][col]= grid[row][col]+ Math.min(downways,rightways);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return paths(0,0,m,n,grid,dp);
    }}

//Leetcode 1277
class Solution {
    public int min(int a,int b,int c)
    {
        return Math.min(a,Math.min(b,c));
    }
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0) continue;
                if(i>0 && j>0) 
                {
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]);
                }
                count+=matrix[i][j];
            }
        }
        return count;
    }
}

//Leetcode 63
class Solution {
    public int paths(int row,int col,int m,int n,int [][]grid,int[][]dp)
    {
        if(row>=m || col>=n|| grid[row][col]==1) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int downways=paths(row+1,col,m,n,grid,dp);
        int rightways=paths(row,col+1,m,n,grid,dp);
        return  dp[row][col]=rightways+downways;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return paths(0,0,m,n,grid,dp);
    }
}

//Leetcode 279
class Solution {
    public boolean isPerfect(int n)
    {
        int sqrt=(int)(Math.sqrt(n));
        return (sqrt*sqrt==n);
    }
    public int minSquares(int n,int[]dp)
    {
        if(isPerfect(n)) return 1;
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++)
        {
            int count= minSquares(i*i,dp) +minSquares(n-i*i,dp);
            min=Math.min(min,count);
        }
        return dp[n]=min;
    }
    public int numSquares(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return minSquares(n,dp);
    }
} //for recursive soln TC is exponential

//FROG JUMP (GFG)
// Given an integer array height[] where height[i] represents the height of the i-th stair, 
//     a frog starts from the first stair and wants to reach the top. From any stair i, 
//     the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. 
//     The cost of a jump is the absolute difference in height between the two stairs.
//     Determine the minimum total cost required for the frog to reach the top.

class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        if(n==1) return 0;
        int prev2=0;
        int prev1=Math.abs(height[0]-height[1]);
        for(int i=2;i<n;i++)
        {
            int curr=Math.min(prev1+Math.abs(height[i]-height[i-1]), prev2+Math.abs(height[i]-height[i-2]));
            prev2= prev1;
            prev1=curr;
        }
        return prev1;
    }
}

// Given an array arr[] of size n,
//     where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i,
//     he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j 
//     is abs(arr[i] – arr[j]). Find the minimum cost for Geek to reach the last stone.

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n=arr.length;
        int[]dp= new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int i=1;i<n;i++)
        {
            for(int j=Math.max(0,i-k);j<i;j++)
            {
                dp[i]=Math.min(dp[i],dp[j]+Math.abs(arr[i]-arr[j]));
            }
        }
        return dp[n-1];
    }
}

//Leetcode 213
class Solution {
    public int robLinear(int[]nums,int start,int end)
    {
        int n=end-start+1;
        if(n==1) return nums[start];
        int []dp= new int[n];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(nums[start+i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        //since houses are arranged in a circle, we cannot rob both first and last houses
        //split problem into 2 cases
        //rob house from 0 to n-2
        //rob house from 1 to n-1
    int n=nums.length;
    if(n==1) return nums[0];
    return Math.max(robLinear(nums,0,n-2),robLinear(nums,1,n-1));

    }
}

//Leetcode 416
class Solution {
    private boolean subset(int i,int[]arr,int target,int[][]dp)
    {
        if(i==arr.length)
        {
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return (dp[i][target]==1);
        boolean ans= false;
        boolean skip=subset(i+1,arr,target,dp);
        if(target-arr[i]<0) ans=skip;
        else
        {
            boolean pick=subset(i+1,arr,target-arr[i],dp);
            ans=pick||skip;
        }
        dp[i][target]=(ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        //array ko 2 subsets meh batna hai saare elements ko use krna hai so that sum=target
        int sum=0;
        for(int ele:nums)sum+=ele;
        if(sum%2!=0) return false;
        int target=sum/2;
        int[][]dp=new int[nums.length][target+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }

        }
        return subset(0,nums,target,dp);

    }//TC:O(n*t);
    //t is target

}

//Leetcode 2915
// class Solution {
//     public int longestLength(int i,List<Integer> nums,int target,int[][]dp)
//     {
//         if(target==0)return 0;
//         if(i==nums.size()) return -1;
//         if(dp[i][target]!=-1) return dp[i][target];
//         int skip=longestLength(i+1,nums,target,dp);
//         int take=-1;
//         if(nums.get(i)<=target)
//         {
//             int next=longestLength(i+1,nums,target-nums.get(i),dp);
//              if(next!=-1) take=next+1;

//         }
       
//         return dp[i][target]=Math.max(take,skip);

//     }
//     public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//         int[][]dp= new int[nums.size()][target+1];
//         for(int i=0;i<nums.size();i++)
//         {
//             for(int j=0;j<dp[0].length;j++)
//             {
//                 dp[i][j]=-1;
//             }
//         }
//         int result= longestLength(0,nums,target,dp);
//         return result<0?-1:result;
//     }
// } //this is memoization giving TLE error

// //using TABULATION BOTTOM UP APPRAOCH
class Solution {
       public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
       int n=nums.size();
       int[][]dp= new int[n+1][target+1];
       for(int i=0;i<=n;i++)
       {
        Arrays.fill(dp[i],-1);
       }
       //if target is 0 then the length of subsequence is 0
       for(int i=0;i<=n;i++)
       {
        dp[i][0]=0;
       }
       for(int i=n-1;i>=0;i--)
       {
        for(int t=0;t<=target;t++)
        {
            int skip=dp[i+1][t];
            int take=-1;
            if(nums.get(i)<=t && dp[i+1][t-nums.get(i)]!=-1)
            {
                take=dp[i+1][t-nums.get(i)]+1;
            }
            
            dp[i][t]=Math.max(skip,take);
        }
       }
         return dp[0][target] < 0 ? -1 : dp[0][target];
       }}

//Leetcode 494
//there is a possbility of negative numbers
// class Solution {
//     public int ways(int i,int[]arr,int target)
//     {
//         if(i==arr.length)
//         {
//             if(target==0) return 1; //1 valid way
//             else return 0;
//         }

//          //no will be subtracted for add
//         int add=ways(i+1,arr,target-arr[i]);
//         int sub=ways(i+1,arr,target+arr[i]);
//         return add+sub;
       
//     }
//     public int findTargetSumWays(int[] arr, int target) {
//         return ways(0,arr,target);
//     }
// } //TC:O(2^n)

//using DP:
class Solution {
    static int sum;

    public int ways(int i, int[] arr, int res, int target, int[][] dp) {
        if (i == arr.length) {
            return res == target ? 1 : 0;
        }
        if (dp[i][res + sum] != -1) return dp[i][res + sum];

        int add = ways(i + 1, arr, res + arr[i], target, dp);
        int sub = ways(i + 1, arr, res - arr[i], target, dp);

        return dp[i][res + sum] = add + sub;
    }

    public int findTargetSumWays(int[] arr, int target) {
        sum = 0;
        for (int ele : arr) sum += ele;

        // Check for valid target range
        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[arr.length][2 * sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return ways(0, arr, 0, target, dp);
    }
}

//Leetcode 2786
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long evenMax = (nums[0] % 2 == 0) ? nums[0] : Long.MIN_VALUE;
        long oddMax = (nums[0] % 2 != 0) ? nums[0] : Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                // Avoid using Long.MIN_VALUE directly in computations
                long newEven = evenMax != Long.MIN_VALUE ? evenMax + nums[i] : Long.MIN_VALUE;
                long newOdd = oddMax != Long.MIN_VALUE ? oddMax + nums[i] - x : Long.MIN_VALUE;
                evenMax = Math.max(newEven, newOdd);
            } else {
                long newOdd = oddMax != Long.MIN_VALUE ? oddMax + nums[i] : Long.MIN_VALUE;
                long newEven = evenMax != Long.MIN_VALUE ? evenMax + nums[i] - x : Long.MIN_VALUE;
                oddMax = Math.max(newOdd, newEven);
            }
        }

        return Math.max(evenMax, oddMax);
    }
}

//LCS
class Solution {
    static int[][]dp;
    public int lcs(int i,int j,StringBuilder a, StringBuilder b)
    {
          if(i<0 || j<0) return 0;
          if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        {
            return dp[i][j]=1+lcs(i-1,j-1,a, b) ;
        }
        else
        {
            //string is pass by value
            return dp[i][j]=Math.max(lcs(i,j-1,a,b),lcs(i-1,j,a,b));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a= new StringBuilder(text1);
        StringBuilder b= new StringBuilder(text2);
        int m=a.length();
        int n=b.length();
        dp=new int[m][n];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return lcs(m-1,n-1,a,b);
        //these Strings are pass by value hence memory wastage since the copies of these string is going
        //StringBuilder is paas by reference
    }

    //Using Tabulation:
     public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a= new StringBuilder(text1);
        StringBuilder b= new StringBuilder(text2);
        int m=a.length();
        int n=b.length();
        dp=new int[m][n];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                int p=(i>=1 && j>=1)?dp[i-1][j-1]:0;
                int q=(j>=1) ? dp[i][j-1]:0;
                int r=(i>=1)?dp[i-1][j]:0;
                if(a.charAt(i)==b.charAt(j)) dp[i][j]=1+p;
                else dp[i][j]=Math.max(q,r);

            }
             
        }
         return dp[m-1][n-1];
     }
}

//Leetcode 322
//using recursion
class Solution {
    public long countcoin(int i,int[]coins,int amount)
    {
        if(i==coins.length){
             if(amount==0) return 0; //no more coins needed
        else return Integer.MAX_VALUE; //not a valid combination
        }
       
        long skip=countcoin(i+1,coins,amount);
        if(amount-coins[i]<0) return skip;
        long pick=1+countcoin(i,coins,amount-coins[i]);
        return Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        int ans=(int)countcoin(0,coins,amount);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}

//using DP
class Solution {
    public long countcoin(int i,int[]coins,int amount,long[][]dp)
    {
        if(i==coins.length){
             if(amount==0) return 0; //no more coins needed
        else return Integer.MAX_VALUE; //not a valid combination
        }
       if(dp[i][amount]!=-1) return dp[i][amount];
        long skip=countcoin(i+1,coins,amount,dp);
        if(amount-coins[i]<0) return skip;
        long pick=1+countcoin(i,coins,amount-coins[i],dp);
        return dp[i][amount]=Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        long[][] dp= new long[coins.length][amount+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans=(int)countcoin(0,coins,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}

//Leetcode 516
class Solution {
    public int lcs(int i,int j,StringBuilder a,StringBuilder b,int[][]dp)
    {
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        {
            return dp[i][j]=1+lcs(i-1,j-1,a,b,dp);
        }
        else
        {
            return dp[i][j]=Math.max(lcs(i,j-1,a,b,dp),lcs(i-1,j,a,b,dp));
        }
    }
    public int longestCommonSubsequnce(String text1,String text2)
    {
        StringBuilder a =new StringBuilder(text1);
        StringBuilder b= new StringBuilder(text2);
        int m=a.length();
        int n= b.length();
        int[][]dp= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return lcs(m-1,n-1,a,b,dp);
    }
    public String reverse(String s)
    {
        StringBuilder sb= new StringBuilder(s);
        sb.reverse();
        s=sb.toString();
        return s;
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequnce(s,reverse(s));
    }
}

//Leetcode 1312
class Solution {
     public int lcs(int i,int j,StringBuilder a, StringBuilder b,int[][]dp) {
       if(i<0||j<0) return 0;
       if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        {
            return dp[i][j]=1+lcs(i-1,j-1,a,b,dp);
        }
        else
        {
            return dp[i][j]=Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp));
        }
        
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m=a.length();
        int n= b.length();
        int [][]dp=new int[m][n];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
       return lcs(m-1,n-1,a,b,dp);
        
    }
    public String reverse(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s=sb.toString();
        return s;
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, reverse(s));
    }
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
}

//LEetcode 583
class Solution {
    public int minDistance(String word1, String word2) {
        //find LCS for word1 and word2
        //we know the lcs_len for each
        //no. of deletions for word1=word1.length-lcs_len
        //no of deletions for word2=wprd2.length-lcs_len
        //total deletions=deletion1-deletion2
        int m=word1.length();
        int n=word2.length();
        int[][]dp= new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs_len=dp[m][n];
        return (m-lcs_len)+(n-lcs_len);
    }
}

//Leetcode 72
class Solution {
    public int minSteps(int i,int j,StringBuilder a,StringBuilder b,int[][]dp)
    {
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        return dp[i][j]=minSteps(i-1,j-1,a,b,dp);
        else
        {
            int del=minSteps(i-1,j,a,b,dp);
            int ins=minSteps(i,j-1,a,b,dp);
            int rep=minSteps(i-1,j-1,a,b,dp);
            return dp[i][j]=  1+Math.min(del,Math.min(ins,rep));
        }

    }
    public int minDistance(String word1, String word2) {
        StringBuilder a= new StringBuilder(word1);
        StringBuilder b= new StringBuilder(word2);
        int m= a.length(),n=b.length();
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return minSteps(m-1,n-1,a,b,dp);
    }
}

//Leetcode 96
class Solution {
    public int numTrees(int n) {
        //1 d dp and nested loops
        if(n<=1) return 1;
        int[]dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
        {
            for(int j=1;j<=i;j++) //j can be 1,2...
            {
                dp[i]+=(dp[j-1]*dp[i-j]);
            }
        }
        return dp[n];
    }
}

//Leetcode 647
class Solution {
    public int countSubstrings(String s) {
        int n=s.length(),count=0;
        int[][]dp = new int[n][n];
    for(int k=0;k<n;k++)
    {
        int i=0, j=k;
        while(j<n)
        {
            if(i==j) {dp[i][j]=1; count++;}
            else if (j==i+1){
                if(s.charAt(i)==s.charAt(j)) {dp[i][j]=1; count++;}
            }
            else
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    if(dp[i+1][j-1]==1) {dp[i][j]=1;
                    count++;}
                }
            }
            i++;
            j++;
        }
    }
    return count;
    }
}

//LONGEST COMMON SUBSTRING
int m=a.length(), n=b.length();
int[][]dp= new int[m+1][n+1];
int max=0;
for(int i=1;i<=m;i++)
{
  for(int j=1;j<=n;j++)
  {
    if(a.charAt(i-1)==b.charAt(j-1)
    {
      dp[i][j]=1+dp[i-1][j-1];
    }
    else
    {  
      dp[i][j]=0;
    }
    max=Math.max(max,dp[i][j]);
  }
}
return max;

//DIAMETER OF BINARY TREE
//METHOD !: Using binary tree
class Solution {
    public int levels(TreeNode root)
    {
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int dia= levels(root.left)+levels(root.right);
        int leftDia= diameterOfBinaryTree(root.left);
        int rightDia=diameterOfBinaryTree(root.right);
        return Math.max(dia,Math.max(leftDia,rightDia));
    }
}

//the max path will always pass through root-False (it is not necessary)

//METHOD 2
//memoization using HashMap<TreeNode,Integer>
class Solution
{
    static Map<TreeNode,Integer> dp;
    public int levels(TreeNode root)
    {
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int leftLevels=levels(root.left);
        int rightLevels=levels(root.right);
        dp.put(root,1+Math.max(leftLevels,rightLevels)); //in put it is the ans of this root is this
        return dp.get(root);
    }
    public int diameter(TreeNode root)
    {
        if(root==null) return 0;
        int myDia=levels(root.left)+levels(root.right);
        int leftDia=diameter(root.left);
        int rightDia=diameter(root.right);
        return Math.max(myDia,Math.max(leftDia,rightDia));
    }
    public int diameterOfBinaryTree(TreeNode root)
    {
        dp=new HashMap<>();
        return diameter(root);
    }
}

//using memoization
// public int levels(TreNode root,int[]data)
// {
//     if(root==null) return 0;
//     int leftLevels=levels(root.left);
//     int rightLevels=levels(root.right);
//     int path=leftLevels+rightLevels;
//     dia[0]=Math.max(dia[0],path);
//     return 1+Math.max(leftLeveles+rigthLevels);
// }
// public int diameterOfBinarayTree(TreeNode root)
// {
//     int[]dia={0};
//     leveles(root,dia);
//     return dia[0];
// }

//Leetcode 124
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int maxSum;
    public int lineSum(TreeNode root)
    {
        if(root==null) return 0;
        int leftLineSum=lineSum(root.left);
        int rightLineSum=lineSum(root.right);
        int pathSum=root.val;
        if(leftLineSum>0) pathSum+=leftLineSum;
        if(rightLineSum>0) pathSum+=rightLineSum;
        maxSum=Math.max(maxSum,pathSum);
        return root.val+Math.max(0,Math.max(leftLineSum,rightLineSum));
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        lineSum(root);
        return maxSum;
    }
}

//GeekTraining

class Solution {
    //dp[day][last]
    private int maxProfit(int arr[][],int day,int last,int [][]dp)
    {
        if(day==arr.length) return 0;
        if(dp[day][last]!=-1) return dp[day][last];
        int max=0;
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                max=Math.max(max,dp[day][i]+maxProfit(arr,day+1,i,dp));
            }
        }
        return dp[day][last]=max;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n=arr.length;
        int[][]dp= new int[n][4];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return maxProfit(arr,0,3,dp);
    }
}

//Leetcode 120
class Solution {
    private int minimum(List<List<Integer>> triangle,int row,int col,int dp[][])
    {
        if(row==triangle.size()-1) return triangle.get(row).get(col);
        if(dp[row][col]!=-1) return dp[row][col];
        int down=minimum(triangle,row+1,col,dp);
        int diagonal=minimum(triangle,row+1,col+1,dp);
        int sum=0;
        sum=Math.min(diagonal,down)+triangle.get(row).get(col);
        return dp[row][col]=sum;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][]dp= new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return minimum(triangle,0,0,dp);
        
    }
}
//Leetcode 931
//TLE Erro:
class Solution {
    private int minimum(int[][]matrix,int row,int col,int[][]dp)
    {
        if(row==matrix.length) return 0;
        if(col>=matrix.length||col<0) return Integer.MAX_VALUE;
        if(dp[row][col]!=-1) return dp[row][col];
        int down=minimum(matrix,row+1,col,dp);
        int diagonalL=minimum(matrix,row+1,col-1,dp);
        int diagonalR=minimum(matrix,row+1,col+1,dp);
        int sum=0;
        sum=matrix[row][col]+Math.min(down,Math.min(diagonalL,diagonalR));
        return dp[row][col]=sum;
    }
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix.length;
        int[][]dp=new int[row][col];
        int minPath=Integer.MAX_VALUE;
        for(int j=0;j<col;j++)
        {
           minPath=Math.min(minPath,minimum(matrix,0,j,dp));
        }
        return minPath;
        // return minimum(matrix,0,0,dp);  wring becaxz the falling path can start form any col
    }
}
//tabulation technique:
 class Solution {
 public int minFallingPathSum(int[][] matrix) {
    int n=matrix.length;
    if(n==0) return 0;
    for(int row=n-2;row>=0;row--) //no need to iterate through the last row
    {
        for(int col=0;col<n;col++)
        {
            int down=matrix[row+1][col];
            int diagonalL=(col>0)?matrix[row+1][col-1]:Integer.MAX_VALUE;
            int diagonalR=(col<n-1)? matrix[row+1][col+1]:Integer.MAX_VALUE;
            matrix[row][col]+=Math.min(diagonalL,Math.min(down,diagonalR));
        }
    }
    int minSum=Integer.MAX_VALUE;
    for(int col=0;col<n;col++)
    {
        minSum=Math.min(minSum,matrix[0][col]);
    }
    return minSum;
 }}

class Solution {
    public int solve(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
        
        for (int[][] row : dp)
            for (int[] r : row)
                Arrays.fill(r, -1);
        
        return helper(0, 0, m - 1, grid, dp);
    }

    private int helper(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length, m = grid[0].length;

        // Out of bounds
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return Integer.MIN_VALUE;

        // Base case: last row
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int nj1 = j1 + d1;
                int nj2 = j2 + d2;
                int current = 0;

                if (j1 == j2)
                    current = grid[i][j1];
                else
                    current = grid[i][j1] + grid[i][j2];

                int next = helper(i + 1, nj1, nj2, grid, dp);
                if (next != Integer.MIN_VALUE) {
                    max = Math.max(max, current + next);
                }
            }
        }

        return dp[i][j1][j2] = max;
    }
}
//perfect sum gfg

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][]dp= new int[n+1][target+1];
        //sum agr 0 hai toh 1 hii way hai
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                //sjkip
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j)
                {
                    //pick
                    dp[i][j]=dp[i][j]+dp[i-1][j-nums[i-1]];
                }
            }
            
        }
        return dp[n][target];
    }
}

//partition with given difference:

class Solution {

    int countPartitions(int[] arr, int d) {
        // code here
        int totalSum=0;
        for(int ele:arr)
        {
            totalSum+=ele;
        }
        if((totalSum+d)%2!=0 || totalSum<d) return 0;
        int target=(totalSum+d)/2;
    
        int n=arr.length;
        int[][]dp= new int[n+1][target+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1; //becaz ony 1 way if sum is zero
            
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(arr[i-1]<=j)
                {
                    //pick
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
                //skip
                else{dp[i][j]=dp[i-1][j];}

            }
            
        }
        return dp[n][target];
    }
}

//LEetcode 518
class Solution {
    public int coins(int i,int[]coins,int target,int[][]dp)
    {
        if(i==coins.length) 
        {
            if(target==0) return 1;
            else return 0;

        }
        if(dp[i][target]!=-1) return dp[i][target];
        int skip=coins(i+1,coins,target,dp);
        if(target-coins[i]<0) return dp[i][target]=skip;
        int pick=coins(i,coins,target-coins[i],dp);
        return dp[i][target]=pick+skip;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp= new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return coins(0,coins,amount,dp);
    }
}
class Solution {
    private int price(int i,int[]price,int[]dp)
    {
        
        if(i==0) return 0;
        int maxVal= Integer.MIN_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=1;j<=i;j++)
        {
            int cutVal=price[j-1]+price(i-j,price,dp);
            maxVal= Math.max(cutVal,maxVal);
        }
        return dp[i]=maxVal;
    }
    public int cutRod(int[] price) {
        // code here
        
        int n=price.length;
        int[]dp= new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        return price(n,price,dp);
    }
}

//longest common substring
class Solution {
     int maxLen=0;
    public int lcs(int i,int j,StringBuilder a, StringBuilder b,int dp[][])
    {
        if(i<0||j<0) return 0;
       
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        {
            dp[i][j]=1+lcs(i-1,j-1,a,b,dp);
            maxLen=Math.max(maxLen,dp[i][j]);
            return dp[i][j];
        }
        else
        {
         dp[i][j]=0;
         return 0;
        }
        
    }
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        StringBuilder a = new StringBuilder(s1);
        StringBuilder b= new StringBuilder(s2);
        int n=s1.length();
        int m=s2.length();
        int [][]dp= new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        
         for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                lcs(i, j, a, b, dp);

        return maxLen;
        
    }
}
//Solved ques :
Questions Solved:
Leetcode 509
Leetcode 746
Leetcode 1137
friends pairing
count dearrangements
Leetcode 120
LCS
Leetcode 516
Leetcode 583
Geek training
Leetcode 96
Leetcode 198
Leetcode 70
Leetcode 62
Leetcode 64
Leetcode 1277
Leetcode 63
Leetcode 279
Leetcode 213
Leetcode 416
Leetcode 2915
Leetcode 494
Leetcode 2786
Leetcode 322
Leetcode 516
Leetcode 1312
Leetocode 583
Leetcode 72
Leetcode 96
Leetcode 1092
Leetcode 647
Leetcode 543
Leetcode 124
Leetcode 931
chocolate pickup
perfect sum
partition with given difference 
Leetcode 518
Rod cut
Longest common substring
