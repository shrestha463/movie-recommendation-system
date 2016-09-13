/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 *
 * @author arjun
 */
public class Cluster {

    
    ArrayList<String> frequency=new ArrayList<String>();
    ArrayList<String> movies=new ArrayList<String>();
    ArrayList<String> Comedy=new ArrayList<String>();
    ArrayList<String> Action=new ArrayList<String>();
    ArrayList<String> Horror=new ArrayList<String>();
    ArrayList<String> Romance=new ArrayList<String>();
    ArrayList<String> Adventure=new ArrayList<String>();
    int cluster_size=5;
    int movie_size=14;
    int distinct_words_size=6442;
    int fre[][]=new int[movie_size][distinct_words_size];  
    ArrayList weight=new ArrayList();
    BufferedReader buff_reader;
    File file;
    FileReader file_reader;
    static String cat; 
    int sub;
   
    int temp[][]=new int[cluster_size][distinct_words_size];
    
    public Cluster() throws FileNotFoundException
    {
        
        file=new File("C:\\Users\\Joshan\\Documents\\subtitles and vectors\\vector.csv");
        file_reader=new FileReader(file);
        buff_reader=new BufferedReader(file_reader);
        movies.add("Batman vs Superman");
        movies.add("Evil Dead");
        movies.add("Titanic");
        movies.add("Hobbit Unexpected Journey");
        movies.add("San Andreas");
        movies.add("xxx");
        movies.add("Day and Knight");
        movies.add("The Conjuring");
        movies.add("Harold and Kumar goes to White Castle");
        movies.add("Beauty and the Beast");
        movies.add("Black Swan");
        movies.add("Maze Runner");
        movies.add("The Devil Inside");
        movies.add("Amityville");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
       Cluster c=new Cluster();
       c.remove();
       c.Comedy.add(c.movies.get(8));
       c.Action.add(c.movies.get(0));
       c.Horror.add(c.movies.get(1));
       c.Romance.add(c.movies.get(2));
       c.Adventure.add(c.movies.get(3));
       for(int i=0;i<10;i++)
       {
    	   c.cluster(i);
       }
      
      // c.distinct();
       c.recomend();
       c.write();
    }    
    
	private void remove() throws IOException 
    {
        String line;
        while((line=buff_reader.readLine())!=null)
        {
            String[] tokens=line.split(",");
            for(int i=0;i<tokens.length;i++)
            {
                frequency.add(tokens[i]);
                
            }
        }
       int k=distinct_words_size;
       for(int i=0;i<movie_size;i++)
       {
    	   for(int j=0;j<distinct_words_size;j++)
    	   {
    		   fre[i][j]=Integer.parseInt(frequency.get(k));
    		   k++;
    	   }
       }
       
       for(int i=0;i<distinct_words_size;i++)
       {
    	   	temp[0][i]=fre[8][i];
       }
       for(int i=0;i<distinct_words_size;i++)
       {
    	   	temp[1][i]=fre[0][i];
       }
       for(int i=0;i<distinct_words_size;i++)
       {
    	   	temp[2][i]=fre[1][i];
       }
       for(int i=0;i<distinct_words_size;i++)
       {
			temp[3][i]=fre[2][i];
       }
       for(int i=0;i<distinct_words_size;i++)
       {
			temp[4][i]=fre[3][i];
       }
    }
	
    private void cluster(int itr)
    {      
    	float nom=0.0f;
    	float sqr1=0.0f;
    	float sqr2=0.0f;    	
    	float weight[]=new float[5];
    	float dummy=0.0f;
    	int index=0;  
    	int flag=0;
    	if(sub==0)
    	{
    		Comedy.clear();
    		Action.clear();
    		Horror.clear();
    		Romance.clear();
    		Adventure.clear();    		
    	}
    	for(sub=0;sub<movie_size;sub++)
    	{
    		weight[0]=0.0f;
    		weight[1]=0.0f;
    		weight[2]=0.0f;
    		weight[3]=0.0f;
    		weight[4]=0.0f;    		
    		
    		
	    	for(int j=0;j<cluster_size;j++)
			{
	    		nom=0.0f;
				sqr1=0.0f;
				sqr2=0.0f;	    	
				for(int k=0;k<distinct_words_size;k++)
				{
				    nom+=temp[j][k]*fre[sub][k];
				    sqr1+=temp[j][k]*temp[j][k];
				    sqr2+=fre[sub][k]*fre[sub][k];
				}
				weight[j]=(float) (nom/(Math.sqrt(sqr1)*Math.sqrt(sqr2)));
			}
	    	
	    	
	    	//getting the highest weight
	    	dummy=0.0F;
	    	for(int m=0;m<cluster_size;m++)
			{
	    		if(dummy<weight[m])
				{
				    dummy=weight[m];
				}
			}
	    	
	    	
	    	//finding the index of highest weight
			for(int n=0;n<cluster_size;n++)
			{
				if(dummy==weight[n])
				{
					index=n;
				    break;
				 }
			}
			
			System.out.println("Dummy is "+dummy);
			System.out.println("Index is "+index);
			for(int m=0;m<cluster_size;m++)
			{
				System.out.println(weight[m]);
			}
			
			
			//index 0 for comedy
			if(index==0)
			{
				flag=0;
				//checking if the  movie is already in comedy
				for(int o=0;o<Comedy.size();o++)
				{
					if(Comedy.get(o).compareTo(movies.get(sub))==0)
					{
						flag=1;
						cat="non";
						break;
					}
					else
					{
						flag=0;
					}						
				}
				
				//if the comedy movie is already in action
				if(flag==0)
				{
					for(int p=0;p<Comedy.size();p++)
					{
						for(int q=0;q<Action.size();q++)
						{
							if(Comedy.get(p).toString().compareTo(Action.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the comedy movie is already in horror
					for(int p=0;p<Comedy.size();p++)
					{
						for(int q=0;q<Horror.size();q++)
						{
							if(Comedy.get(p).toString().compareTo(Horror.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the comedy movie is already in romance
					for(int p=0;p<Comedy.size();p++)
					{
						for(int q=0;q<Romance.size();q++)
						{
							if(Comedy.get(p).toString().compareTo(Romance.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the comedy movie is already in adventure
					for(int p=0;p<Comedy.size();p++)
					{
						for(int q=0;q<Adventure.size();q++)
						{
							if(Comedy.get(p).toString().compareTo(Adventure.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
				}
				//if not add the movie in comedy
				if(flag==0)
				{
					Comedy.add(movies.get(sub));
					cat="comedy";
					for(int i=0;i<distinct_words_size;i++)
	    			{
	    				temp[0][i]=0;
	    			}
			    	for(int i=0;i<Comedy.size();i++)
			    	{
			    		for(int j=0;j<movies.size();j++)
			    		{
			    			if(Comedy.get(i).toString().compareTo(movies.get(j).toString())==0)
			    			{
			    				for(int k=0;k<distinct_words_size;k++)
			    				{
			    					temp[0][k]+=fre[j][k];
			    				}
			    			}
			    		}
				    }
				}				
			}		
			//index 1 for action
			else if(index==1)
			{
				flag=0;
				//checking if the movie is already in action 
				for(int o=0;o<Action.size();o++)
				{
					if(Action.get(o).compareTo(movies.get(sub))==0)
					{
						flag=1;
						cat="non";
						break;
					}
					else
					{
						flag=0;
					}						
				}
				if(flag==0)
				{
					//if the action  movie is already in comedy
					for(int p=0;p<Action.size();p++)
					{
						for(int q=0;q<Comedy.size();q++)
						{
							if(Action.get(p).toString().compareTo(Comedy.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the action movie is already in horror
					for(int p=0;p<Action.size();p++)
					{
						for(int q=0;q<Horror.size();q++)
						{
							if(Action.get(p).toString().compareTo(Horror.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the action movie is already in romance
					for(int p=0;p<Action.size();p++)
					{
						for(int q=0;q<Romance.size();q++)
						{
							if(Action.get(p).toString().compareTo(Romance.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the action movie is already in adventure
					for(int p=0;p<Action.size();p++)
					{
						for(int q=0;q<Adventure.size();q++)
						{
							if(Action.get(p).toString().compareTo(Adventure.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
				}	
				//if not add the movie in action
				if(flag==0)
				{
					Action.add(movies.get(sub));
					cat="action";
					for(int i=0;i<distinct_words_size;i++)
	    			{
	    				temp[1][i]=0;
	    			}
			    	for(int i=0;i<Action.size();i++)
			    	{
			    		for(int j=0;j<movies.size();j++)
			    		{
			    			if(Action.get(i).toString().compareTo(movies.get(j).toString())==0)
			    			{
			    				for(int k=0;k<distinct_words_size;k++)
			    				{
			    					temp[1][k]+=fre[j][k];
			    				}
			    			}
			    		}
				    }
				}
			}
			//index 2 for horror
			else if(index==2)
			{
				flag=0;
				//checking if the movie is already in horror
				for(int o=0;o<Horror.size();o++)
				{
					if(Horror.get(o).compareTo(movies.get(sub))==0)
					{
						flag=1;
						cat="non";
						break;
					}
					else
					{
						flag=0;
					}						
				}
				
				if(flag==0)
				{
					//if the horror movie is already in comedy
					for(int p=0;p<Horror.size();p++)
					{
						for(int q=0;q<Comedy.size();q++)
						{
							if(Horror.get(p).toString().compareTo(Comedy.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the horror movie is already in action 
					for(int p=0;p<Horror.size();p++)
					{
						for(int q=0;q<Action.size();q++)
						{
							if(Horror.get(p).toString().compareTo(Action.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the horror movie is already in romance
					for(int p=0;p<Horror.size();p++)
					{
						for(int q=0;q<Romance.size();q++)
						{
							if(Horror.get(p).toString().compareTo(Romance.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the horror movie is already in adventure
					for(int p=0;p<Horror.size();p++)
					{
						for(int q=0;q<Adventure.size();q++)
						{
							if(Horror.get(p).toString().compareTo(Adventure.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
				}	
				//if not add the movie in horror
				if(flag==0)
				{
					Horror.add(movies.get(sub));
					cat="horror";
					for(int i=0;i<distinct_words_size;i++)
	    			{
	    				temp[2][i]=0;
	    			}
			    	for(int i=0;i<Horror.size();i++)
			    	{
			    		for(int j=0;j<movies.size();j++)
			    		{
			    			if(Horror.get(i).toString().compareTo(movies.get(j).toString())==0)
			    			{
			    				for(int k=0;k<distinct_words_size;k++)
			    				{
			    					temp[2][k]+=fre[j][k];
			    				}
			    			}
			    		}
				    }
				}	
			}
			//index 3 for romance
			else if(index==3)
			{
				flag=0;
				//if the  movie is already in romance
				for(int o=0;o<Romance.size();o++)
				{
					if(Romance.get(o).compareTo(movies.get(sub))==0)
					{
						flag=1;
						cat="non";
						break;
					}
					else
					{
						flag=0;
					}						
				}
				if(flag==0)
				{
					//if the romance movie is already in comedy
					for(int p=0;p<Romance.size();p++)
					{
						for(int q=0;q<Comedy.size();q++)
						{
							if(Romance.get(p).toString().compareTo(Comedy.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the romance movie is already in action
					for(int p=0;p<Romance.size();p++)
					{
						for(int q=0;q<Action.size();q++)
						{
							if(Romance.get(p).toString().compareTo(Action.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the romance movie is already in horror
					for(int p=0;p<Romance.size();p++)
					{
						for(int q=0;q<Horror.size();q++)
						{
							if(Romance.get(p).toString().compareTo(Horror.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the romance movie is already in adventure
					for(int p=0;p<Romance.size();p++)
					{
						for(int q=0;q<Adventure.size();q++)
						{
							if(Romance.get(p).toString().compareTo(Adventure.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
				}	
				//if not add the movie in romance
				if(flag==0)
				{
					Romance.add(movies.get(sub));
					cat="romance";
					for(int i=0;i<distinct_words_size;i++)
	    			{
	    				temp[3][i]=0;
	    			}
			    	for(int i=0;i<Romance.size();i++)
			    	{
			    		for(int j=0;j<movies.size();j++)
			    		{
			    			if(Romance.get(i).toString().compareTo(movies.get(j).toString())==0)
			    			{
			    				for(int k=0;k<distinct_words_size;k++)
			    				{
			    					temp[3][k]+=fre[j][k];
			    				}
			    			}
			    		}
				    }
				}
			}
			//index 4 is for adventure
			else if(index==4)
			{
				flag=0;
				//if the movie is already in adventure
				for(int o=0;o<Adventure.size();o++)
				{
					if(Adventure.get(o).compareTo(movies.get(sub))==0)
					{
						flag=1;
						cat="non";
						break;
					}
					else
					{
						flag=0;
					}						
				}
				if(flag==0)
				{
					//if the adventure movie is already in comedy
					for(int p=0;p<Adventure.size();p++)
					{
						for(int q=0;q<Comedy.size();q++)
						{
							if(Adventure.get(p).toString().compareTo(Comedy.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the adventure movie is already in action
					for(int p=0;p<Adventure.size();p++)
					{
						for(int q=0;q<Action.size();q++)
						{
							if(Adventure.get(p).toString().compareTo(Action.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the adventure movie is already in horror
					for(int p=0;p<Adventure.size();p++)
					{
						for(int q=0;q<Horror.size();q++)
						{
							if(Adventure.get(p).toString().compareTo(Horror.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
					//if the adventure movie is already in romance
					for(int p=0;p<Adventure.size();p++)
					{
						for(int q=0;q<Romance.size();q++)
						{
							if(Adventure.get(p).toString().compareTo(Romance.get(q))==0)
							{
								flag=1;
								cat="non";
								break;
							}
							else
								flag=0;
						}
					}
				}	
				//if not add the movie in adventure
				if(flag==0)
				{
					Adventure.add(movies.get(sub));
					cat="adventure";
					for(int i=0;i<distinct_words_size;i++)
	    			{
	    				temp[4][i]=0;
	    			}
			    	for(int i=0;i<Adventure.size();i++)
			    	{
			    		for(int j=0;j<movies.size();j++)
			    		{
			    			if(Adventure.get(i).toString().compareTo(movies.get(j).toString())==0)
			    			{
			    				for(int k=0;k<distinct_words_size;k++)
			    				{
			    					temp[4][k]+=fre[j][k];
			    				}
			    			}
			    		}
				    }
				}
			}
    	}
    	
    }
    public void recomend()
    {
    	System.out.println("Voila You should Watch Comedy Movies Like: ");
    	for(int i=0;i<Comedy.size();i++)
    	{
    		System.out.println(Comedy.get(i));
    	}
    	System.out.println("Voila You should Watch Action Movies Like: ");
    	for(int i=0;i<Action.size();i++)
    	{
    		System.out.println(Action.get(i));
    	}
    	System.out.println("Voila You should Watch Horror Movies Like: ");
    	for(int i=0;i<Horror.size();i++)
    	{
    		System.out.println(Horror.get(i));
    	}
    	System.out.println("Voila You should Watch Romantic Movies Like: ");
    	for(int i=0;i<Romance.size();i++)
    	{
    		System.out.println(Romance.get(i));
    	}
    	System.out.println("Voila You should Watch Adventure Movies Like: ");
    	for(int i=0;i<Adventure.size();i++)
    	{
    		System.out.println(Adventure.get(i));
    	}
    }
    public void write() throws IOException
    {
    	FileWriter fw=new FileWriter("C:\\Users\\Joshan\\Documents\\subtitles and vectors\\cluster.csv");
    	BufferedWriter bw=new BufferedWriter(fw);
    	bw.write("Comedy");
    	bw.write(",");
    	for(int i=0;i<Comedy.size();i++)
    	{
    		bw.write(Comedy.get(i));
    		bw.write(",");
    	}
    	bw.newLine();
    	bw.write("Action");
    	bw.write(",");
    	for(int i=0;i<Action.size();i++)
    	{
    		bw.write(Action.get(i));
    		bw.write(",");
    	}
    	bw.newLine();
    	bw.write("Horror");
    	bw.write(",");
    	for(int i=0;i<Horror.size();i++)
    	{
    		bw.write(Horror.get(i));
    		bw.write(",");
    	}
    	bw.newLine();
    	bw.write("Romance");
    	bw.write(",");
    	for(int i=0;i<Romance.size();i++)
    	{
    		bw.write(Romance.get(i));
    		bw.write(",");
    	}
    	bw.newLine();
    	bw.write("Action");
    	bw.write(",");
    	for(int i=0;i<Adventure.size();i++)
    	{
    		bw.write(Adventure.get(i));
    		bw.write(",");
    	}
    	bw.close();
    	fw.close();
    	buff_reader.close();
    	file_reader.close();    	
    }
}

