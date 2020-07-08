
//TITLE :Mini -Project 
//ROLL NUMBER :2956
//RAILWAY TRACK SCHEDULING SYSTEM

import java.util.*;

class node {
	int flag_onTime;
	long id; // train ID
	node next;
	float dept_time; // departure time
	float arr_time;// arrival time

	public node() // default constructor
	{
		flag_onTime = 0;
		id = 0;
		dept_time = 0;
		arr_time = 0;
		next = null;
	}

	public node(long id1, float dtime1, float atime1) // parameterized constructor
	{
		id = id1;
		dept_time = dtime1;
		arr_time = atime1;
		next = null;

	}

	public void display() {
		System.out.println("\nTrain ID: " + id);
		System.out.println("\nArrival time: " + arr_time);
		System.out.println("\nDeparture time: " + dept_time);
		if (flag_onTime == 0)
			System.out.println("\nStatus: On-time");
		else
			System.out.println("\nStatus: Delayed");
	}

}

class Schedule {
	Scanner sc = new Scanner(System.in);

	int n = 0; // number of tracks
	long id = 0; // to store the train ID
	node temp = new node();
	float dept_time;
	float arr_time;
	int key; // stores the value of index where the Railway id is

	node ptr = new node();
	node hash_arr[] = new node[20]; // hash table
	int graph[][] = new int[20][20]; // adjacency matrix

	ArrayList<Long> al = new ArrayList<Long>(); // used in case of

	public int hash_funct(long id, int n) // function to store

	{
		return (int) (id % n);
	}

	public void accept() {
		System.out.print("\n Enter the number of railway tracks : ");
		n = sc.nextInt();
		create_graph();
	}

	public void create_graph()//for the connected railway tracks
    {
        int temp;
        for(int i=0;i<n;i++)
        {
            System.out.println();
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    System.out.print("\nIs the route available from track "+(i+1)+" to track "+(j+1)+" ? \nEnter 1 if Yes 0 for no : ");
                    temp=sc.nextInt();
                    if(temp==1)
                    {
                        graph[i][j]=temp;
                    }
                    else
                    {
                        graph[i][j]=0;
                    }
                }

            }

        }

    }

	public void insert()   //apply do while in case 1 and accept the trains for whole 24h schedule
    {
        System.out.print("\nEnter the Train Id : ");
        id=sc.nextLong();

        Boolean b1=al.contains(id);
        while(b1)
        {
            System.out.print("\nInvalid train ID. The train has already been scheduled. Please re-enter ID : ");
            id=sc.nextLong();
            b1=al.contains(id);
        }
           al.add(id);

        System.out.print("\nEnter the Arrival Time : ");
        arr_time=sc.nextFloat();
        System.out.print("\nEnter the Departure Time : ");
        dept_time=sc.nextFloat();

        while(dept_time<=arr_time)
        {
            System.out.print("\n The train cannot leave before arriving,RE-ENTER : ");
            dept_time=sc.nextFloat();
        }

        node temp=new node(id,dept_time,arr_time);
        key=hash_funct(id,n);

        if(hash_arr[key]==null)
        {
            hash_arr[key]=temp;
            System.out.print("\nTrain alloted to Platform : "+(key+1));
        }
        else
        {
            int flag=0;
            ptr=hash_arr[key];

            if(ptr.dept_time<=temp.arr_time) //the current trains arrival time must be greater than the departure of train  atthe platform
            {
                temp.next=ptr;
                hash_arr[key]=temp;
                System.out.print("\nTrain Alloted to Platform: "+(key+1));
            }
            if(ptr.dept_time>temp.arr_time)
            {
                for(int i=0;i<n;i++)        //see by graph,which is the available track
                {
                    if(graph[key][i]==1)
                    {
                        ptr=hash_arr[i];
                        if(ptr==null)
                        {
                            hash_arr[i]=temp;
                            System.out.print("\nTrain Alloted to Platform : "+(i+1));
                            flag=1;
                            break;
                        }

                        else  if(ptr.dept_time<temp.arr_time)
                        {
                            temp.next=ptr;
                            hash_arr[i]=temp;
                            flag=1;
                            System.out.print("\nTrain Alloted to Platform : "+(i+1));
                            break;
                        }

                    }
                }

                if(flag==0)
                {
                    //temp.flag_onTime=1;
                    stop(temp,key);
                }
            }

        }

    }

	public void stop(node temp, int key) // case of failure
	{
		System.out.println("\n The Train No " + id + " has to be Rescheduled !");
		reScheduling(temp, key);
	}

	public void display()
    {
        node temp;
        for(int i=0;i<n;i++)
        {
            temp=hash_arr[i];
            if(temp!=null)
            {
                System.out.println("\n\nAt Platform "+ (i+1) +" : \n");
                System.out.println("\nID  \tArrTime \tDepTime \tStatus");
                String status;

                while(temp!=null)
                {
                    if(temp.flag_onTime==0)
                    {
                        status="OnTime";
                    }
                    else
                    {
                        status="Delayed";
                    }
                    System.out.println(temp.id+" \t\t"+temp.arr_time+" \t\t"+temp.dept_time+"\t\t"+status);
                    temp=temp.next;
                }
            }

        }
    }

	public void reScheduling(node temp, int key)
    {
        int i,u=0,flag=0;
        float min=999;
        for(i=0;i<n;i++)
        {
            if(graph[key][i]==1)
            {
                if(min>hash_arr[i].dept_time)
                {
                    min=hash_arr[i].dept_time;
                    u=i;
                    flag=1;
                }

            }
        }

        if(flag==0)
        {

            float k=temp.dept_time-temp.arr_time;
            temp.arr_time=hash_arr[key].dept_time;

            temp.dept_time=k+temp.arr_time;
            u=key;
            min = temp.arr_time;
            temp.next=hash_arr[u];
            hash_arr[u]=temp;
            temp.flag_onTime=1;
        }
        else
        {
            float k=temp.dept_time-temp.arr_time;
            temp.arr_time=min;
            temp.dept_time=min+k;

            temp.next=hash_arr[u];
            hash_arr[u]=temp;
            temp.flag_onTime=1;
        }

        System.out.print("\nTrain Alloted to Platform : "+(u+1)+" at time "+min);
    }

	public void search()
    {
        System.out.println("\nEnter the train ID whose details you want to look for: ");
        int key = sc.nextInt();
        int pos=hash_funct(key,n);

        int flag=0;
        node ptr=hash_arr[pos];

        while(ptr!=null)
        {
            if(ptr.id==key)
            {
                System.out.println("\nTrain details are as follows: ");
                System.out.println("\nPlatform no. alloted: "+(pos+1));
                ptr.display();

                flag=1;
                break;
            }
            ptr=ptr.next;
        }

        if(flag==0)
        {
            int i;
            for(i=0;i<n;i++)
            {
                if(graph[pos][i]==1)
                {
                    ptr=hash_arr[i];

                    while(ptr!=null)
                    {
                        if(ptr.id==key)
                        {
                            System.out.println("\nTrain details are as follows: ");
                            System.out.println("\nPlatform no. alloted: "+(i+1));
                            ptr.display();

                            flag=1;
                            break;
                        }
                        ptr=ptr.next;
                    }
                }
                if(flag==1)
                    break;
            }

            if(flag==0)
                System.out.println("\nInvalid Train ID. ");
        }
    }

} // end class

public class mini_project {
	public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Schedule s=new Schedule();
        int n1;
        do
        {
            System.out.print("\n1.Track Details \n2.Schedule Trains \n3.Display Train Schedule \n4.Search train details\n5.Exit\nEnter Choice : ");
            n1=sc.nextInt();
            switch(n1)
            {
                case 1 :
                    s.accept();
                    break;

                case 2 :
                    int ch;
                    do
                    {
                        s.insert();
                        System.out.print("\nWant to schedule more Trains ? Press 1 for yes 0 for no: ");
                        ch=sc.nextInt();
                    }
                    while(ch==1);
                    break;

                case 3 :
                    s.display();
                    break;

                case 4: s.search();
                    break;
            }

        }while(n1<=5);


    }
}

/*
 * OUTPUT:
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 1
 * 
 * Enter the number of railway tracks: 5
 * 
 * 
 * Is the route available from track 1 to track 2 ? Enter 1 if Yes 0 for no: 1
 * 
 * Is the route available from track 1 to track 3 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 1 to track 4 ? Enter 1 if Yes 0 for no: 1
 * 
 * Is the route available from track 1 to track 5 ? Enter 1 if Yes 0 for no: 0
 * 
 * 
 * Is the route available from track 2 to track 1 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 2 to track 3 ? Enter 1 if Yes 0 for no: 1
 * 
 * Is the route available from track 2 to track 4 ? Enter 1 if Yes 0 for no: 1
 * 
 * Is the route available from track 2 to track 5 ? Enter 1 if Yes 0 for no: 0
 * 
 * 
 * Is the route available from track 3 to track 1 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 3 to track 2 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 3 to track 4 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 3 to track 5 ? Enter 1 if Yes 0 for no: 1
 * 
 * 
 * Is the route available from track 4 to track 1 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 4 to track 2 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 4 to track 3 ? Enter 1 if Yes 0 for no: 1
 * 
 * Is the route available from track 4 to track 5 ? Enter 1 if Yes 0 for no: 0
 * 
 * 
 * Is the route available from track 5 to track 1 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 5 to track 2 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 5 to track 3 ? Enter 1 if Yes 0 for no: 0
 * 
 * Is the route available from track 5 to track 4 ? Enter 1 if Yes 0 for no: 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 2
 * 
 * Enter the Train Id : 19
 * 
 * Enter the Arrival Time : 2.15
 * 
 * Enter the Departure Time : 2.45
 * 
 * Train alloted to Platform : 5 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 29
 * 
 * Enter the Arrival Time : 2.40
 * 
 * Enter the Departure Time : 2.55
 * 
 * The Train No 29 has to be Rescheduled !
 * 
 * Train Alloted to Platform : 5 at time 2.45 Want to schedule more Trains ?
 * Press 1 for yes 0 for no: 1
 * 
 * Enter the Train Id : 39
 * 
 * Enter the Arrival Time : 2.55
 * 
 * Enter the Departure Time : 3.05
 * 
 * The Train No 39 has to be Rescheduled !
 * 
 * Train Alloted to Platform : 5 at time 2.6 Want to schedule more Trains ?
 * Press 1 for yes 0 for no: 1
 * 
 * Enter the Train Id : 7
 * 
 * Enter the Arrival Time : 3.10
 * 
 * Enter the Departure Time : 3.25
 * 
 * Train alloted to Platform : 3 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 17
 * 
 * Enter the Arrival Time : 3.20
 * 
 * Enter the Departure Time : 3.30
 * 
 * Train Alloted to Platform : 5 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 37
 * 
 * Enter the Arrival Time : 3.20
 * 
 * Enter the Departure Time : 3.29
 * 
 * The Train No 37 has to be Rescheduled !
 * 
 * Train Alloted to Platform : 5 at time 3.3 Want to schedule more Trains ?
 * Press 1 for yes 0 for no: 1
 * 
 * Enter the Train Id : 33
 * 
 * Enter the Arrival Time : 3.40
 * 
 * Enter the Departure Time : 3.50
 * 
 * Train alloted to Platform : 4 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 45
 * 
 * Enter the Arrival Time : 4.01
 * 
 * Enter the Departure Time : 4.13
 * 
 * Train alloted to Platform : 1 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 3
 * 
 * 
 * At Platform 1 :
 * 
 * 
 * ID ArrTime DepTime Status 45 4.01 4.13 OnTime
 * 
 * 
 * At Platform 3 :
 * 
 * 
 * ID ArrTime DepTime Status 7 3.1 3.25 OnTime
 * 
 * 
 * At Platform 4 :
 * 
 * 
 * ID ArrTime DepTime Status 33 3.4 3.5 OnTime
 * 
 * 
 * At Platform 5 :
 * 
 * 
 * ID ArrTime DepTime Status 37 3.3 3.398 Delayed 17 3.2 3.3 OnTime 39 2.6 3.1
 * Delayed 29 2.45 2.6 Delayed 19 2.15 2.45 OnTime
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 39
 * 
 * Train details are as follows:
 * 
 * Platform no. alloted: 5
 * 
 * Train ID: 39
 * 
 * Arrival time: 2.6
 * 
 * Departure time: 3.1
 * 
 * Status: Delayed
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 17
 * 
 * Train details are as follows:
 * 
 * Platform no. alloted: 5
 * 
 * Train ID: 17
 * 
 * Arrival time: 3.2
 * 
 * Departure time: 3.3
 * 
 * Status: On-time
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 56
 * 
 * Invalid Train ID.
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 2
 * 
 * Enter the Train Id : 35
 * 
 * Enter the Arrival Time : 4.15
 * 
 * Enter the Departure Time : 4.25
 * 
 * Train Alloted to Platform: 1 Want to schedule more Trains ? Press 1 for yes 0
 * for no: 1
 * 
 * Enter the Train Id : 45
 * 
 * Invalid train ID. The train has already been scheduled. Please re-enter ID:
 * 55
 * 
 * Enter the Arrival Time : 4.15
 * 
 * Enter the Departure Time : 4.33
 * 
 * Train Alloted to Platform : 2 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 65
 * 
 * Enter the Arrival Time : 4.15
 * 
 * Enter the Departure Time : 4.36
 * 
 * Train Alloted to Platform : 4 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 75
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 2
 * 
 * Enter the Train Id : 75
 * 
 * Enter the Arrival Time : 4.15
 * 
 * Enter the Departure Time : 4.31
 * 
 * The Train No 75 has to be Rescheduled !
 * 
 * Train Alloted to Platform : 2 at time 4.33 Want to schedule more Trains ?
 * Press 1 for yes 0 for no: 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 3
 * 
 * 
 * At Platform 1 :
 * 
 * 
 * ID ArrTime DepTime Status 35 4.15 4.25 OnTime 45 4.01 4.13 OnTime
 * 
 * 
 * At Platform 2 :
 * 
 * 
 * ID ArrTime DepTime Status 75 4.33 4.49 Delayed 55 4.15 4.33 OnTime
 * 
 * 
 * At Platform 3 :
 * 
 * 
 * ID ArrTime DepTime Status 7 3.1 3.25 OnTime
 * 
 * 
 * At Platform 4 :
 * 
 * 
 * ID ArrTime DepTime Status 65 4.15 4.36 OnTime 33 3.4 3.5 OnTime
 * 
 * 
 * At Platform 5 :
 * 
 * 
 * ID ArrTime DepTime Status 37 3.3 3.39 Delayed 17 3.2 3.3 OnTime 39 2.6 3.1
 * Delayed 29 2.45 2.6 Delayed 19 2.15 2.45 OnTime
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 75
 * 
 * Train details are as follows:
 * 
 * Platform no. alloted: 2
 * 
 * Train ID: 75
 * 
 * Arrival time: 4.33
 * 
 * Departure time: 4.49
 * 
 * Status: Delayed
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 99.Exit Enter Choice : 99
 * 
 * Process finished with exit code 0
 *** 
 * ______-----------------------------------------------------------------------
 * -------------------------------_____***
 *
 *
 *
 *
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 1
 * 
 * Enter the number of railway tracks : 5
 * 
 * 
 * Is the route available from track 1 to track 2 ? Enter 1 if Yes 0 for no : 1
 * 
 * Is the route available from track 1 to track 3 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 1 to track 4 ? Enter 1 if Yes 0 for no : 1
 * 
 * Is the route available from track 1 to track 5 ? Enter 1 if Yes 0 for no : 0
 * 
 * 
 * Is the route available from track 2 to track 1 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 2 to track 3 ? Enter 1 if Yes 0 for no : 1
 * 
 * Is the route available from track 2 to track 4 ? Enter 1 if Yes 0 for no : 1
 * 
 * Is the route available from track 2 to track 5 ? Enter 1 if Yes 0 for no : 0
 * 
 * 
 * Is the route available from track 3 to track 1 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 3 to track 2 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 3 to track 4 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 3 to track 5 ? Enter 1 if Yes 0 for no : 1
 * 
 * 
 * Is the route available from track 4 to track 1 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 4 to track 2 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 4 to track 3 ? Enter 1 if Yes 0 for no : 1
 * 
 * Is the route available from track 4 to track 5 ? Enter 1 if Yes 0 for no : 0
 * 
 * 
 * Is the route available from track 5 to track 1 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 5 to track 2 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 5 to track 3 ? Enter 1 if Yes 0 for no : 0
 * 
 * Is the route available from track 5 to track 4 ? Enter 1 if Yes 0 for no : 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 2
 * 
 * Enter the Train Id : 29
 * 
 * Enter the Arrival Time : 2.15
 * 
 * Enter the Departure Time : 2.35
 * 
 * Train alloted to Platform : 5 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 39
 * 
 * Enter the Arrival Time : 2.15
 * 
 * Enter the Departure Time : 2.42
 * 
 * The Train No 39 has to be Rescheduled !
 * 
 * Train Alloted to Platform : 5 at time 2.35 Want to schedule more Trains ?
 * Press 1 for yes 0 for no: 1
 * 
 * Enter the Train Id : 17
 * 
 * Enter the Arrival Time : 3.02
 * 
 * Enter the Departure Time : 3.15
 * 
 * Train alloted to Platform : 3 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 20
 * 
 * Enter the Arrival Time : 4.03
 * 
 * Enter the Departure Time : 4.13
 * 
 * Train alloted to Platform : 1 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 52
 * 
 * Enter the Arrival Time : 5.07
 * 
 * Enter the Departure Time : 5.35
 * 
 * Train Alloted to Platform: 3 Want to schedule more Trains ? Press 1 for yes 0
 * for no: 1
 * 
 * Enter the Train Id : 42
 * 
 * Enter the Arrival Time : 5.15
 * 
 * Enter the Departure Time : 5.25
 * 
 * Train Alloted to Platform : 5 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 71
 * 
 * Enter the Arrival Time : 6.15
 * 
 * Enter the Departure Time : 6.25
 * 
 * Train alloted to Platform : 2 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 76
 * 
 * Enter the Arrival Time : 6.17
 * 
 * Enter the Departure Time : 6.25
 * 
 * Train Alloted to Platform : 3 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 1
 * 
 * Enter the Train Id : 76
 * 
 * Invalid train ID. The train has already been scheduled. Please re-enter ID :
 * 80
 * 
 * Enter the Arrival Time : 6.35
 * 
 * Enter the Departure Time : 6.45
 * 
 * Train Alloted to Platform: 1 Want to schedule more Trains ? Press 1 for yes 0
 * for no: 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 3
 * 
 * 
 * At Platform 1 :
 * 
 * 
 * ID ArrTime DepTime Status 80 6.35 6.45 OnTime 20 4.03 4.13 OnTime
 * 
 * 
 * At Platform 2 :
 * 
 * 
 * ID ArrTime DepTime Status 71 6.15 6.25 OnTime
 * 
 * 
 * At Platform 3 :
 * 
 * 
 * ID ArrTime DepTime Status 76 6.17 6.25 OnTime 52 5.07 5.35 OnTime 17 3.02
 * 3.15 OnTime
 * 
 * 
 * At Platform 5 :
 * 
 * 
 * ID ArrTime DepTime Status 42 5.15 5.25 OnTime 39 2.35 2.62 Delayed 29 2.15
 * 2.35 OnTime
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 52
 * 
 * Train details are as follows:
 * 
 * Platform no. alloted: 3
 * 
 * Train ID: 52
 * 
 * Arrival time: 5.07
 * 
 * Departure time: 5.35
 * 
 * Status: On-time
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 39
 * 
 * Train details are as follows:
 * 
 * Platform no. alloted: 5
 * 
 * Train ID: 39
 * 
 * Arrival time: 2.35
 * 
 * Departure time: 2.62
 * 
 * Status: Delayed
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 4
 * 
 * Enter the train ID whose details you want to look for: 99
 * 
 * Invalid Train ID.
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 2
 * 
 * Enter the Train Id : 23
 * 
 * Enter the Arrival Time : 7.15
 * 
 * Enter the Departure Time : 7.45
 * 
 * Train alloted to Platform : 4 Want to schedule more Trains ? Press 1 for yes
 * 0 for no: 0
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice : 3
 * 
 * 
 * At Platform 1 :
 * 
 * 
 * ID ArrTime DepTime Status 80 6.35 6.45 OnTime 20 4.03 4.13 OnTime
 * 
 * 
 * At Platform 2 :
 * 
 * 
 * ID ArrTime DepTime Status 71 6.15 6.25 OnTime
 * 
 * 
 * At Platform 3 :
 * 
 * 
 * ID ArrTime DepTime Status 76 6.17 6.25 OnTime 52 5.07 5.35 OnTime 17 3.02
 * 3.15 OnTime
 * 
 * 
 * At Platform 4 :
 * 
 * 
 * ID ArrTime DepTime Status 23 7.15 7.45 OnTime
 * 
 * 
 * At Platform 5 :
 * 
 * 
 * ID ArrTime DepTime Status 42 5.15 5.25 OnTime 39 2.35 2.62 Delayed 29 2.15
 * 2.35 OnTime
 * 
 * 1.Track Details 2.Schedule Trains 3.Display Train Schedule 4.Search train
 * details 5.Exit Enter Choice :
 */
