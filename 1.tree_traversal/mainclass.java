/* Title :- Write a program to perform tree traversal operations like Inorder
 * preorder or postorder using recursive and non recursive methods 
 * Roll number :2956
 */
package tree_traversal;
import java.util.*;
class node
{
	public node left,right;
	public int data;
	public node()
	{
		left=null;
		right=null;
		data=0;
	}
	public node(int d)
	{
		left=null;
		right=null;
		data=d;
	}
	
}

class BinaryTree
{
	Scanner sc=new Scanner(System.in);
	public node root;
	private int n;
	private char s;
	public BinaryTree()
	{
		root=null;
	}
	public void create()
	{
		/*
		node ptr=new node(n);
		root=ptr;
		do
		{
			System.out.println("\n Do you wish to enter the data in the R/L ?");
		
			switch(s)
			{
			case'r': System.out.println("\n Enter data for right node:");
			n=sc.nextInt();
			ptr=new node(n)
				
					
			}
			
			
		}*/
		node ptr=new node();
		int flag=0;
		System.out.println("\n Enter the data:");
		n=sc.nextInt();
		node temp=new node(n);
		if(root==null)
		{
			root=temp;
		
		}
		else
		{
			ptr=root;
		while(flag==0)
		{
			//System.out.println(ptr.data);
			
			System.out.println("\n Enter R/L for "+ptr.data);
			
			s=sc.next().charAt(0);
		


			
			if(s=='l'||s=='L')
			{
				if(ptr.left!=null)
				{
					ptr=ptr.left;
				}
				else
				{
				ptr.left=temp;
				flag=1;
				}
				
			}
			else
			{
				if(ptr.right!=null)
				{
				ptr=ptr.right;
				
			}
				else
				{
					ptr.right=temp;
					flag=1;
				}
			}
			
		
			
	}
	}
	}
	public void inorder(node localRoot)
	{
		if(localRoot!=null)
		{
			inorder(localRoot.left);
			System.out.println(localRoot.data+" ");
			inorder(localRoot.right);
		}
		
	}
	public void preorder(node localRoot)
	{
		if(localRoot!=null)
		{
			System.out.println(localRoot.data+" ");
			preorder(localRoot.left);
			preorder(localRoot.right);
		}
		
	}
	public void postorder(node localRoot)
	{
		if(localRoot!=null)
		{
			
			preorder(localRoot.left);
			preorder(localRoot.right);
			System.out.println(localRoot.data+" ");
		}
		
	}
	public void inOrder()
	{
		Stack<node> s=new Stack();
		node ptr=new node();
		ptr=root;
	
		/*do
		{
		while(ptr!=null)
		{
			s.push(ptr);
			ptr=ptr.left;
		}
			if(!(s.isEmpty()))
					{
				
				
				ptr=s.pop();
				System.out.println(ptr.data+" ");
				ptr=ptr.right;
				
					}
		}while(!s.isEmpty());*/
		
		ptr=root;
		
		while(ptr!=null||s.size()>0)
		{
			
		while(ptr!=null)
		{
			s.push(ptr);
			ptr=ptr.left;
		}
			
				
				
				ptr=s.pop();
				System.out.println(ptr.data+" ");
				ptr=ptr.right;
				
			
		}
		}
		
	
public void preOrder()
{
	Stack<node> s=new Stack();
	node ptr=new node();
	ptr=root;

	while(ptr!=null||s.size()>0)
	{
		while(ptr!=null)
		{
		System.out.println(ptr.data+" ");
		s.push(ptr);
		ptr=ptr.left;
	}
	
			
			
			ptr=s.pop();
			
			ptr=ptr.right;
			
				
	}
	}

public void postOrder()
{
	Stack<node> s=new Stack();
	Stack<String> s1=new Stack();
	node ptr=new node();
	
	ptr=root;
	String ptr1;
	do {
	
		while(ptr!=null)
		{
		s.push(ptr);
		s1.push("L");
		ptr=ptr.left;
	}
	
			if(!s.isEmpty())
			{
			ptr1=s1.pop();
			ptr=s.pop();
			if(ptr1.equals("L"))
			{
				s.push(ptr);
				s1.push("R");
				ptr=ptr.right;
			}
			else
			{
			System.out.println(ptr.data+" ");
		
			ptr=null;
			}
			}			
			
			
				
	}while(!s.isEmpty());
		
		
	}
}


public class mainclass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1,n2;
		BinaryTree b=new BinaryTree();
		do
		{
			System.out.println("\n1.Create \n2.Inorder(Recursive) \n3.Preorder(Recursive)\n4.Postorder(Recursive)\n5.Inorder(Non Recursive)\n6.Preorder(Non Recursive)\n7.Postorder(Non Recursive)\nChoose:");
			n1=sc.nextInt();
			switch(n1)
			{
			case 1:b.create();
			break;
			case 2:b.inorder(b.root);
			break;
			case 3:b.inorder(b.root);
			break;
			case 4:b.postorder(b.root);
			break;
			case 5:b.inOrder();
			break;
			case 6:b.preOrder();
			break;
			case 7:b.postOrder();
			break;
			}
			System.out.println("\n Do you wish to continue? Press 1 if Yes");
			n2=sc.nextInt();
			
		}while(n2==1);
	
	}

}
/*OUTPUT :-
 * 
1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
100

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
150

 Enter R/L for 100
r

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
145

 Enter R/L for 100
r

 Enter R/L for 150
r

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
35

 Enter R/L for 100
r

 Enter R/L for 150
l

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
42

 Enter R/L for 100
r

 Enter R/L for 150
r

 Enter R/L for 145

l

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
90

 Enter R/L for 100
l

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
55

 Enter R/L for 100
l

 Enter R/L for 90
r

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
1

 Enter the data:
67

 Enter R/L for 100
l

 Enter R/L for 90
l

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
2
67 
90 
55 
100 
35 
150 
42 
145 

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
3
67 
90 
55 
100 
35 
150 
42 
145 

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
4
90 
67 
55 
150 
35 
145 
42 
100 

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
5
67 
90 
55 
100 
35 
150 
42 
145 

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:

66

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
6
100 
90 
67 
55 
150 
35 
145 
42 

 Do you wish to continue? Press 1 if Yes
1

1.Create 
2.Inorder(Recursive) 
3.Preorder(Recursive)
4.Postorder(Recursive)
5.Inorder(Non Recursive)
6.Preorder(Non Recursive)
7.Postorder(Non Recursive)
Choose:
7
67 
55 
90 
35 
42 
145 
150 
100 

 Do you wish to continue? Press 1 if Yes
0
*/
