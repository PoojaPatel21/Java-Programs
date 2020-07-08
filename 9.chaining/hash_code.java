/*Title :-
 * Write a program to create a telephone book database of N clients .Make use of
 * a hash table implementation toquickly look up client's telephone number .
 * Roll number :-2956
 */

package chaining;



import java.util.*;
class node
{
long tele;
String name;
long id;
node next;
public node()
{
	tele=0;
	id=0;
	name=null;        //initialize the nodes
	next=null;
}
public node(long t,long  id1,String n1)
{
	id=id1;                           //create the nodes
	tele=t;
	name=n1;
	next=null;
}
}
class hashing
{
	Scanner sc=new Scanner(System.in);
	node start[]=new node[20];
	public hashing()
	{
		for(int i=0;i<10;i++)      // constructor
			start[i]=null;
	}
	int n=0;
	String name;
	int size=0;
	int pos=0;

	node ptr=new node();
	
	public int hash_fun(long id,int size)
	{
		
		return (int) (id%size);         // mod hash function 
	}
	public void accept()
	{
		System.out.print("\n Enter the size of the table:"); //accepting the customer details
		n=sc.nextInt();
		
	}
	public void insert()
	{
		int n1=0;
		int cnt=0;
			System.out.print("\n Enter the customer telephone:");
			long t=sc.nextLong();
			
			do
			{
				long p=t;
				cnt=0;
			while(p>0)
			{
			
				p=p/10;
				cnt++;
			}
			if(cnt!=10)
			{
				System.out.print("\n Re-enter your Telephone number,it should be 10 digit:");
				t=sc.nextLong();
				
			}
			}while(cnt!=10);
			
			System.out.print("\n Enter the customer's name:");
			name=sc.next();
			System.out.print("\n Enter the customer's ID:");
			long id=sc.nextLong();
			
			node temp=new node(t,id,name);
			pos=hash_fun(id,n);
			ptr=start[pos];
			while(ptr!=null)
			{
				if(ptr.id==id)
				{
					System.out.print("\n This Id already exists,please Re-Enter:");
					id=sc.nextLong();
					ptr.id=id;
					pos=hash_fun(id,n);
					ptr=null;
					break;
				}
				ptr=ptr.next;
			}
		
			ptr=start[pos];
			if(start[pos]==null)
			{
				start[pos]=temp;   
			}
			else
			{
			temp.next=start[pos];
			start[pos]=temp;
			
			}
		
		}
		
	
	public void display() //displaying the customer details
	{
	
	for(int i=0;i<n;i++)
	{
		System.out.print("\n\nBlock No."+i);
		ptr=start[i];
	while(ptr!=null)
	{
		System.out.print("\t(ID:"+ptr.id+",Telephone:"+ptr.tele+")");
		ptr=ptr.next;
	}

	
	}
	}
public void search()   //searching for a customer by her/his Id
{
	int flag=0;
	System.out.print("\n Enter the customer Id whose data you want to search for:");
    long k=sc.nextLong();
	for(int i=0;i<n;i++)
	{
		ptr=start[i];
		while(ptr!=null)
		{
			if(ptr.id==k)
			{
				System.out.print("\n Data found:\nName:"+ptr.name+"\nId:"+ptr.id+"\nTelephone:"+ptr.tele+"\n");
				flag=1;
			
				break;
			}
			ptr=ptr.next;
		}
	}
	if(flag==0)
		System.out.print("\n No such customer Id present in this database!");
}
}
public class hash_code {

	
	public static void main(String[] args) 
	{

int n1,n2,n3;

Scanner sc=new Scanner(System.in);
hashing h=new hashing();
h.accept();
do
{
	System.out.print("\n\n1.Create Table\n\n2.Display Table\n\n3.Search a customer by Id\n\n4.Insert new Customer details:\n");
	n1=sc.nextInt();
	
	switch(n1)
	{
	case 1:	
		do
			{
		
			h.insert();
		
			System.out.print("\n Enter 1 to add another customer details:");
			n3=sc.nextInt();
			}while(n3==1);
		break;
	case 2:h.display();
		break;
	case 3:h.search();
		break;
	case 4:h.insert();
	}
	System.out.print("\n Enter 1 to continue:");
	n2=sc.nextInt();
	
}while(n2==1);
		
	}

}

/*OUTPUT:-
 * 
 Enter the size of the table:10


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
1

 Enter the customer telephone:99988776622

 Re-enter your Telephone number,it should be 10 digit:1199229911

 Enter the customer's name:Priya

 Enter the customer's ID:1234

 Enter 1 to add another customer details:1

 Enter the customer telephone:2233448811

 Enter the customer's name:Jiya

 Enter the customer's ID:8765

 Enter 1 to add another customer details:1

 Enter the customer telephone:9988117723

 Enter the customer's name:Ganesh

 Enter the customer's ID:7763

 Enter 1 to add another customer details:1

 Enter the customer telephone:8800728283

 Enter the customer's name:Pritila

 Enter the customer's ID:7782

 Enter 1 to add another customer details:1

 Enter the customer telephone:5522839499

 Enter the customer's name:Haridnya

 Enter the customer's ID:6674

 Enter 1 to add another customer details:1

 Enter the customer telephone:8809223716

 Enter the customer's name:Jay

 Enter the customer's ID:6682

 Enter 1 to add another customer details:1

 Enter the customer telephone:9902334287

 Enter the customer's name:Tiya

 Enter the customer's ID:9935

 Enter 1 to add another customer details:1

 Enter the customer telephone:8805927255

 Enter the customer's name:Muksh

 Enter the customer's ID:9984

 Enter 1 to add another customer details:0

 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
2


Block No.0

Block No.1

Block No.2	(ID:6682,Telephone:8809223716)	(ID:7782,Telephone:8800728283)

Block No.3	(ID:7763,Telephone:9988117723)

Block No.4	(ID:9984,Telephone:8805927255)	(ID:6674,Telephone:5522839499)	(ID:1234,Telephone:1199229911)

Block No.5	(ID:9935,Telephone:9902334287)	(ID:8765,Telephone:2233448811)

Block No.6

Block No.7

Block No.8

Block No.9
 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
3

 Enter the customer Id whose data you want to search for:9982

 No such customer Id present in this database!
 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
3

 Enter the customer Id whose data you want to search for:9984

 Data found:
Name:Muksh
Id:9984
Telephone:8805927255

 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
3

 Enter the customer Id whose data you want to search for:7782

 Data found:
Name:Pritila
Id:7782
Telephone:8800728283

 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
4

 Enter the customer telephone:77883492207

 Re-enter your Telephone number,it should be 10 digit:8800938273

 Enter the customer's name:Dinero

 Enter the customer's ID:7709

 Enter 1 to continue:1


1.Create Table

2.Display Table

3.Search a customer by Id

4.Insert new Customer details:
2


Block No.0

Block No.1

Block No.2	(ID:6682,Telephone:8809223716)	(ID:7782,Telephone:8800728283)

Block No.3	(ID:7763,Telephone:9988117723)

Block No.4	(ID:9984,Telephone:8805927255)	(ID:6674,Telephone:5522839499)	(ID:1234,Telephone:1199229911)

Block No.5	(ID:9935,Telephone:9902334287)	(ID:8765,Telephone:2233448811)

Block No.6

Block No.7

Block No.8

Block No.9	(ID:7709,Telephone:8800938273)
 Enter 1 to continue:0

 */
