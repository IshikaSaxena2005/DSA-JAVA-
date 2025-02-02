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
public int PAirFreind(int n)
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
    return (n-1) * (dearrange(n-1)+ dearrange(n-2);
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
