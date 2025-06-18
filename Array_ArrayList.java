//LINEAR SEARCH
System.out.print("Enter the target ele:");
int n=sc.nextInt();
System.out.print("Enter the size of the array");
int size=sc.nextInt();
System.out.print("Enter the elements");
int[]arr= new int[size];
for(int i=0;i<size;i++)
  {
    arr[i]=sc.nextInt();
  }
for(int i=0;i<size;i++)
  {
    if(arr[i]==n)
    {
      return 1;
    }
    
  }
return 0;

//second largest ele of array:
int mx=Integer.MIN_VALUE;
for(int i=0;i<n;i++)
  {
    mx=Math.max(mx,arr[i]); //first max
  }
int smx=Integer.MIN_VALUE;
for(int i=0;i<n;i++)
  {
    if(arr[i]!=mx)
    {
      smx=Math.max(smx,arr[i]);
    }
  }
return smx;

//pass by reference
psvmsa
  {
  int arr[] ={10,2};
  SOP(arr[0]);  //10
  change(arr);
  SOP(arr[0]);  //90
  }
change(int[]arr)
  {
  arr[0]=90;
  }

//Arrays.sort()

int[]arr={10,20.30};
int[]nums=arr; //shallow copy
 nums[1]=60;
SOP(arr[1]); //60

int[]arr={10,20,30};
int[]brr=Arrays.copyOf(arr,arr.length); //deep copy
brr[1]=50;
SOP(arr[1]); //10

int[]crr=new int[arr.length];
for(int i=1;i<Arr.length;i++)
  {
    crr[i]=arr[i]; //deep copy
  }



//marking the rows anc cols   TC:O(m*n) SC:O(n+m)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length; //row
        int n=matrix[0].length; //col
        boolean[] row = new boolean[m];
        boolean[]col= new boolean[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(row[i] ||col[j])
                {
                    matrix[i][j]=0;
                }

            }
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Mark the first row and column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // Step 2: Use the first row and column to mark zeros
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark col
                }
            }
        }

        // Step 3: Zero out cells based on marks
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Zero out first row and col if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


//REVERSE ARRAY

public int[]reverse(int []arr)
  {
    for(int i=0;i<(arr.length)/2;i++)
      {
        int j=arr.length-i-1;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
  return arr;
  }

//2 pointer approach
public int[]reverse(int[]arr)
  {
  int i=0;
  int j=arr.length-1;
  while(i<=j)
    {
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
      i++;
      j--;
        
    }
  return arr;
  }




class Solution {
    private int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long makeSubKSumEqual(int[] arr, int k) {
        int n=arr.length;
        int g=gcd(n,k);
        
        long totalOps=0;
        for(int i=0;i<g;i++)
        {
            ArrayList<Integer> group= new ArrayList<>();
            int j=i;
            do
            {
                group.add(arr[j]);
                j=(j+k)%n;
            }
            while(j!=i);
                   Collections.sort(group);
                    int median= group.get(group.size()/2);
        for(int val: group)
        {
            totalOps+=Math.abs(val-median);
        }

        }
 
       
    return totalOps;
    }

}

//merge 2 sorted arrays
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]ans=new int[m+n];
        int k=0;
        int i=0;
        int j=0;
        while(i<m &&j<n)
        {
            if(nums1[i]<nums2[j])
            {
                ans[k]=nums1[i];
                 i++;
                k++;
            }
            else 
            {
                ans[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m)
        {
            ans[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n)
        {
            ans[k]=nums2[j];
            j++;
            k++;
        }
          for (int p = 0; p < m + n; p++) {
            nums1[p] = ans[p];}
    }
}














