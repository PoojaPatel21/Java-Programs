

/*Title :- Use sequential file tomaintain student information .Write algorithms to add ,
 * delete and search student information from the file .
 * Roll number :-2956
 */

package file_organization;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;

class Student implements Serializable
{
	int rno;
	String name;
	int marks;
	
	public Student()
	{
		rno=0;
		name=null;
		marks=0;
	}
	public Student(int r,String n,int m)
	{
		rno=r;
		name=n;
		marks=m;
	}
	public String toString()
	{
		return "Student{"+"id="+rno+"name="+name+"marks="+marks+" ";
	}
	public void display()
	{
		if(!name.equals(null)&&rno!=0)
		{
			System.out.print("\n The Student Details are:");
			System.out.print("\n Roll Number:"+rno+"\n Name:"+name+"\n Marks:"+marks+"\n");
		
	}
	}
	}

public class filorg {
	//@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		
		Student s=new Student();
		Vector <Student> v=new Vector<Student>();
		Scanner sc=new Scanner(System.in);
		int k;
		int n2;
		do
		{
			System.out.print("\n1.Write to File \n2.Read File\n2.Search a Record in the file\n4.Delete a Record(Logically)\n5.Delete a Record(Physically)\n6.Add a new Record:");
			
	k=sc.nextInt();
	File f=new File("p1.txt");
	switch(k)
	{
	case 1:
	case 6:
		int n1=0;

		do
		{
			
			System.out.print("\n Accepting Student Details:");
			System.out.print("\n Enter the Student Roll Number:");
			int r=sc.nextInt();
			System.out.print("\n Enter the Student Name:");
			String n=sc.next();
			System.out.print("\n Enter Students Marks:");
			int m=sc.nextInt();
			s=new Student(r,n,m);
			v.add(s);
			System.out.print("\n Enter 1 to add new Students Details:");
			n1=sc.nextInt();
		
		
		}while(n1==1);
	
		try
		{
			FileOutputStream file=new FileOutputStream(f);
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(v);
			out.close();
			file.close();
			System.out.print("\n Data Write Successfully");
		}catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	break;
	case 2:
		try
		{
			FileInputStream fin=new FileInputStream(f);
			ObjectInputStream in=new ObjectInputStream(fin);
	          v=(Vector<Student>)in.readObject();
			
			Iterator <Student> itr=v.iterator();
			while(itr.hasNext())
			{
			Student	s1=itr.next();
			if(s1.name!=null)
			s1.display();
			}
			in.close();
			fin.close();
			System.out.print("\n Data Read Successfully");
		}catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
	} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		break;
	case 3:
		try
		{
			FileInputStream file=new FileInputStream(f);
			ObjectInputStream in=new ObjectInputStream(file);
	
			System.out.print("\n Enter the Student Roll Number whose record you want to see:");
			int rno=sc.nextInt();
                v=(Vector<Student>)in.readObject();
			int flag=0;
			Iterator <Student> itr=v.iterator();
			while(itr.hasNext())
			{
				
			Student	s1=itr.next();
			if(rno==s1.rno)
			{
				System.out.print("\n Data of this student found:");
				flag=1;
				s1.display();
				break;
			}
			
			}
			if(flag==0)
				System.out.print("\n NO SUCH STUDENT FOUND!");

		}catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
	} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		break;
	case 4: 
		
		try
	{
   	 System.out.print("\n Enter the roll number of the student whose record you want to delete:");
        int r=sc.nextInt();
		FileInputStream file=new FileInputStream(f);
		ObjectInputStream in=new ObjectInputStream(file);

		
           v=(Vector<Student>)in.readObject();
           int flag=0;
			Iterator <Student> itr=v.iterator();
			while(itr.hasNext())
			{
				Student s1=itr.next();
				if(s1.rno==r)
				{
					flag=1;
					s.rno=0;
					s.name=null;
					s.marks=0;
			
					}
				else
					s1.display();
				
			}
			if(flag==0)
				System.out.print("\n No such Student found!");
			else
			{
				FileOutputStream file1=new FileOutputStream(f);
				ObjectOutputStream out=new ObjectOutputStream(file1);
				out.writeObject(v);
				out.close();
				file.close();
			}
			}catch(FileNotFoundException fnf)
	{
				fnf.printStackTrace();
				
			}catch(IOException ex)
			{
				ex.printStackTrace();
		} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		
		break;
	case 5:
	//	File temp=new File("temp.txt");

		File f1=new File("p1.txt");
       
        try
		{
        	System.out.print("\n Enter the roll number of the student whose record you want to delete:");
             int r=sc.nextInt();
			FileInputStream file=new FileInputStream(f);
			ObjectInputStream in=new ObjectInputStream(file);
	
			
                v=(Vector<Student>)in.readObject();
                Vector<Student> v1=new Vector();
			int flag=0;
			Iterator <Student> itr=v.iterator();
			while(itr.hasNext())
			{
				
			Student	s1=itr.next();
			if(r==s1.rno)
			{
				System.out.print("\n Data of this student is getting deleted:");
				flag=1;
				s1.display();
				
			}
			else
				v1.add(s1);
			}
			if(flag==0)
			{
				System.out.println("\n No such file found to be deleted");
			}
			else
			{
				try
			{
					f.delete();
				FileOutputStream file1=new FileOutputStream(f1);
				ObjectOutputStream out=new ObjectOutputStream(file1);
				out.writeObject(v1);
				
				out.close();
				file.close();
			}catch(FileNotFoundException fnf)
			{
				fnf.printStackTrace();
				
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
			
				
			}
		

		}catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
	} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        System.out.print("\n After Deletion:");
        try
		{
			FileInputStream fin1=new FileInputStream(f1);
			ObjectInputStream in1=new ObjectInputStream(fin1);
	          Vector<Student> v1=(Vector<Student>)in1.readObject();
			f1.renameTo(f);
			Iterator <Student> itr=v1.iterator();
			while(itr.hasNext())
			{
			Student	s1=itr.next();
			s1.display();
			}
			in1.close();
			fin1.close();

		}catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
	} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	System.out.print("\n Enter 1 to contiune:");
	n2=sc.nextInt();
		
		}while(n2==1);
	}

}
/* OYTPUT :-
1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:1

 Accepting Student Details:
 Enter the Student Roll Number:1

 Enter the Student Name:Lana

 Enter Students Marks:95

 Enter 1 to add new Students Details:1

 Accepting Student Details:
 Enter the Student Roll Number:2

 Enter the Student Name:Gwen

 Enter Students Marks:90

 Enter 1 to add new Students Details:1

 Accepting Student Details:
 Enter the Student Roll Number:3

 Enter the Student Name:Noah

 Enter Students Marks:75

 Enter 1 to add new Students Details:1

 Accepting Student Details:
 Enter the Student Roll Number:4

 Enter the Student Name:JOsh

 Enter Students Marks:92

 Enter 1 to add new Students Details:0

 Data Write Successfully
 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:2

 The Student Details are:
 Roll Number:1
 Name:Lana
 Marks:95

 The Student Details are:
 Roll Number:2
 Name:Gwen
 Marks:90

 The Student Details are:
 Roll Number:3
 Name:Noah
 Marks:75

 The Student Details are:
 Roll Number:4
 Name:JOsh
 Marks:92

 Data Read Successfully
 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:3

 Enter the Student Roll Number whose record you want to see:2

 Data of this student found:
 The Student Details are:
 Roll Number:2
 Name:Gwen
 Marks:90

 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:4

 Enter the roll number of the student whose record you want to delete:2

 The Student Details are:
 Roll Number:1
 Name:Lana
 Marks:95

 The Student Details are:
 Roll Number:3
 Name:Noah
 Marks:75

 The Student Details are:
 Roll Number:4
 Name:JOsh
 Marks:92

 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:5

 Enter the roll number of the student whose record you want to delete:2

 Data of this student is getting deleted:
 The Student Details are:
 Roll Number:2
 Name:Gwen
 Marks:90

 After Deletion:
 The Student Details are:
 Roll Number:1
 Name:Lana
 Marks:95

 The Student Details are:
 Roll Number:3
 Name:Noah
 Marks:75

 The Student Details are:
 Roll Number:4
 Name:JOsh
 Marks:92

 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:2

 The Student Details are:
 Roll Number:1
 Name:Lana
 Marks:95

 The Student Details are:
 Roll Number:3
 Name:Noah
 Marks:75

 The Student Details are:
 Roll Number:4
 Name:JOsh
 Marks:92

 Data Read Successfully
 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:6

 Accepting Student Details:
 Enter the Student Roll Number:5

 Enter the Student Name:Moji

 Enter Students Marks:98

 Enter 1 to add new Students Details:0

 Data Write Successfully
 Enter 1 to contiune:1

1.Write to File 
2.Read File
2.Search a Record in the file
4.Delete a Record(Logically)
5.Delete a Record(Physically)
6.Add a new Record:2

 The Student Details are:
 Roll Number:1
 Name:Lana
 Marks:95

 The Student Details are:
 Roll Number:3
 Name:Noah
 Marks:75

 The Student Details are:
 Roll Number:4
 Name:JOsh
 Marks:92

 The Student Details are:
 Roll Number:5
 Name:Moji
 Marks:98

 Data Read Successfully
 Enter 1 to contiune:0
*/
