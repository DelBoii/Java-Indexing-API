//JavaIndexingAPI - A program which parses a book and displays the page numbers that word is on and its definition, if any.
//Ryan Gordon - G00326349 - ryangordon210@gmail.com
package javaIndexingAPI;

import java.io.FileReader;
import java.util.*;

import com.opencsv.CSVReader;


public class Dictionary {
	private List<WordDetail> wordList = new ArrayList<WordDetail>(); //Instance variable of type List (an interface)
	private Map<StrangeString, WordDetail> wordMap = new HashMap<StrangeString, WordDetail>(); //Instance variable of type Map (also an interface...)
	
	private final String DICTIONARY_FILE = "dictionary.csv"; //A string instance variable
	
	//word groups separated by "," -->String[]words = line.split(",");
	
	public void load(Book book) throws Exception{ //If anything goes wrong, throw the exception to the calling method. Very lazy indeed!
		try {
			wordMap = book.getWordMap();
			CSVReader reader = new CSVReader(new FileReader(DICTIONARY_FILE));//Opensource JAR implemented to read the dictionary csv file
			String[] next;
			double start = System.currentTimeMillis();
			while ((next = reader.readNext()) != null) { //Loop through each line in the dictionary file
				StrangeString theWord= new StrangeString(next[0].toLowerCase());
				if(wordMap.containsKey(theWord)){
					WordDetail word = new WordDetail();
					word = wordMap.get(theWord);
					word.setWord(next[0]);
					word.setWordType(next[1]);
					String formattetStr = next[2] + "\n\n";
					word.setDefinition(formattetStr);
				}
			}
			double searchTime = ((System.currentTimeMillis() - start)/1000);
			System.out.println("Dictionary read and filled in "+searchTime+" seconds");
			//in.close(); //Good manners to close any in/out streams.
			reader.close();
		} catch (Exception e) {
			throw new Exception("[ERROR] Encountered a problem reading the dictionary. " + e.getMessage());		
		}
	}
	
	public int size(){
		return wordList.size();
	}
	
	
	public Map<StrangeString, WordDetail> getWordMap(){
		return wordMap;
	}
}
