/*Title :Implement hash table for storing bank account information handle the collision
 * using linear probing (with or without replacement).Perform operations on it.
 * Roll number:2956
 */

package linear_probing;
import java.util.*;
class node
{
	long acc_num;
	String name;
	long bal;
	public node()
	{
		acc_num=0;
		name=null;
		bal=0;
	}
	public node(long acc_num1,String name1,long bal1)
	{
		acc_num=acc_num1;
		name=name1;
		bal=bal1;
	}
}
class probing
{
	Scanner sc=new Scanner(System.in);
	node hash[]=new node[20];
	public probing()
	{
		for(int i=0;i<20;i++)
			hash[i]=null;
	}
	long acc;
	String name;
	long bal;
	int n;
	long key;
	public int hash_funct(long key)
	{
		return(int)key%n;
	}
	
	public void accept()
	{
		System.out.print("\n Enter the hash table limit:");	
		n=sc.nextInt();
		int n1;
		do
		{
			System.out.print("\n Enter the bank account number:");
			acc=sc.nextLong();
			System.out.print("\n Enter the account holders name:");
			name=sc.next();
			System.out.print("\n Enter the current account balance:");
			bal=sc.nextLong();
			node temp=new node(acc,name,bal);
			int k=insert(temp);
			if(k==1)
				System.out.print("\n Inserted the account holders detail!");
			else
				System.out.print("\n Could not Insert this account holders detail!");
			System.out.print("\n Enter 1 to add another bank account detail:");
			n1=sc.nextInt();
		}while(n1==1);

	}
	public void display()
	{
		System.out.print("\n The bank details are:");
		for(int i=0;i<n;i++)
		{
			if(hash[i]!=null)
			System.out.print("\n"+(i)+"\t Name:"+hash[i].name+"\t Number:"+hash[i].acc_num+"\t Balance:"+hash[i].bal+"\n");
			else
				System.out.print("\nThis position is not occupied\n");
		}
		
	}
	public void search()
	{
		int flag=0;
	
		System.out.print("\n Enter the account number:" );
		key=sc.nextLong();
		int pos=hash_funct(key);
		if(hash[pos]!=null)
		if(hash[pos].acc_num==key)
		{
			System.out.print("\n The details are found!");
			System.out.print("\n Name:"+hash[pos].name+"\n Acc Num:"+hash[pos].acc_num+"\n Balance:"+hash[pos].bal+"\n");
			flag=1;
			
		}
		else
		{
			
			while(hash[pos]!=null&&hash[pos].acc_num!=-1)
			{
				if(hash[pos].acc_num==key)
				{
					System.out.print("\n The details are found!");
				System.out.print("\n Name:"+hash[pos].name+"\n Acc Num:"+hash[pos].acc_num+"\n Balance:"+hash[pos].bal+"\n");
				flag=1;
				break;
				
				}
				pos++;
				pos=pos%n;
			}
			if(flag==0)
				System.out.print("\n No such key found!" );
		}
		else 
			System.out.print("\n Key not found!");
	
}
	
public int insert(node temp)
{
int pos;
pos=hash_funct(temp.acc_num);
if(hash[pos]==null||hash[pos].acc_num==-1)
{
	hash[pos]=temp;
	return 1;
	
}
else
{
	System.out.print("\n Collision at position "+pos);
	for(int i=pos+1;i!=pos;i++)
	{
		i=i%n;
		if(hash[i]==null)
		{
			hash[i]=temp;
			return 1;
		}
		else
		{
			System.out.print("\n Collision at position "+i);
		}
		
	}
	return -1;
}
}
public void delete()
{
	int flag=0;
	System.out.print("\n Enter the account number:");
	key=sc.nextLong();
	int pos=hash_funct(key);
	if(hash[pos]!=null)
	if(hash[pos].acc_num==key)
	{
		hash[pos].acc_num=-1;
		hash[pos].name=null;
		hash[pos].bal=00;
		flag=1;
		System.out.print("\n Successfully Deleted!");
	}
	else
	{

		while(hash[pos]!=null&&hash[pos].acc_num!=-1)
		{
			if(hash[pos].acc_num==key)
			{
				hash[pos].acc_num=-1;
				hash[pos].name=null;
				hash[pos].bal=00;
				flag=1;
				System.out.print("\n Successfully Deleted!");
			break;
			
			}
			pos++;
			pos=pos%n;
		
		}
		
		if(flag==0)
			System.out.print("\n No such key found to be deleted!" );
	}
		else 
			System.out.print("\n No such key found to be deleted!");
	
	

			}
	}



public class liner {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n1,n2;
probing p=new probing();
do
{
	System.out.print("\n1.Accept Details\n2.Display Details\n3.Insert new account\n4.Search account\n5.Delete acount");
	n1=sc.nextInt();
	switch(n1)
	{
	case 1:p.accept();
		break;
	case 2:p.display();
		break;
	case 3:System.out.print("\n Enter bank account number:");
	p.acc=sc.nextLong();
	System.out.print("\n Enter account holders name:");
	p.name=sc.next();
	System.out.print("\n Enter account balance:");
	p.bal=sc.nextLong();
	node temp=new node(p.acc,p.name,p.bal);
	int k=p.insert(temp);
	if(k==1)
		System.out.print("\n The account details are inserted!");
	else
		System.out.print("\n The account details could not be inserted!");
		
		break;
	case 4:p.search();
		break;
	case 5:p.delete();
		break;
	}
	System.out.print("\n Enter 1 to continue:");
	n2=sc.nextInt();
}while(n2==1);

	}

}
/*
1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount1

 Enter the hash table limit:10

 Enter the bank account number:11223344

 Enter the account holders name:Noah

 Enter the current account balance:12000

 Inserted the account holders detail!
 Enter 1 to add another bank account detail:1

 Enter the bank account number:22334455

 Enter the account holders name:Lana

 Enter the current account balance:100000

 Inserted the account holders detail!
 Enter 1 to add another bank account detail:1

 Enter the bank account number:22335544

 Enter the account holders name:Josh

 Enter the current account balance:2000

 Collision at position 4
 Collision at position 5
 Inserted the account holders detail!
 Enter 1 to add another bank account detail:1

 Enter the bank account number:22553366

 Enter the account holders name:Gen

 Enter the current account balance:2000

 Collision at position 6
 Inserted the account holders detail!
 Enter 1 to add another bank account detail:1

 Enter the bank account number:22008899

 Enter the account holders name:Denny

 Enter the current account balance:2340

 Inserted the account holders detail!
 Enter 1 to add another bank account detail:0

 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount2

 The bank details are:
This position is not occupied

This position is not occupied

This position is not occupied

This position is not occupied

4	 Name:Noah	 Number:11223344	 Balance:12000

5	 Name:Lana	 Number:22334455	 Balance:100000

6	 Name:Josh	 Number:22335544	 Balance:2000

7	 Name:Gen	 Number:22553366	 Balance:2000

This position is not occupied

9	 Name:Denny	 Number:22008899	 Balance:2340

 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount3

 Enter bank account number:22335599

 Enter account holders name:Mansi

 Enter account balance:12000

 Collision at position 9
 The account details are inserted!
 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount2

 The bank details are:
0	 Name:Mansi	 Number:22335599	 Balance:12000

This position is not occupied

This position is not occupied

This position is not occupied

4	 Name:Noah	 Number:11223344	 Balance:12000

5	 Name:Lana	 Number:22334455	 Balance:100000

6	 Name:Josh	 Number:22335544	 Balance:2000

7	 Name:Gen	 Number:22553366	 Balance:2000

This position is not occupied

9	 Name:Denny	 Number:22008899	 Balance:2340

 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount4

 Enter the account number:88223388

 Key not found!
 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount4

 Enter the account number:22335599

 The details are found!
 Name:Mansi
 Acc Num:22335599
 Balance:12000

 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount5

 Enter the account number:22553366

 Successfully Deleted!
 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount2

 The bank details are:
0	 Name:Mansi	 Number:22335599	 Balance:12000

This position is not occupied

This position is not occupied

This position is not occupied

4	 Name:Noah	 Number:11223344	 Balance:12000

5	 Name:Lana	 Number:22334455	 Balance:100000

6	 Name:Josh	 Number:22335544	 Balance:2000

7	 Name:null	 Number:-1	 Balance:0

This position is not occupied

9	 Name:Denny	 Number:22008899	 Balance:2340

 Enter 1 to continue:1

1.Accept Details
2.Display Details
3.Insert new account
4.Search account
5.Delete acount5

 Enter the account number:22334411

 No such key found to be deleted!
 Enter 1 to continue:
0
*/

