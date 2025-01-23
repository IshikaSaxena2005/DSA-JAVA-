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
}b
