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
