//JavaIndexingAPI - A program which parses a book and displays the page numbers that word is on and its definition, if any.
//Ryan Gordon - G00326349 - ryangordon210@gmail.com
package javaIndexingAPI;

import java.util.*;
import javax.swing.*;

public class WordSearch{
	public static void main(String[] args) throws Exception{
		
		Dictionary dictionary = new Dictionary(); //Instantiate the dictionary
		Book book = new Book();
		String PARSE_FILE = "sample-text-file/DeBelloGallico.txt"; //A string instance variable
		System.out.println("Enter the path for your text file the default file is :sample-text-file/DeBelloGallico.txt");
		Scanner sc = new Scanner(System.in);
		PARSE_FILE = sc.nextLine();
		double start = System.currentTimeMillis();
		book.ignoreList();
		book.parse(PARSE_FILE);//dictionary is passed into book parsing method in order to get the word map, may change this to only sending the word map        

		sc.close();
		dictionary.load(book); //Load the dictionary into memory
		double searchTime = ((System.currentTimeMillis() - start)/1000);//used to demonstrate the speed of the programs operation
		System.out.println("Full program load time is: "+searchTime+" seconds");
		String searchTerm = JOptionPane.showInputDialog("Enter a word to search");

		//Using a hash map is average O(1)
		Map<StrangeString, WordDetail> map = dictionary.getWordMap(); //Get a hash map of the words
		StrangeString ss = new StrangeString(searchTerm.toLowerCase()); //Wrap the search string in a wrapper object
		if (map.containsKey(ss)){ //Check if key exists in hash table. This is an O(1) operation
			WordDetail word = map.get(ss); //Get the values associated with the key in the hash table. Also O(1) 
			System.out.println("Word :" + word.getWord() + "\nWord Type: "+word.getWordType()+"\nDefinition: "+word.getDefinition() ); //Print result
			System.out.println("Pages :" +word.getPages()); //Print result
			
			//JOptionPane.showMessageDialog(null, "Word :" + word.getWord() + "\nWord Type: "+word.getWordType()+"\nDefinition: "+word.getDefinition() );
		}else{
			System.out.println(searchTerm + " is not in the dictionary"); //Word is not in the hash table
		}
	}
}

