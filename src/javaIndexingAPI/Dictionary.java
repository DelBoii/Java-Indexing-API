package javaIndexingAPI;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
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
			CSVReader reader = new CSVReader(new FileReader(DICTIONARY_FILE));
			//FileInputStream fstream = new FileInputStream(DICTIONARY_FILE); //Wrap the file name in an input stream
			//DataInputStream in = new DataInputStream(reader); //Allows us to read primitive data types (ints, chars, floats) from a stream
			//BufferedReader br = new BufferedReader(new InputStreamReader(in)); //Buffers the data input stream
			//String delimter = ",";
			String[] next;
			double start = System.currentTimeMillis();
			while ((next = reader.readNext()) != null) { //Loop through each line in the dictionary file
				StrangeString theWord= new StrangeString(next[0].toLowerCase());
				if(wordMap.containsKey(theWord)){
					WordDetail word = new WordDetail();
					word = wordMap.get(theWord);
					word.setWord(next[0]);
					word.setWordType(next[1]);
					word.setDefinition(next[2]);
					//wordMap.put(theWord, word); //Also add the word to the hash map

					//System.out.println("Hello");
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
	
	public WordDetail[] getSortedWords(){
		return (WordDetail[]) wordList.toArray(new WordDetail[wordList.size()]);
	}
	
	public Map<StrangeString, WordDetail> getWordMap(){
		return wordMap;
	}
}
