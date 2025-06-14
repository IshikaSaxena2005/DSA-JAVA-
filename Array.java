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






























