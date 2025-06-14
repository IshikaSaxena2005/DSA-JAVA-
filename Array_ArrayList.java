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





















