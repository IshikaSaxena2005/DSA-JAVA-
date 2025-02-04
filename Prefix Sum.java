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

//Leetcode 238
// //O(n^2) approach
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n=nums.length;
//         int [] ans = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             int leftPrd=1,rightPrd=1;
//             for(int j=0;j<i;j++)
//             {
//                 leftPrd *=nums[j];
//             }
//             for(int j=i+1;j<n;j++)
//             {
//                 rightPrd *= nums[j];
//             }
//             ans[i]=leftPrd* rightPrd;
//         }
//         return ans;
//     }
// }//Giving TLE error

class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        //pre[i]=pre[i-1]* arr[i-1]
        int[]pre=new int[n];
        pre[0]=1;
        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1] * arr[i-1];
        }
        int[]suf=new int[n];
        suf[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            suf[i]=arr[i+1]* suf[i+1];
        }
        int[]ans = new int[n];
        for(int i=0;i<n;i++)

        {
            ans[i]=suf[i]* pre[i];
        }
        return ans;
        
    }} //TC:O(n)

//Leetcode 2389
class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        Arrays.sort(arr);
        int n= arr.length, m= queries.length;
        for(int i=1;i<n;i++)
        {
            arr[i] +=arr[i-1];
        }
        int ans[]= new int[m];
        for(int i=0;i<m;i++)
        {
            int lo=0,hi=n-1;
            while(lo<=hi)
            {
                int mid = lo+(hi-lo)/2;
                if(arr[mid]>queries[i]) hi= mid-1;
                else
                {
                    ans[i]= Math.max(ans[i],mid+1);
                    lo = mid+1;
                }
            }
        }
        return ans;
    }
}

//Leetcode 1109
// class Solution {
//     public int[] corpFlightBookings(int[][] arr, int n) {
//         //every array has length 3
//         int[]ans =new int[n];
//         for(int i=0;i<arr.length;i++)
//         {
//             int first=arr[i][0];
//             int last=arr[i][1];
//             int seats=arr[i][2];
//             for(int j=first-1;j<=last-1;j++)
//             {
//                 ans[j]+=seats;
//             }
//         }
//         return ans;

//     }
// }//TC:O(n^2)

class Solution {
    public int[] corpFlightBookings(int[][] arr, int n) {
        int ans[]= new int[n];
        for(int i=0;i<arr.length;i++)
        {
            int first=arr[i][0];
            int last=arr[i][1];
            int seats=arr[i][2];
            ans[first-1]+=seats;
            if(last<n) ans[last]-=seats;
        }
        for(int i=1;i<n;i++)
        {
            ans[i]+=ans[i-1];
        }
        return ans;
    }}


//Leetcode 560
// class Solution {
//     public int subarraySum(int[] arr, int k) {
//         //-ve numbers are also allowed
//         //subarrays sum of elements are equal to k
//         //for each element iterate to the array and update the sum:
//         //TC:  of brut force O(n^2)
//         int count=0;
//         int n=arr.length;
//         for(int i=0;i<n;i++)
//         {
//             int sum=0;
//             for(int j=i;j<n;j++)
//             {
//                 sum+=arr[j];
//                 if(sum==k) count++;
//             }
//         }
//         return count;

//     }
// }

//optimized prefix sum:
//using prefix sum and hashmap
class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //ele,freq
        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==k) count++;
           int rem=arr[i]-k ;
           if(map.containsKey(rem)) count+= map.get(rem);
            if(map.containsKey(arr[i])) 
            {
                int freq=map.get(arr[i]);
                map.put(arr[i],freq+1);}
            else map.put(arr[i],1);
            
           
        }
        return count;
        }
}

//Leetcode 2483
class Solution {
    public int bestClosingTime(String str) {
        int n = str.length();
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        
        // Compute prefix penalties (when the shop is open but no customers come)
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (str.charAt(i - 1) == 'N') {
                pre[i] += 1;
            }
        }
        
        // Compute suffix penalties (when the shop is closed but customers come)
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (str.charAt(i) == 'Y') {
                suf[i] += 1;
            }
        }
        
        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;
        
        // Find the minimum penalty and the earliest hour to close
        for (int i = 0; i <= n; i++) {
            int penalty = pre[i] + suf[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }
        
        return bestHour;
    }
}
