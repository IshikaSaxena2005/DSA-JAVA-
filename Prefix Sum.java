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
