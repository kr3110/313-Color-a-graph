/********************************************************
 * 				Graph.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-10			 
 * 								 
 *	 Constructor Summary:
 * Graph()
 * Default Constructor, create 16 vertices as default.
 * Graph(int x)
 * pass an int value x representing the amount of vertices in the graph, and create x amount of vertices.
 * 
 *  Methods Summary:
 * addneighbors(int vert, String[] numbers)
 * Pass an int representing a vertices name and a string with numbers and add the neighbors to the vertex
 * public void makeEmpty()
 * makes the graph empty
 * public int getVertices()
 * return the number of vertices
 * public static void printOut(int x)
 * pass an int representing the amount of index and print out this vertices with the color assigned 
 * static boolean coloring(Graph gra, int ver)
 * pass a graph and a vertex index and try to color it and return true if it found a match color
 * static void coloringInter(Graph g, )
 * pass a graph and color all the vertex in it;
 * public void finalColorPrint()
 *  print the entire graph with all the color assign to it;
 * public static boolean isValid(Graph g,int x, int c)
 * check if color c can be assing to vertex x in graph g and return true if it is possible;
 *******************************************************/
public class Graph {
	private  Vertex [] container  ;
	private static int vertices=16;
	static int[] color;
	private static final int maxColor=4;
	static boolean backtracking=false;
	int Backtracking=0;
	
	public Graph(){
		container=new Vertex[vertices];
		for(int i=0;i<vertices;i++)
			container[i]=new Vertex(i,vertices);	
		color=new int[vertices];		
	}
	public Graph(int x){
		vertices=x;
		container=new Vertex[vertices];
		for(int i=0;i < vertices; i++)
			container[i]= new Vertex(i,vertices);
		color=new int[vertices];		
	}
	
	public void addneighbors(int vert, String[] numbers){
		for(int i=0 ;i< vertices; i++){
			if (Integer.parseInt(numbers[i])==1)
				container[vert].setneigh(container[i]);
		}
	}
	
	public void makeEmpty(){
		container= null;
		backtracking=false;
		Backtracking=0;
		color=null;
	}
	
	public int getVertices()	{	return vertices;	}
	

	public static void printOut(int x)	{
		for(int i=0;i<x;i++)	{
			if(color[i]>-1 && color[i]< 4)	{
			if(color[i]==0)
				System.out.println(i+ "--> red");
			else if(color[i]==1)
				System.out.println(i+ "--> green");
			else if(color[i]==2)
				System.out.println(i+ "--> blue");
			else if(color[i]==3)
				System.out.println(i+ "--> yellow");
			}
		}
	}

	 static boolean colorvertex(Graph gra, int ver)	 {
		 if (ver == gra.getVertices())
			 return true;
		 for (int c = 0; c < maxColor; c++)	 {	
			 if (isValid(gra,ver,c)) {	
				 color[ver] = c;
				 backtracking=true;
				 if (colorvertex(gra, ver + 1))
					 return true;	
			 }
		}
		 if(backtracking)	 {
		 System.out.println("\nBacktracking happening");
		 backtracking=false;
		 printOut(gra.getVertices());
		 gra.Backtracking++;
		 }
		 return false;
	 }
	 
	 static void colorgraph(Graph g)	{
		 color = new int[vertices];
		 for (int i = 0; i < vertices; i++)
			 color[i] =-1;
		colorvertex(g, 0);
		for(int i=0;i<g.getVertices();i++)	{
			g.container[i].setcolor(color[i]);
		}
	}
	 
	public static boolean isValid(Graph g,int x, int c)	{
		for(int i=0; i < x; i++)
			if (color[i] == c && g.container[i].isNeighbor(x) )
				return false;
		return true;
	}
	public void finalColorPrint(){
		for(int i=0;i<vertices;i++){
			System.out.print(container[i].name+"-->");
			if(container[i].getColor()==0)
				System.out.print(" red");
			else if(container[i].getColor()==1)
				System.out.print(" green");
			else if(container[i].getColor()==2)
				System.out.print(" blue");
			else if(container[i].getColor()==3)
				System.out.print(" yellow");
			System.out.println();
		}
		System.out.println("\n");
	}
}