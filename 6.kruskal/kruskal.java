//Title : (kruskals)Company wants to  lease phone lines to connect its offices to different cities witheach other .
// Company charges different amounts of money to commect different pairs of offices .Solve the probblem by
//suggesting appropriate data structures to connect all offices of a company with a minimum cost 
//ROLL NUMBER :2956

import java.util.*;

class init {

          

    public int weight,source,dest;

  

    public init(int w,int a, int b){

        this.source =a;

        this.dest =b;

        this.weight =w;

    }

 

           

}
class kru1
{

int parent[] = new int[100];

 

int find(int x){

          

           if(parent[x] == -1)

           {

                      return x;

           }

           return find(parent[x]);

}

 

void unite(int x, int y)

{

           int fx = find(x);

           int fy = find(y);

           parent[fx] = fy;

}

}

public class kruskal{

          

 

 

public static void main(String args[]){

           Scanner sc=new Scanner(System.in);

           kru1 k= new kru1();

          

          

           for(int i=0;i<100;i++){  //initialize parent to index

                      k.parent[i]=-1;

           }

 

           int v,e;

          

           int a,b,w;

           ArrayList<init> edges = new ArrayList<init>();  //all edges have a start,an end and a weight

          

           System.out.println("\n Enter number of edges:");

           e = sc.nextInt();

           System.out.println("\n Enter number of vertices:");

           v = sc.nextInt();

           for(int i=0;i<e;i++){

                      System.out.println("\n Enter the source vertex:");

                      a = sc.nextInt();

                      System.out.println("\n Enter the destination vertex:");

                      b = sc.nextInt();

                      System.out.println("\n Enter the weight of the Edge:");

                      w = sc.nextInt();

                      edges.add(new init(w,a,b));

           }

          

 

 

           int mst_weight = 0, mst_edges = 0;

           int      index = 0;

          

           Collections.sort(edges, new Comparator<init>()  //sort the edges according to weights

                                 {

                   public int compare(init p1, init p2) {

                       return (p1.weight - p2.weight);

                   }

           }

           );

 

           while( index < e )

           {

 

                      a = edges.get(index).source;

                      b = edges.get(index).dest;

                      w = edges.get(index).weight;

                     

                      if( k.find(a)!=k.find(b) )   //cycle not formed

                      {

                                

                                 k.unite(a,b); //add to MST

                                

                                 mst_weight += w; //add to total

                     

                                 System.out.println("\n"+a + "->" + b + "=" + w);

                                 mst_edges++;

                      }

          

                      index++;  //increment count

           }

 

           System.out.println( "\nWeight of the MST is " + mst_weight);

          

}

 

}

/*16 10

1 2 6

2 3 18

1 6 13

2 4 8

2 5 17

3 7 15

4 5 14

4 6 20

5 7 9

4 8 19

5 9 7

8 10 11

9 10 10

6 8 16

7 9 5

8 9 12

*/
/*
 Enter number of edges:
16

 Enter number of vertices:
10

 Enter the source vertex:
1

 Enter the destination vertex:
2

 Enter the weight of the Edge:
6

 Enter the source vertex:
2

 Enter the destination vertex:
3

 Enter the weight of the Edge:
18

 Enter the source vertex:
1

 Enter the destination vertex:
6

 Enter the weight of the Edge:
13

 Enter the source vertex:
2

 Enter the destination vertex:
4

 Enter the weight of the Edge:
8

 Enter the source vertex:
2

 Enter the destination vertex:
5

 Enter the weight of the Edge:
17

 Enter the source vertex:
3

 Enter the destination vertex:
7

 Enter the weight of the Edge:
15

 Enter the source vertex:
4

 Enter the destination vertex:
5

 Enter the weight of the Edge:
14

 Enter the source vertex:
4

 Enter the destination vertex:
6

 Enter the weight of the Edge:
20

 Enter the source vertex:
5

 Enter the destination vertex:
7

 Enter the weight of the Edge:
9

 Enter the source vertex:
4

 Enter the destination vertex:
8

 Enter the weight of the Edge:
19

 Enter the source vertex:
5

 Enter the destination vertex:
9

 Enter the weight of the Edge:
7

 Enter the source vertex:
8

 Enter the destination vertex:
10

 Enter the weight of the Edge:
11

 Enter the source vertex:
9

 Enter the destination vertex:
10

 Enter the weight of the Edge:
10

 Enter the source vertex:
6

 Enter the destination vertex:
8

 Enter the weight of the Edge:
16

 Enter the source vertex:
7

 Enter the destination vertex:
9

 Enter the weight of the Edge:
5

 Enter the source vertex:
8

 Enter the destination vertex:
9

 Enter the weight of the Edge:
12

7->9=5

1->2=6

5->9=7

2->4=8

9->10=10

8->10=11

1->6=13

4->5=14

3->7=15

Weight of the MST is 89
*/
/*
 Enter number of edges:
12

 Enter number of vertices:
7

 Enter the source vertex:
1

 Enter the destination vertex:
2

 Enter the weight of the Edge:
3

 Enter the source vertex:
1

 Enter the destination vertex:
4

 Enter the weight of the Edge:
2

 Enter the source vertex:
1

 Enter the destination vertex:
3

 Enter the weight of the Edge:
10

 Enter the source vertex:
1

 Enter the destination vertex:
5

 Enter the weight of the Edge:
4

 Enter the source vertex:
3

 Enter the destination vertex:
4

 Enter the weight of the Edge:
12

 Enter the source vertex:
4

 Enter the destination vertex:
5

 Enter the weight of the Edge:
6

 Enter the source vertex:
3

 Enter the destination vertex:
6

 Enter the weight of the Edge:
15

 Enter the source vertex:
4

 Enter the destination vertex:
6

 Enter the weight of the Edge:
4

 Enter the source vertex:
6

 Enter the destination vertex:
5

 Enter the weight of the Edge:
5

 Enter the source vertex:
6

 Enter the destination vertex:
7

 Enter the weight of the Edge:
3

 Enter the source vertex:
5

 Enter the destination vertex:
7

 Enter the weight of the Edge:
2

 Enter the source vertex:
2

 Enter the destination vertex:
5

 Enter the weight of the Edge:
7

1->4=2

5->7=2

1->2=3

6->7=3

1->5=4

1->3=10

Weight of the MST is 24
*/

 
