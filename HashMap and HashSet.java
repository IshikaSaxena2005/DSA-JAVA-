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

//Leetcode 2094
import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : digits) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 100; i <= 999; i++) {
            int x = i;
            int c = x % 10; // Last digit
            x /= 10;
            int b = x % 10; // Middle digit
            x /= 10;
            int a = x % 10; // First digit

            if (c % 2 != 0) continue;

        
            HashMap<Integer, Integer> tempMap = new HashMap<>(map);

       
            if (tempMap.getOrDefault(a, 0) > 0 &&
                tempMap.getOrDefault(b, 0) > 0 &&
                tempMap.getOrDefault(c, 0) > 0) {
                
                tempMap.put(a, tempMap.get(a) - 1);
                tempMap.put(b, tempMap.get(b) - 1);
                tempMap.put(c, tempMap.get(c) - 1);

               
                if (tempMap.get(a) >= 0 && tempMap.get(b) >= 0 && tempMap.get(c) >= 0) {
                    ans.add(i);
                }
            }
        }

        
        int[] ans1 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans1[i] = ans.get(i);
        }

        return ans1;
    }
}

//Leetcode 3
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int n = s.length();
        if (n <= 1) return n;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        
        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }
            map.put(ch, j);
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }
        
        return maxlen;
    }
}

//Leetcode 1497
import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int ele = ((arr[i] % k) + k) % k; // Ensure non-negative remainder
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (key == 0) { 

                if (map.get(key) % 2 != 0) return false;
            } else {
                int rem = k - key;
                if (key == rem) { 
          
                    if (map.get(key) % 2 != 0) return false;
                } else {
                    if (!map.containsKey(rem) || !map.get(key).equals(map.get(rem))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

//Top view of Binaray Tree
public static class Pair
    {
        TreeNode node;
        int level;
        Pair(TreeNode node,int level)
        {
            this.node=node;
            this.level=level;
        }
    }
public static void topView(TreeNode root)
{
    //level and node value
    HashMap<Integer,Integer> map=new HashMap<>();
    Queue<Pair> q= new LinkedList<>();
    Pair r = new Pair(root,0);
    int minLevel=Integer.MAX_VALUE;
    int maxLevel=Integer.MIN_VALUE;
    q.add(r);
    while(q.size()>0)
        {
            Pair temp=q.remove();
            TreeNode node=temp.node;
            int lvl=temp.level;
            minLevel=Math.min(minLevel,lvl);
            maxLevel=Math.max(maxLevel,lvl);
            if(!map.containsKey(lvl))
            {
                map.put(lvl,node.data);
            }
            if(node.left!=null) q.add(new Pair(node.left,lvl-1);
            if(node.right!=null) q.add(new PAir(node.right,lvl+1);
        }
    for(int =minLevel;i<=maxLevel;i++)
        {
            System.out.print(map.get(i)+"");
        }
}

//Leetcode 1814
//[42,11,1,97]
//nums[i]+rev(nums[j]) == nums[j] + rev(nums[i]) -> count++
class Solution {
    public int reverse(int n)
    {
        int r=0;
        while(n!=0)
        {
            r=r*10 +n%10;
            n/=10;
        }
        return r;
    }
    public int countNicePairs(int[] nums) {
        int count=0;
        int n= nums.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+reverse(nums[j])== nums[j]+ reverse(nums[i]))
                {
                    count++;
                }
            }
        }
        return count;
    }
} //TLE error

make it: nums[i]-rev(nums[i]) == nums[j]-rev(nums[j])


//Leetcode 138
    class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        HashMap<Node,Node> map= new HashMap<>();
        while(temp!=null)
        {
            Node newNode= new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            Node copyNode = map.get(temp);
            copyNode.next=map.get(temp.next);
            copyNode.random=map.get(temp.random);
        }
        return map.get(head);
    }}

//Leetcode 1679
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int freq=map.get(nums[i]);
                map.put(nums[i],freq+1);
            }
            else map.put(nums[i],1);
        }
        for(int num:nums)
        {
            int comp=k-num;
            if(map.containsKey(comp) && map.containsKey(num))

            {
                if(map.get(num)>0 && map.get(comp)>0)    
                {
                    if(num==comp && map.get(num)<=1 )
                    {continue;} //if numbers are same
                    map.put(num,map.get(num)-1);
                    map.put(comp,map.get(comp)-1);
                    count++;
                }
            }
        }
return count;
        
    }
}

//Leetcode 1930
import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            first.putIfAbsent(ch, i); 
            last.put(ch, i); 
        }

        int count = 0;
        
    
        for (char ch : first.keySet()) {
            int firstIdx = first.get(ch);
            int lastIdx = last.get(ch);
            
            if (firstIdx + 1 < lastIdx) { 
                Set<Character> set = new HashSet<>();
                for (int i = firstIdx + 1; i < lastIdx; i++) {
                    set.add(s.charAt(i));
                }
                count += set.size();
            }
        }
        
        return count;
    }
}

//Leetcode 1865
class FindSumPairs {
int[] nums1, nums2;
HashMap<Integer, Integer> freq = new HashMap<>();
public FindSumPairs(int[] nums1, int[] nums2) {
this.nums1 = nums1;
this.nums2 = nums2;
for (int x : nums2) increaseFreq(x, 1);
}


private void increaseFreq(int key, int inc) {
freq.put(key, freq.getOrDefault(key, 0) + inc);
}
public void add(int index, int val) {
increaseFreq(nums2[index], -1); // Remove old one
nums2[index] += val;
increaseFreq(nums2[index], 1); // Count new one
}
public int count(int tot) {
int ans = 0;
for (int a : nums1)
ans += freq.getOrDefault(tot - a, 0); // a + b = tot

return ans;
}
}


