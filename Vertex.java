/********************************************************
 * 			Vertex.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-10			 
 * 								 
 *	 Constructor Summary:
 * Vertex(int n,int ver)
 * 	Pass an int representing the name and an int representing the maximum neighbors the vertex might have
 * Methods Summary:
 *public void setneigh(Vertex v)
 * 	pass a vertex v and set it as a neighbor
 * public int getneigh(int index)
 * 	pass a value int representing an index and returns the neighbor. 
 * public void setcolor(int i)
 * 	pass a value int and set it as a color of the vertex 
 * public int getColor()
 * 	returns the color value of the vertex
 * public boolean isNeighbor(int name)
 * pass an int representing a name and returns true if it is a neighbor of the verte, otherwise false
 *******************************************************/
public class Vertex {
	int name;
	private int[] neighbors;
	private int degree;
	private int color;	
	
	public  Vertex(int n,int ver)	{		name=n;	neighbors=new int[ver];	degree=0;}
	public void setneigh(Vertex v)	{	neighbors[degree++]=v.name;	}
	public int getColor()			{	return color;	}
	public int getDegree()			{	return degree;	}
	public int getneigh(int index)	{
		if( index>degree) 
			return -999999999;
		return neighbors[index];
	}
	public void setcolor(int i)	{
		if(i < 0 || i>4) System.out.println("i is not a color");
		else 
			color=i;
	}
	public boolean isNeighbor(int name)	{
		for(int i=0; i< degree; i++)
			if(neighbors[i]==name)
				return true;
		return false;
	}
}
