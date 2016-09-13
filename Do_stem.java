import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Do_stem  implements ActionListener  
{
	JFrame frame;
    public static String[] stopwords = {"a","as", "able","about","above", "according", "accordingly","across", 
    		"actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost",
    		"alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", 
    		"another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", 
    		"apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", 
    		"asking", "associated", "at", "available", "away", "awfully","b", "be", "became", "because", "become", 
    		"becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below",
    		"beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by","c", "cmon",
    		"cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", 
    		"changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider",
    		"considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", 
    		"course", "currently","d", "definitely", "described", "despite", "did", "didnt", "different",
    		"do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during","e", "each", "edu",
    		"eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc",
    		"even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", 
    		"example", "except","f", "far", "few", "ff", "fifth", "first", "five", "followed", "following", 
    		"follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore","g", "get",
    		"gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings",
    		"h","had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", 
    		"hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", 
    		"hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", 
    		"however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", 
    		"inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into",
    		"inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself","j", "just","k", "keep", "keeps", 
    		"kept", "know", "knows", "known","l", "last", "lately", "later", "latter", "latterly", "least", 
    		"less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks",
    		"ltd","m", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", 
    		"moreover", "most", "mostly", "much", "must", "my", "myself","n", "name", "namely", "nd", "near", 
    		"nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine",
    		"no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", 
    		"nowhere", "obviously","o", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", 
    		"ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves",
    		"out", "outside", "over", "overall", "own","p", "particular", "particularly", "per", "perhaps",
    		"placed", "please", "plus", "possible", "presumably", "probably", "provides","q", "que", "quite", 
    		"qv","r", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", 
    		"relatively", "respectively", "right","s", "said", "same", "saw", "say", "saying", "says", "second",
    		"secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves",
    		"sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", 
    		"shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", 
    		"sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify",
    		"specifying", "still", "sub", "such", "sup", "sure","t", "ts", "take", "taken", "tell", "tends", 
    		"th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs",
    		"them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", 
    		"therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think",
    		"third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", 
    		"thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly",
    		"try", "trying", "twice", "two","u", "un", "under", "unfortunately", "unless", "unlikely", "until", 
    		"unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually","v", "value", 
    		"various", "very", "via", "viz", "vs","w", "want", "wants", "was", "wasnt", "way", "we", "wed",
    		"well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever",
    		"when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein",
    		"whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole",
    		"whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would",
    		"would", "wouldnt","x","y","ya", "yall","yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", 
    		"yourselves", "z","zero"};
    public static String nums ="[^a-z]";//regular expression for validate words except numbers and capital
    String [] tokens;
    int i=0,j=0,k=0,final_length=0,initial_tokens_length=0,flag=1,length_after_removing_stopwords=0,length_after_removing_numbers=0,length_after_stemming=0,frequency_of_each_tokens=0,length_of_list_at_final=0;
    BufferedReader buffer_reader;//for buffer
    FileReader  file_reader;//for file
    FileWriter file_writer;
    BufferedWriter buffer_writer;
    File selectedFile;//for selected file
    String each_line,filename;//for temporary
    JFileChooser datafile;//for datafile
    ArrayList<String> initial_array_list = new ArrayList<String>();//for initial tokens array
    ArrayList<String> list_after_converting_to_lowercase = new ArrayList<String>();//for holding lower case transformed array
    ArrayList<String> list_after_removing_numbers = new ArrayList<String>();//for holding array after removing numbers
    ArrayList<String> list_after_removing_stopwords = new ArrayList<String>();//for holding array after removing stopwords
    ArrayList<String> list_after_removing_numbers_final= new ArrayList<String>();
    ArrayList<String> final_list =  new ArrayList<String>();
    ArrayList<String> list_after_stemming =  new ArrayList<String>();
    ArrayList<String> list_after_stemming_final =  new ArrayList<String>();
    @SuppressWarnings("rawtypes")
	ArrayList final_frequency = new ArrayList();
    ArrayList<String> final_array_list =  new ArrayList<String>();
    
    
	public Do_stem()
	{
		frame=new JFrame("This Window");
		frame.setSize(600, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setBackground(Color.white);
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		
		JMenu file=new JMenu("File");
		menu.add(file);
		
		JMenu edit=new JMenu("Edit");
		menu.add(edit);
		
		JMenuItem open=new JMenuItem("Open File");
		file.add(open);
		
		open.addActionListener(this);			
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] a) 
	{
			Do_stem stem=new Do_stem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		datafile= new JFileChooser();		
        int returnValue = datafile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {   
        	selectedFile = datafile.getSelectedFile();
        	filename=selectedFile.toString();
        	stopwords_remover();       	         
		}
	}

	@SuppressWarnings("unchecked")
	private void stopwords_remover() 
	{
    	try
    	{
    		file_reader=new FileReader(selectedFile);
    		buffer_reader=new BufferedReader(file_reader);
           	
/*getting each line of a file in a line and tokenizing them and inserting into an initial array list*/    		
			while((each_line=buffer_reader.readLine())!=null)
			{			
				tokens=each_line.split(" ");
				for(i=0;i<tokens.length;i++)
				{	
					initial_tokens_length++;
					initial_array_list.add(tokens[i]);
				}	
			}
/*hence the array list contains each string split at a whitespace*/			
			

			
/*converting each string into a lower case so the checking is easy*/
			for(i=0;i<initial_tokens_length;i++)
			{
				list_after_converting_to_lowercase.add(initial_array_list.get(i).toLowerCase());
			}	
/*hence the string are converted as For into for*/
			

			
/*removing numbers from the lower case list array and creating an array list  */				
			for(i=0;i<initial_tokens_length;i++)
			{
				list_after_removing_numbers.add(list_after_converting_to_lowercase.get(i).toString().replaceAll(nums, ""));									
			}	
/*hence the numbers are  removed but are replaced by blank or empty*/
			
			
/*removing whitespace and empty string and creating a list*/
			for(i=0;i<initial_tokens_length;i++)
			{
					if((list_after_removing_numbers.get(i).isEmpty())==false)
					{
						list_after_removing_numbers_final.add(list_after_removing_numbers.get(i).toString());
						length_after_removing_numbers++;
					}							
			}
/*hence now the job is to remove stopwords*/
			
			
/*removing stopwords from the numbers removed final list*/			
			for(i=0;i<length_after_removing_numbers;i++)
			{
				for(j=0;j<stopwords.length;j++)
				{
						if((list_after_removing_numbers_final.get(i).toString().compareToIgnoreCase(stopwords[j]))==0)
						{
							flag=0;
							break;
						}
						else
						{
							flag=1;
						}
				}	
				if(flag==1)
				{
					list_after_removing_stopwords.add(list_after_removing_numbers_final.get(i).toString());
					length_after_removing_stopwords++;
				}						
			}
/*now the list is free from stopwords  and the frequency of each words is calculated*/
			
			
			
			
			
/*sorting the list after removing stopwords for better performance*/
			list_after_removing_stopwords.sort(null);
/*so we have sorted array list and ready for frequency*/
			
		
/*now stemming the list */			
			for(i=0;i<length_after_removing_stopwords;i++)				
			{
				Stemmer stem=new Stemmer();
				list_after_stemming.add(stem.stem(list_after_removing_stopwords.get(i)).toString());
				length_after_stemming++;
			}
			for(i=0;i<length_after_stemming;i++)
			{
				list_after_stemming_final.add(list_after_stemming.get(i).toString().replaceAll(nums, ""));									
			}	
			list_after_stemming_final.sort(null);
			for(i=0;i<length_after_stemming;i++)
			{
				for(j=0;j<stopwords.length;j++)
				{
						if((list_after_stemming_final.get(i).toString().compareToIgnoreCase(stopwords[j]))==0)
						{
							flag=0;
							break;
						}
						else
						{
							flag=1;
						}
				}	
				if(flag==1)
				{
					final_array_list.add(list_after_stemming_final.get(i).toString());
					final_length++;
				}						
			}
/*after completing stemming now we are ready for frequency*/
			
/*calculating frequency of each words and removing the redundant values*/
			for(i=0;i<final_length;)				
			{
				frequency_of_each_tokens=0;
				for(j=0;j<final_length;j++)	
				{
					if(final_array_list.get(i).toString().compareTo(final_array_list.get(j).toString())==0)
					{
						frequency_of_each_tokens++;
					}
				}
				final_list.add(final_array_list.get(i));
				i+=frequency_of_each_tokens;
				length_of_list_at_final++;
				final_frequency.add(frequency_of_each_tokens);				
			}
			buffer_reader.close();
			file_reader.close();
/*finally removed all and with frequency and stemmer and creating a final array list*/ 			
    	} 
    	catch (FileNotFoundException e1) 
    	{				
			e1.printStackTrace();
		} 
    	catch (IOException e1) 
    	{
			e1.printStackTrace();
		}
    	catch (Exception e1) 
    	{
			e1.printStackTrace();
		}
    	System.out.println(filename);
    	int lent=filename.length();
    	char [] renamed=filename.toCharArray();
    	renamed[lent-1]='v';
    	renamed[lent-2]='s';
    	renamed[lent-3]='c';    	
    	String new_name=String.valueOf(renamed);    	
    	try 
    	{
    		file_writer=new FileWriter(new_name, true);
    		buffer_writer=new BufferedWriter(file_writer);
    		for(i=0;i<length_of_list_at_final;i++)
    	    {
				buffer_writer.write(final_list.get(i).toString());
				buffer_writer.write(",");
				buffer_writer.write(final_frequency.get(i).toString());
				buffer_writer.newLine();
				System.out.println(i);
			} 
    		buffer_writer.close();
    		file_writer.close();
    	}
    	catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null,"Error Writing"+e);
		}		
	}
}
