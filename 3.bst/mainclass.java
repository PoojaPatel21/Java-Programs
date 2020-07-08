/*Title :- Implement Binary Search Tree and perform opeartions on it:
 * 1.FIND MIN ,MAX
 * 2.DISPLAY TREE HEIGHT
 * 3.DISPLAY LEVEL WISE
 * 4.DISPLAY DESCENDING ORDER
 * 5.COUNT NUMBER OF LEAF NODES
 * 6.COPY TREE 

 * Roll number :2956
 */

import java.util.*;

 

class node

{

           int data;

           node left,right;

           public node()

           {

                      left=right=null;

                      data=0;

           }

           public node(int d)

           {

                      data=d;

                      left=right=null;

           }

}

class Tree

{

           Scanner sc=new Scanner(System.in);

           node root=new node();

          

           public Tree()

           {

                      root=null;

           }

           void create()

           {

                      int n1,n3;

                      node ptr=new node();

                      do

                      {

                                

                                 System.out.println("\n Enter the data of the node:");

                                 int n2=sc.nextInt();

                                 node temp=new node(n2);

                                 if(root==null)

                                 {

                                            root=temp;

                                 }

                                 else

                                 {

                                           

                                            ptr=root;

                                            do

                                            {

                                                       n3=0;

                                            while(temp.data<ptr.data)

                                            {

                                                       if(ptr.left!=null)

                                                       {

                                                                  ptr=ptr.left;

                                                       }

                                                       else

                                                       {

                                                                  ptr.left=temp;

                                                                  n3=1;

                                                                  break;

                                                      

                                            }}

                                           

                                            while(temp.data>ptr.data)

                                            {

                                           

                                                       if(ptr.right!=null)

                                                       {

                                                                  ptr=ptr.right;

                                                       }

                                                       else

                                                       {

                                                                  ptr.right=temp;

                                                                  n3=1;

                                            break;

                                                       }

                                 }

                                            }while(n3==0);

                                 }

                                 System.out.println("\n Enter 1 to add new node");

                                 n1=sc.nextInt();

                      }while(n1==1);

           }

 

void displayasc(node temp)

{

           if(temp!=null)

           {

                      displayasc(temp.left);

                      System.out.println(temp.data);

                      displayasc(temp.right);

                     

           }

          

}

void displaydesc(node temp)

{

           if(temp!=null)

           {

                      displaydesc(temp.right);

                      System.out.println(temp.data);

                      displaydesc(temp.left);

           }

}

void max(node temp)

{

           while(temp.right!=null)

                      temp=temp.right;

           System.out.println("\n Max node is:"+temp.data);

}

void min(node temp)

{

           while(temp.left!=null)

                      temp=temp.left;

           System.out.println("\n Min node is:"+temp.data);

}

void search()

{

           node ptr=new node();

System.out.println("\n Enter the data to be searched:");

int key=sc.nextInt();

ptr=root;

int flag=0;

while(ptr!=null)

{

           if(ptr.data==key)

           {

                      System.out.println("\n The key element "+key+" is found!");

                      flag=1;

                      break;

           }

           else if(ptr.data<key)

           {

                      ptr=ptr.right;

           }

           else if(ptr.data>key)

           {

                      ptr=ptr.left;

           }

          

                     

}

if(flag==0)

           System.out.println("\n Data not found!");

}

void Insert()

{

           int k;

           System.out.println("\n Enter the data of the  node to be inserted:");

           k=sc.nextInt();

           node temp=new node(k);

           int flag=0;

           node ptr=new node();

           ptr=root;

           if(root==null)

           {

                      root=temp;

                      flag=1;

           }

           else

           while(flag==0)

           {

                      if(temp.data<ptr.data)

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

void levelwise(node ptr)

{

           Queue<node> q=new LinkedList();

           while(ptr!=null)

           {

                      System.out.println(ptr.data);

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
int count(node temp)

{

           if(temp==null)

                      return 0;

else

           if(temp.left==null&&temp.right==null)

           {
        	   
        	      System.out.println("\n Leaf node is:"+temp.data);
                      return 1;
                

           }        

           else

           {

                      return(count(temp.left)+count(temp.right));

          

           }
}



void copy(Tree b)
{
	
	Stack<node> s=new Stack();
	Stack<node> s1=new Stack();
	node ptr=new node();
    node ptr1=new node();
	ptr=root;
	b.root=root;
	ptr1=b.root;


	while(ptr!=null||s.size()>0)
	{
		while(ptr!=null)
		{
			ptr1.data=ptr.data;
		System.out.println(ptr1.data+" ");
		s.push(ptr);
		s1.push(ptr1);
		ptr1=ptr1.left;
		ptr=ptr.left;
	}
	
			
			
			ptr=s.pop();
			ptr1=s1.pop();
			
			ptr=ptr.right;
			ptr1=ptr1.right;
			

}
}
}


public class mainclass {

 

           public static void main(String[] args) {

           Scanner sc=new Scanner(System.in);

           int n1,n2;

           Tree t=new Tree();
           Tree b=new Tree();

           do

           {

                      System.out.println("\n1.Create\n2.Display Ascending\n3.Display Descending\n4.Insert\n5.Copy\n6.Find Min node\n7.Find Max node\n8.Search a node\n9.Level Order\n10.Height comparison\n11.Count leaf nodes:");

                      n1=sc.nextInt();

                      switch(n1)

                      {

                      case 1:t.create();

                      break;

                      case 2:t.displayasc(t.root);

                      break;

                      case 3:t.displaydesc(t.root);

                      break;
                      case 5:t.copy(b);
                      b.displayasc(b.root);
                      break;
                      case 6:t.min(t.root);

                      break;

                      case 7:t.max(t.root);

                      break;

                      case 8:t.search();

                      break;

                      case 4:t.Insert();

                      break;

                      case 9:t.levelwise(t.root);

                      break;

                      case 10:int h=t.height(t.root);
                      System.out.println("\n The height of the tree is:"+h);

                      break;

                      case 11:System.out.println("\n The number of leaf nodes are:"+t.count(t.root));

                      break;     

 

                      }

                      System.out.println("\n Enter 1 to continue:");

                      n2=sc.nextInt();

                     

           }while(n2==1);

           }

 

}
/*OUTPUT :-

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:

1

 Enter the data of the node:
100

 Enter 1 to add new node
1

 Enter the data of the node:
50

 Enter 1 to add new node
1

 Enter the data of the node:
25

 Enter 1 to add new node
1

 Enter the data of the node:
150

 Enter 1 to add new node
1

 Enter the data of the node:
75

 Enter 1 to add new node
1

 Enter the data of the node:
175

 Enter 1 to add new node
1

 Enter the data of the node:
125

 Enter 1 to add new node
1

 Enter the data of the node:
200

 Enter 1 to add new node
0

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
2
25
50
75
100
125
150
175
200

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
3
200
175
150
125
100
75
50
25

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
4

 Enter the data of the  node to be inserted:
130

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
2
25
50
75
100
125
130
150
175
200

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
5
100 
50 
25 
75 
150 
125 
130 
175 
200 
25
50
75
100
125
130
150
175
200

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
6

 Min node is:25

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
7

 Max node is:200

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
8

 Enter the data to be searched:
130

 The key element 130 is found!

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
8

 Enter the data to be searched:
132

 Data not found!

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
9
100
50
150
25
75
125
175
130
200

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
10

 The height of the tree is:4

 Enter 1 to continue:
1

1.Create
2.Display Ascending
3.Display Descending
4.Insert
5.Copy
6.Find Min node
7.Find Max node
8.Search a node
9.Level Order
10.Height comparison
11.Count leaf nodes:
11

 Leaf node is:25

 Leaf node is:75

 Leaf node is:130

 Leaf node is:200

 The number of leaf nodes are:4

 Enter 1 to continue:
0
*/

 
