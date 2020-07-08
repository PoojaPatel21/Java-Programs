package heaps;
import java.util.*;
class min
{
	void min_heapify(int a[],int i,int n)
	{
	    int j, temp;
	    temp = a[i];
	    j = 2 * i;
	    while (j <= n)
	    {
	        if (j < n && a[j+1] < a[j])
            j = j + 1;
	        if (temp < a[j])
	            break;
	        else if (temp >= a[j])
	        {
	            a[j/2] = a[j];
	            j = 2 * j;
	        }
	    }
	    a[j/2] = temp;
	    return;
	}
	void build_minheap(int a[], int n)
	{
	    int i;
	    for(i = n/2; i >= 1; i--)
	    {
	        min_heapify(a,i,n);
	    }
	}

}

public class heap {

	public static void main(String[] args) {
	
			
	
			
			Scanner sc=new Scanner(System.in);
			    int n, i, x;
			    min h=new min();
		System.out.println("enter no of elements of array\n");
			    n=sc.nextInt();
			    int a[]=new int[20];
			    for (i = 1; i <= n; i++)
			    {
			       System.out.println("enter element");
			       a[i]=sc.nextInt();
			        
			    }
			    h.build_minheap(a, n);
			    System.out.println("\n Output is:");
			    for(int k=1;k<=n;k++)
			    {
			    	System.out.print("\t"+a[k]);
			    }
			    
			  
	

	}

}

//20 18 10 12 9 9 3 5 6 8
