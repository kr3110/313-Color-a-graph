
/********************************************************
 * 			Project 3.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-10			 
 * 								 
 *	 Class Summary:
 *Read matrix from data file from arguments;
 *create a graph and connect it;
 *Color the graph and print when a Backtracking is happening;
 *print the final Color assign to each vertex in the graph
 *keep doing this until file is empty
 *******************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
public class Project3 {

		public static void main(String[] args) {
			FileReader file;
			BufferedReader infile;
			String line;		
				try	{
					if(args.length==0) throw new Exception("\nArgument is empty"
							+"\nProgram will shutdown");
					file=new FileReader(args[0]);
					infile=new BufferedReader(file);
					int i=1;
					while((line=infile.readLine())!=null)
					{
						System.out.println(i+ " matrix");
						int vertices=Integer.parseInt(line);
						Graph graph=new Graph(vertices);
						for(int j=0;j<vertices;j++)
						{
							line=infile.readLine();
							String[] numbers=line.split(" ");
							graph.addneighbors(j, numbers);
						}
						Graph.colorgraph(graph);
						System.out.println("\nBacktracking in total: "+ graph.Backtracking);
						System.out.println("final Color Print");
						graph.finalColorPrint();
						i++;
						graph.makeEmpty();
					}
				}
				catch(Exception e)	{	 System.out.println(e);	}
				}	
	}
