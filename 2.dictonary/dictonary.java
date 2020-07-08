/*Title :Create a dictionary that stores keywords and its meanings using appropriate 
data structure ,Implement its operations such as add,delete ,display ,search and
update its values 
Roll number :2956
*/
package dictonary;
import java.util.*;
class node
{
	public String title;
	public String mean;
	
	node left;
	node right;
	public node()
	{
		title=null;
		mean=null;
		left=right=null;
	}
	public node(String t,String m)
	{
		title=t;
		mean=m;
		left=right=null;
	
	}
	



}

class Tree

{
	Scanner sc=new Scanner(System.in);
	public node root;
	node ptr=new node();
	
	public void create()
	{
		int n1,n3;

    node ptr=new node();

    do

    {

              
System.out.println("\n Enter the word:");
String t=sc.next();
System.out.println("\n Enter the meaning:");
String m=sc.next();

               node temp=new node(t,m);

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

                          while((ptr.title.compareToIgnoreCase(temp.title))>0)

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

                         

                          while((ptr.title.compareToIgnoreCase(temp.title))<0)

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
public void display(node temp)
	{
		  if(temp!=null)

	      {

	                 display(temp.left);

	                 System.out.println("\n Word:"+temp.title+"\n Meaning:"+temp.mean);

	                 display(temp.right);

	                

	      }
	
}
public void add()
{


    System.out.println("\n Enter the word:");
    String t=sc.next();
    System.out.println("\n Enter the meaning:");
    String m=sc.next();

    node temp=new node(t,m);

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

               if((temp.title.compareToIgnoreCase(ptr.title))<0)

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
void search()
{

    node ptr=new node();

System.out.println("\n Enter the word whose meaning you want to see");

String key=sc.next();
ptr=root;

int flag=0;

while(ptr!=null)

{

    if(ptr.title.equalsIgnoreCase(key))

    {

               System.out.println("\n The word "+key+" has meaning:"+ptr.mean);

               flag=1;

               break;

    }

    else if((key.compareToIgnoreCase(ptr.title))>0)

    {

               ptr=ptr.right;

    }

    else if((key.compareToIgnoreCase(ptr.title))<0)

    {

               ptr=ptr.left;

    }

   

              

}

if(flag==0)

    System.out.println("\n Word not found!");

}
void update()
{
	node ptr=new node();

	System.out.println("\n Enter the word whose meaning you want to see");

	String key=sc.next();
	ptr=root;

	int flag=0;

	while(ptr!=null)

	{

	    if(ptr.title.equalsIgnoreCase(key))

	    {

	    	System.out.println("\n Word found!:");
	               System.out.println("\n Enter the Updated Meaning:");
	               ptr.mean=sc.next();

	               flag=1;

	               break;

	    }

	    else if((key.compareToIgnoreCase(ptr.title))>0)

	    {

	               ptr=ptr.right;

	    }

	    else if((key.compareToIgnoreCase(ptr.title))<0)

	    {

	               ptr=ptr.left;

	    }

	   

	              

	}

	if(flag==0)

	    System.out.println("\n No such Word found to be Updated!");

}
void delete()
{
	
	node ptr=new node();
node  curr=new node();
	System.out.println("\n Enter the word you want to delete");

	String key=sc.next();
	ptr=root;
	curr=ptr;
	

	int flag=0;

	while(ptr!=null)

	{

	    if(ptr.title.equalsIgnoreCase(key))

	    {

	    	if(ptr.left==null&&ptr.right==null)
	    	{
	    		//System.out.print(curr.title);
	    	if(curr.left!=null)
	    	{
	    		if(curr.left.title.equals(key))
	    		{
	    			curr.left=null;
	    		}
	    	}
	    		else
	    			curr.right=null;
	    		
	    		flag=1;

	               break;

	    }
	    	else if(ptr.left!=null&&ptr.right==null)
	    	{
	    		if(curr.left!=null)
	    		{
	    		if(curr.left.title.equalsIgnoreCase(key))
	    		{
	    			curr.left=ptr.left;
	    		}
	    		}
	    		else
	    			curr.right=ptr.left;
	    		flag=1;

	               break;
	    	}
	    	else if(ptr.left==null&&ptr.right!=null)
	    	{
	    		if(curr.left!=null)
	    		{
	    		if(curr.left.title.equalsIgnoreCase(key))
	    		{
	    			curr.left=ptr.right;
	    		}
	    		}
	    		else
	    			curr.right=ptr.right;
	    		break;
	    		}
	    		else
	    			curr.right=ptr.right;
	    		flag=1;

	               break;
	    	}
	    	else if(ptr.left!=null&&ptr.right!=null)
	    	{
	    		node p=new node();
	    		p=ptr.left;
	    		curr=ptr;
	    		while(p.right!=null)
	    		{
	    			curr=p;
	    			p=p.right;
	    		}
	    		ptr.title=String.valueOf(p.title);
	    		ptr.mean=String.valueOf(p.mean);
	    		if(curr!=ptr)
	    		curr.right=p.left;
	    		if(curr==ptr)
	    	    curr.left=p.left;
	    		p.left=null;
	    		p.right=null;
	    		flag=1;

	               break;
	    		
	    	}
	    }

	    if((key.compareToIgnoreCase(ptr.title))>0)

	    {
                   curr=ptr;
	               ptr=ptr.right;

	    }

	    else if((key.compareToIgnoreCase(ptr.title))<0)

	    {
                   curr=ptr;
	               ptr=ptr.left;

	    }

	   

	              

	

	if(flag==0)

	    System.out.println("\n No such Word found to be Deleted!");


}


}
public class dictonary {

	public static void main(String[] args) {
		int n1,n2;
		Scanner sc=new Scanner(System.in);
		Tree t=new Tree();
		do
		{
			System.out.println("\n1.Create a dictonary \n2.Add new Word \n3.Delete a word \n4.Update a word \n5.Search a word \n Choose:");
			n1=sc.nextInt();
			switch(n1)
			{
			case 1:t.create();
			t.display(t.root);
		    break;
			case 2:t.add();
			t.display(t.root);
			break;
			case 3:t.delete();
			t.display(t.root);
			break;
			case 4:t.update();
			t.display(t.root);
			break;
			case 5:t.search();
			break;
			}
			System.out.println("\n Enter 1 to continue:");
			n2=sc.nextInt();
		}while(n2==1);
	}

}
/*
1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
1

 Enter the word:
owl

 Enter the meaning:
bird

 Enter 1 to add new node
1

 Enter the word:
cat

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
ape

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
dog

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
fish

 Enter the meaning:
swimmer

 Enter 1 to add new node
1

 Enter the word:
tiger

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
rhino

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
zebra

 Enter the meaning:
animal

 Enter 1 to add new node
1

 Enter the word:
parrot

 Enter the meaning:
animal

 Enter 1 to add new node
0

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:dog
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:owl
 Meaning:bird

 Word:parrot
 Meaning:animal

 Word:rhino
 Meaning:animal

 Word:tiger
 Meaning:animal

 Word:zebra
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
3

 Enter the word whose meaning you want to see
dog

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:owl
 Meaning:bird

 Word:parrot
 Meaning:animal

 Word:rhino
 Meaning:animal

 Word:tiger
 Meaning:animal

 Word:zebra
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
3

 Enter the word whose meaning you want to see
rhino

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:owl
 Meaning:bird

 Word:parrot
 Meaning:animal

 Word:tiger
 Meaning:animal

 Word:zebra
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
3

 Enter the word whose meaning you want to see
zebra

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:owl
 Meaning:bird

 Word:parrot
 Meaning:animal

 Word:tiger
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
3

 Enter the word whose meaning you want to see
owl

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:parrot
 Meaning:animal

 Word:tiger
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
2

 Enter the word:
Racoon

 Enter the meaning:
animal

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:swimmer

 Word:parrot
 Meaning:animal

 Word:Racoon
 Meaning:animal

 Word:tiger
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
4

 Enter the word whose meaning you want to see
fish

 Word found!:

 Enter the Updated Meaning:
animal

 Word:ape
 Meaning:animal

 Word:cat
 Meaning:animal

 Word:fish
 Meaning:animal

 Word:parrot
 Meaning:animal

 Word:Racoon
 Meaning:animal

 Word:tiger
 Meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
5

 Enter the word whose meaning you want to see
dog

 Word not found!

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
5

 Enter the word whose meaning you want to see
cat

 The word cat has meaning:animal

 Enter 1 to continue:
1

1.Create a dictonary 
2.Add new Word 
3.Delete a word 
4.Update a word 
5.Search a word 
 Choose:
*/

