//Leetcode 2442
class Solution {
    public int reverse(int n)
    {
        int r=0;
        while(n!=0)
        {
            r=r*10+n%10;
            n/=10;
        }
        return r;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }
}

//Leetcode 2744
class Solution {
    public String reverse(String s)
    {
        StringBuilder sb= new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        int count=0;
        HashSet<String> set= new HashSet<>();
        for(int i=0;i<words.length;i++)
        {
            String rev=reverse(words[i]);
            if(set.contains(rev))
            {
                count++;
            }
            else set.add(words[i]);
        }
        return count;
    }
}

//Leetcode 1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans={-1,-1};
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int rem=target-nums[i];
            if(map.containsKey(rem))
            {
                ans[0]=i;
                ans[1]=map.get(rem);
                break;
            }
            else map.put(nums[i],i);
        }
        return ans;
    }
}

//Leetcode 1207
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr)
        {
            if(map.containsKey(ele))
            {
                int freq=map.get(ele);
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        HashSet<Integer> set= new HashSet<>();
        for(int key:map.keySet())
        {
            int val=map.get(key);
            set.add(val);
        }
        return (map.size()==set.size());
    }
}
