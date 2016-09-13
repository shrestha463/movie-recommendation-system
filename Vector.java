import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vector 
{
	static ArrayList<String> words=new ArrayList<String>();
	static ArrayList<String> frequency=new ArrayList<String>();
	static ArrayList<String> vector_words=new ArrayList<String>();
	static ArrayList<String> vector_frequency=new ArrayList<String>();
	static ArrayList<String> distinct=new ArrayList<String>();
	static File all_csv;
    static File vector_file=new File("C:\\Users\\Joshan\\Documents\\subtitles and vectors\\vector.csv");
    static FileWriter final_vector_file_writer;
    static BufferedWriter final_vector_buffer_writer;
	static FileReader all_csv_file_reader;
	static BufferedReader all_csv_buffer_reader;

    private static void destroy() throws IOException 
    {
    	final_vector_buffer_writer.close();
    	final_vector_file_writer.close();
       
    }
    public Vector()
    {
    	try
        {
    		final_vector_file_writer=new FileWriter(vector_file);
    		final_vector_buffer_writer=new BufferedWriter(final_vector_file_writer);
        } 
    	catch (IOException ex) 
    	{
    		Logger.getLogger(Vector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
	public static void main(String [] p) throws IOException
	{
		Vector tv=new Vector();
		for(int i=1;i<=14;i++)
		{
			tv.vc(i);
		}
		tv.distict();
		System.out.println(distinct.size());
		for(int i=1;i<=14;i++)
		{
			tv.vector(i);
		}
        destroy();
		System.out.println(" All file written");
	}

	public void vc(int j) throws IOException
	{
		all_csv=new File("C:\\Users\\Joshan\\Documents\\subtitles and vectors\\m"+j+".csv");
		FileReader all_csv_file_reader=new FileReader(all_csv);
		BufferedReader br=new BufferedReader(all_csv_file_reader);
		String line;
		int k=0;
		while((line=br.readLine())!=null)
		{		
			String [] tokens=line.split(",");
			for(int i=0;i<tokens.length;i++)
			{
				
				if(i%2==0)
				{
					
					words.add(tokens[i].toString());
				}
				else if(i%2!=0)
				{
					frequency.add(tokens[i].toString());
				}					
			}				
		}	
	}
	public  void distict() throws IOException
	{
		words.sort(null);
		for(int l=0;l<words.size();)
		{
			int f=0;
			for(int j=0;j<words.size();j++)
			{
				if(words.get(l).toString().compareTo(words.get(j).toString())==0)
				{
					f++;
				}
			}
			distinct.add(words.get(l).toString());
			l+=f;
		}
		
		for(int i=0;i<distinct.size();i++)
		{
			final_vector_buffer_writer.write(distinct.get(i));
			final_vector_buffer_writer.write(",");
		}
		final_vector_buffer_writer.newLine();
	}
	public void vector(int j) throws IOException 
	{	
		
		all_csv=new File("C:\\Users\\Joshan\\Documents\\subtitles and vectors\\m"+j+".csv");
		all_csv_file_reader=new FileReader(all_csv);
		all_csv_buffer_reader=new BufferedReader(all_csv_file_reader);
		String line;
		while((line=all_csv_buffer_reader.readLine())!=null)
		{
			String [] tokens=line.split(",");
			for(int i=0;i<tokens.length;i++)
			{
				if(i%2==0)
				{
					vector_words.add(tokens[i]);
				}
				else if(i%2!=0)
				{
					vector_frequency.add(tokens[i]);
				}
			}		
		}
		vector_words.add(" ");
		vector_frequency.add("0");
		int x=0,y=0;
		for(x=0;x<distinct.size();x++)
		{
			if(distinct.get(x).compareTo(vector_words.get(y))==0 || y==vector_words.size())
			{
				final_vector_buffer_writer.write(vector_frequency.get(y));
				final_vector_buffer_writer.write(",");
				y++;
			}
			else
			{
				final_vector_buffer_writer.write("0");
				final_vector_buffer_writer.write(",");
			}			
		}
		final_vector_buffer_writer.newLine();
		vector_words.clear();
		vector_frequency.clear();
	}
}