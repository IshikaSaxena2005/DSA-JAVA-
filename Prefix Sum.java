//Leetcode 1480
class Solution {
    public int[] runningSum(int[] nums) {
     int n = nums.length;
     for(int i=1;i<n;i++)   
     {
        nums[i]+=nums[i-1];

     }
     return nums;
    }
}
//Leetcode 303
class NumArray {
int[]arr;
    public NumArray(int[] nums) { //constructor since it does not have return type
            arr=nums;//shallow copy
        
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

//Leetcode 724
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n=nums.length;
//         for(int i=0;i<n;i++)
//         {
//             int leftSum=0, rightSum=0;
//             for(int j=0;j<i;j++)
//             {
//                 leftSum += nums[j];
//             }
//             for(int j=i+1;j<n;j++)
//             {
//                 rightSum+=nums[j];
//             }
//             if(leftSum == rightSum) return i;

//         }
//         return -1;
//     }
// }
// TC:O(n2^) methpd is brutforce

class Solution {// method 2:prefix sum  //TC:O(n)
//extra space O(1)
    public int pivotIndex(int[] nums) {
        int n= nums.length;
        //th better approach is prefix sum 
        for(int i=1;i<n;i++)
        {
            nums[i]+=nums[i-1];
        }
        for(int i=0;i<n;i++)
        {
            int leftSum=0;
            if(i>0) leftSum= nums[i-1];
            int rightSum = nums[n-1]- nums[i];
            if(leftSum==rightSum) return i;
        }
        return -1;

    }}

//Leetcode 2640
class Solution {
    public long max(long i,long j)
    {
        return Math.max(i,j);
    }
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        long maxVal=0;
        for(int i=0;i<n;i++)
        {
            maxVal=max(maxVal,nums[i]);
            arr[i]=nums[i]+maxVal;
        }
        for(int i=1;i<n;i++)
        {
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
    }
}
