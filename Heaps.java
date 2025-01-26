//Leetcode 973:
class Solution {
    //which point has the lowest 
    //make a maxheap and map<Distance,Coordinates>
    //distance,coordinates-> int,arr
    class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer,Pair> map= new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<points.length;i++)
        {
            int x=points[i][0];
            int y=points[i][1];
            int dist=x*x+y*y;
            pq.add(dist);
            Pair corr=new Pair(x,y);
            map.put(dist,corr);
            if(pq.size()>k)  pq.remove();
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++)
        {
            int dist1=pq.remove();
            Pair pt= map.get(dist1);
            ans[i][0]=pt.x;//x coordinate
            ans[i][1]=pt.y;//y coordinate

        }
        //wrong ans becaz if same dist gives an issue
        return ans;
    }
}

//for maximum cases this code works but if the dist becomes same for two points then it causes issues

//USE CUSTOM COMPARATOR
//if adding an object in priority use use comparable
class Solution {
 
    class Triplet implements Comparable<Triplet>
    {
        int d;
        int x;
        int y;

        Triplet(int d,int x,int y)
        {
            this.d=d;
            this.x=x;
            this.y=y;
        }
        public int compareTo(Triplet t)
        {
            return this.d- t.d;
        }
    }
    
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Triplet> pq= new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<points.length;i++)
            {
                int x=points[i][0];
                int y=points[i][1];
                int dist=x*x+y*y;
                Triplet t= new Triplet(dist,x,y);
                pq.add(t);
                if(pq.size()>k) pq.remove();
            }
            int[][]ans= new int[k][2];
            for(int i=0;i<k;i++)
            {
                Triplet t=pq.remove();
                ans[i][0]=t.x;
                ans[i][1]=t.y;
            }
            return ans;
        }
}

//Leetcode 658
class Solution {
    class Pair implements Comparable<Pair>
    {
        int p;
        int q;
        //no. and diff
        Pair(int p,int q)
        {
            this.p=p;
            this.q=q;
        }
        public int compareTo(Pair other)
        {
            if(this.q==other.q)
            {
                return this.p-other.p; //sort by val
            }
            return this.q-other.q; //sort by diff
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++)
        {
            int p=arr[i];
            int q=Math.abs(arr[i]-x);
            Pair s= new Pair(p,q);
            pq.add(s);
            if(pq.size()>k) pq.remove();
        }
        List<Integer> ans =new ArrayList<>();
        while(!pq.isEmpty())
        {
            ans.add(pq.remove().p);
        }
        Collections.sort(ans);
        return ans;

    }
}

//Leetcode 347
class Solution {
    class Pair implements Comparable<Pair>
    {
        int ele;
        int freq;
        Pair(int ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
        public int compareTo(Pair p)
        {
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
       int [] ans= new int[k];
       HashMap<Integer,Integer> map=new HashMap<>();
       
       for(int ele: nums)
       {
        if(map.containsKey(ele))
        { int freq=map.get(ele);
            map.put(ele,freq+1);}
          else map.put(ele,1);
       }
     PriorityQueue<Pair> pq= new PriorityQueue<>();
     for(int ele:map.keySet())
     {
        Pair p= new Pair(ele,map.get(ele));
        pq.add(p);
        if(pq.size()>k) pq.remove();
     }
     for(int i=0;i<k;i++)
     {
        Pair p=pq.remove();
        ans[i]=p.ele;
     }

       return ans;
    }
}

//Leetcode 1636
class Solution {
    class Pair implements Comparable<Pair>
    {
        int ele;
        int freq;
        Pair(int ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
        public int compareTo(Pair p)
        {
            if(this.freq==p.freq)
            {
                return p.ele-this.ele; //sort by ele
            }
            return this.freq-p.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[]ans = new int[nums.length];
        for(int ele:nums)
        {
            if(map.containsKey(ele))
            {
                int freq=map.get(ele);
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(int ele:map.keySet())
        {
            Pair p = new Pair(ele,map.get(ele));
            pq.add(p);
            
        }
        int index=0;
        while(!pq.isEmpty())
        {
            Pair p=pq.remove();
            for(int i=0;i<p.freq;i++)
            {
                ans[index++]=p.ele;
            }
        }
        
        return ans;
    }
}

//Leetcode 1046
// class Solution {
//     public int lastStoneWeight(int[] stones) {
//      List<Integer> arr = new ArrayList<>()   ;
//      for(int ele:stones)
//      {
//         arr.add(ele)
//         ;
//      }
//      while(arr.size()>1)
//      {
//         Collections.sort(arr);
//         int y= arr.remove(arr.size()-1);
//         int x =arr.remove(arr.size()-1);
//         if(y!=x) arr.add(y-x);
//      }
//      if(arr.size()==0) return 0;
//      else return arr.get(0);
//     }
// }  BAD TIME COMPLEXITY summation rlogr 
class Solution{
    public int lastStoneWeight(int[] stones) {
          PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
          int n=stones.length;
          for(int i=0;i<n;i++)
          {
            pq.add(stones[i]);
          }
          while(pq.size()>1)
          {
            int a=pq.remove();
            int b=pq.remove();
            int c= a-b;
           if(c>0) pq.add(c);
          }
          if(pq.isEmpty()) return 0;
          return pq.peek();

    }
}

//Leetcode 703
class KthLargest {
        private PriorityQueue<Integer> p= new PriorityQueue<>();
        private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
       p= new PriorityQueue<>();
       for(int num:nums)
       {
        p.add(num);
        if(p.size()>k) p.remove();
       }
    }
    
    public int add(int val) {
        p.add(val);
        if(p.size()>k) p.remove();
         return p.peek();
    }
   
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

//Leetcode 373
import java.util.*;

class Solution {
    class Triplet implements Comparable<Triplet> {
        int sum, x, y;
        
        Triplet(int sum, int x, int y) {
            this.sum = sum;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Triplet t) {
            return Integer.compare(this.sum, t.sum);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        
    
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new Triplet(nums1[i] + nums2[0], i, 0));
        }


        while (k-- > 0 && !pq.isEmpty()) {
            Triplet curr = pq.poll();
            ans.add(Arrays.asList(nums1[curr.x], nums2[curr.y]));

            if (curr.y + 1 < nums2.length) {
                pq.add(new Triplet(nums1[curr.x] + nums2[curr.y + 1], curr.x, curr.y + 1));
            }
        }
        
        return ans;
    }
}

//Leetcode 295
//METHOD -1
// class MedianFinder {
//     List<Integer> arr=new ArrayList<>();


//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//         arr.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(arr);
//         int n=arr.size();
//         if(n%2!=0)//odd 
//         {
//             return arr.get(n/2);
//         }
//         else
//         return (arr.get(n/2)+arr.get(n/2-1))/2.0;
//     }
// }
//MEthod 2
//error time limit exceed
// class MedianFinder {
//     List<Integer> arr=new ArrayList<>();


//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//         arr.add(num);
//         int i=arr.size()-1;
//         while(i>0)
//         {
//             if(arr.get(i)<arr.get(i-1))
//             {
//                 swap(i,i-1);
//                 i--;

//             }
//             else break;
//         }
//     }
//     public void swap(int i,int j)
//     {
//         int temp=arr.get(i);
//         arr.set(i,arr.get(j));
//         arr.set(j,temp);
//     }
//     public double findMedian() {
//         Collections.sort(arr);
//         int n=arr.size();
//         if(n%2!=0)//odd 
//         {
//             return arr.get(n/2);
//         }
//         else
//         return (arr.get(n/2)+arr.get(n/2-1))/2.0;
//     }
// }
//method -3(using heap)
import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0) {
            maxHeap.add(num);
        } else {
            if(num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        
        // Balance the heaps
        //so that donp meh sirf ekk ele ka antar ho
        if(maxHeap.size() == minHeap.size() + 2) {
            int top = maxHeap.remove();
            minHeap.add(top);
        }
        if(minHeap.size() == maxHeap.size() + 2) {
            int top = minHeap.remove();
            maxHeap.add(top);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
