
import java.util.*;



class node
{
	node left;
	node right;
	String name;
	long tele;
	int height;
	public node()
	{
		left=right=null;  //March, May, November, August, April, January,
		//December, July, February, June, October, September 
		height=1;
		name=null;
		tele=0;
	}
	public node(String d,long t)
	{
		left=right=null;
		name=d;
		height=1;
		tele=t;
		
	}
}
class avl
{
	node root;
	Scanner sc=new Scanner(System.in);
	public avl()
	{
		root=null;
	}
	int height(node temp)
	{
		if (temp==null)  
		       return 0; 
		   else 
		   { 
		   
		       int l = height(temp.left); 
		       int r = height(temp.right); 
		  
		     
		       if (l > r)  
		           return(l+1); 
		       else return(r+1); 
		   } 
	}
	
	public node rightr(node y)
	{
		node x=y.left;
		node t=x.right;
		y.left=t;
		x.right=y;
		
		y.height=height(y);
		x.height=height(x);
		return x;
	}
	public node leftr(node y)
	{
		node x=y.right;
		node t=x.left;
		y.right=t;
		x.left=y;
		
		y.height=height(y);
		x.height=height(x);
		return x;
	}
	public node insert(node temp,String n,long t)
	{
		if(temp==null)
			return( new node(n,t));
		
		if(n.compareTo(temp.name)<0)
			temp.left=insert(temp.left,n,t);
		else if(n.compareTo(temp.name)>0)
			temp.right=insert(temp.right,n,t);
		else 
			return temp;
		
		temp.height=height(temp);
		int balance=getBal(temp);
		if(balance>1&&n.compareTo(temp.left.name)<0)
		{
		System.out.println("\n Right Rotation i.e. LL" );
		return rightr(temp); //ll
		}
		if(balance<-1&&n.compareTo(temp.right.name)>0)
		{
			System.out.println("\n  Left Rotation i.e. RR");
			return leftr(temp);//rr
		}
		if(balance>1&&n.compareTo(temp.left.name)>0)
		{
			System.out.println("\n LR Rotation");
			temp.left=leftr(temp.left);    //first rr then ll
			return rightr(temp);           // that is LR
			
		}
	
	if(balance<-1&&n.compareTo(temp.right.name)<0)
		{
		System.out.println("\n RL Rotation");
			temp.right=rightr(temp.right);   //first ll then rr 
			return leftr(temp);   ///that is RL
			
		}
	return temp;
		
		
	}
	public int getBal(node temp) {
		if(temp==null)
		return 0;
		return(height(temp.left)-height(temp.right));
	}
	
	public void levelorder(node ptr)
	{
		   Queue<node> q=new LinkedList();

           while(ptr!=null)

           {

                      System.out.println("\n Name:"+ptr.name+"\n Telephone:"+ptr.tele);

                      if(ptr.left!=null)

                                 q.add(ptr.left);

                     

                      if(ptr.right!=null)

                                 q.add(ptr.right);

                      if(q.isEmpty())

                                 ptr=null;

                      else

                      ptr=q.remove();

           }

          
					
	}
	
	public void inorder(node temp)
	{
		if (temp!=null)
		{
			inorder(temp.left);
			System.out.println("Name:"+temp.name+"\n Telephone:"+temp.tele);
			inorder(temp.right);
		}
	}
	
	public void preorder(node temp)
	{
		if(temp!=null)
		{
			System.out.println("Name:"+temp.name+"\n Telephone:"+temp.tele);
			preorder(temp.left);
			preorder(temp.right);
		}
		
	}
	
	
}
public class avltree {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		int n1=0,n2=0,n3=0;
		avl a=new avl();
		do
			
		{
			System.out.println("\nMenu\n1.Create\n2.Display(Levelorder)\n3.Display(Inorder)\n4.Display(PreOrder)\nChoose:");
			n1=sc.nextInt();
			switch(n1)
			{
			case 1:do
			{
				System.out.println("\n Enter the details of the customer:");
				System.out.println("\n Enter the name of the customer:");
				String name=sc.next();
				System.out.println("\n Enter the Telephone of the customer:");
				long t=sc.nextLong();
				a.root=a.insert(a.root, name, t);
				System.out.println("\n Enter 1 to add new node:");
				n3=sc.nextInt();
			}while(n3==1);
			break;
			case 2:a.levelorder(a.root);
			break;
			case 3:a.inorder(a.root);
			break;
			case 4:a.preorder(a.root);
			}
			System.out.println("\n Enter 1 to continue:");
			n2=sc.nextInt();
			
		}while(n2==1);
	}

}

//* OUTPUT:-
/*
 * 
Menu
1.Create
2.Display(Levelorder)
3.Display(Inorder)
4.Display(PreOrder)
Choose:
1

 Enter the details of the customer:

 Enter the name of the customer:
 new 

 Enter the Telephone of the customer:
112234455

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
int

 Enter the Telephone of the customer:
2233445566

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
else

 Enter the Telephone of the customer:
3344556677

 Right Rotation i.e. LL

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
void

 Enter the Telephone of the customer:
4455667788

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
return

 Enter the Telephone of the customer:
5566778899

 RL Rotation

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
tree

 Enter the Telephone of the customer:

6677889911

  Left Rotation i.e. RR

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
while

 Enter the Telephone of the customer:
8899112233

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
false

 Enter the Telephone of the customer:
9988776655

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
false

 Enter the Telephone of the customer:
8877665544

 Enter 1 to add new node:
1

 Enter the details of the customer:

 Enter the name of the customer:
class

 Enter the Telephone of the customer:
22338877

 Enter 1 to add new node:
0

 Enter 1 to continue:
1

Menu
1.Create
2.Display(Levelorder)
3.Display(Inorder)
4.Display(PreOrder)
Choose:
2

 Name:return
 Telephone:5566778899

 Name:int
 Telephone:2233445566

 Name:void
 Telephone:4455667788

 Name:else
 Telephone:3344556677

 Name:new
 Telephone:112234455

 Name:tree
 Telephone:6677889911

 Name:while
 Telephone:8899112233

 Name:class
 Telephone:22338877

 Name:false
 Telephone:9988776655

 Enter 1 to continue:
1

Menu
1.Create
2.Display(Levelorder)
3.Display(Inorder)
4.Display(PreOrder)
Choose:
2

 Name:return
 Telephone:5566778899

 Name:int
 Telephone:2233445566

 Name:void
 Telephone:4455667788

 Name:else
 Telephone:3344556677

 Name:new
 Telephone:112234455

 Name:tree
 Telephone:6677889911

 Name:while
 Telephone:8899112233

 Name:class
 Telephone:22338877

 Name:false
 Telephone:9988776655

 Enter 1 to continue:
1

Menu
1.Create
2.Display(Levelorder)
3.Display(Inorder)
4.Display(PreOrder)
Choose:
3
Name:class
 Telephone:22338877
Name:else
 Telephone:3344556677
Name:false
 Telephone:9988776655
Name:int
 Telephone:2233445566
Name:new
 Telephone:112234455
Name:return
 Telephone:5566778899
Name:tree
 Telephone:6677889911
Name:void
 Telephone:4455667788
Name:while
 Telephone:8899112233

 Enter 1 to continue:
0
*/

	