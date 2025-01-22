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

//next apporach is using custom comparator
// class Solution {
//     //which point has the lowest 
//     //make a maxheap and map<Distance,Coordinates>
//     //distance,coordinates-> int,arr
//     class Pair
//     {
//         int x;
//         int y;
//         Pair(int x,int y)
//         {
//             this.x=x;
//             this.y=y;
//         }
//     }
//     public int[][] kClosest(int[][] points, int k) {
//         HashMap<Integer,Pair> map= new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for(int i=0;i<points.length;i++)
//         {
//             int x=points[i][0];
//             int y=points[i][1];
//             int dist=x*x+y*y;
//             pq.add(dist);
//             Pair corr=new Pair(x,y);
//             map.put(dist,corr);
//             if(pq.size()>k)  pq.remove();
//         }
//         int[][] ans=new int[k][2];
//         for(int i=0;i<k;i++)
//         {
//             int dist1=pq.remove();
//             Pair pt= map.get(dist1);
//             ans[i][0]=pt.x;//x coordinate
//             ans[i][1]=pt.y;//y coordinate

//         }
//         //wrong ans becaz if same dist gives an issue
//         return ans;
//     }
// }

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
