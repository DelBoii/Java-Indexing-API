package javaIndexingAPI;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class Book {
	private List<String> ignoreWords = new ArrayList<String>(); //Instance variable of type List (an interface)
	private Map<StrangeString, WordDetail> wordMap = new HashMap<StrangeString, WordDetail>(); //Instance variable of type Map (also an interface...)
	int lineCounter,page=1;
	private final String IGNORE_FILE = "sample-text-file/stopwords.txt"; //A string instance variable
	
	public void ignoreList() throws Exception{
		try{
		FileInputStream fstream = new FileInputStream(IGNORE_FILE); //Wrap the file name in an input stream
		DataInputStream in = new DataInputStream(fstream); //Allows us to read primitive data types (ints, chars, floats) from a stream
		BufferedReader br = new BufferedReader(new InputStreamReader(in)); //Buffers the data input stream
		
		String next;
		while ((next = br.readLine()) != null) { 
			String[] words = next.split(" ");
			for(int i = 0; i < words.length; i++) // 4
			{
				String lCaseWord = words[i].toLowerCase();
				//StrangeString theWord= new StrangeString(lCaseWord);
				ignoreWords.add(lCaseWord);
			}
		}
		in.close();
		}catch (Exception e) {
			throw new Exception("[ERROR] Encountered a problem reading the stop words. " + e.getMessage());		
		}
	}
	
	
	//word groups separated by "," -->String[]words = line.split(",");
	public void parse(String PARSE_FILE) throws Exception{ //If anything goes wrong, throw the exception to the calling method. Very lazy indeed!
		try {
			FileInputStream fstream = new FileInputStream(PARSE_FILE); //Wrap the file name in an input stream
			DataInputStream in = new DataInputStream(fstream); //Allows us to read primitive data types (ints, chars, floats) from a stream
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); //Buffers the data input stream
			
			//wordMap = dictionary.getWordMap();
			String next;
			
			double start = System.currentTimeMillis();

			while ((next = br.readLine()) != null) { //Loop through each line in the dictionary file
				lineCounter++;
				
				if(lineCounter %40 == 0)
				{
					page++;
				}
				String[] words = next.split(" ");
				
				for(int i = 0; i < words.length; i++) // 4
				{
					if(ignoreWords.contains(words[i])){
						continue;
					}
					
					//when putting key in make word lowercase for hashcode, actual word stored in word detail
					StrangeString theWord= new StrangeString(words[i].toLowerCase());
					if(wordMap.containsKey(theWord)) // 6
					{
						WordDetail wd = wordMap.get(theWord);  // 7
						wd.addIndex(page);	
					}
					else
					{
						WordDetail wd = new WordDetail(); // 8
						wd.addIndex(page);
						
						
						//Set<String> wordDefinition = wd.getDefinition();
						
								if(wd.getDefinition() == null) // 10
								{
									String definition = "No Definition in dictionary";
									wd.setDefinition(definition);
								}
								wordMap.put(theWord, wd);
					}//end else
				}
			}//end while
			double searchTime = ((System.currentTimeMillis() - start)/1000);
			System.out.println("Book read and indices added in "+searchTime+" seconds");
			in.close(); //Good manners to close any in/out streams.
		}catch (Exception e) {
			throw new Exception("[ERROR] Encountered a problem reading the book. " + e.getMessage());		
		}
	}
	public Map<StrangeString, WordDetail> getWordMap(){
		return wordMap;
	}
}
