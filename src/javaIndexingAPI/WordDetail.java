//JavaIndexingAPI - A program which parses a book and displays the page numbers that word is on and its definition, if any.
//Ryan Gordon - G00326349 - ryangordon210@gmail.com
package javaIndexingAPI;

import java.util.Set;
import java.util.TreeSet;

public class WordDetail{
	private String word;
	private Set<String> definitions = new TreeSet<String>(); //The definition for the word //Change this to a Treeset containing defitions allows multple difinitions with no chance of duplicates
	private String wordType; //Type of word, i.e noun, verb
	private Set<Integer> pages = new TreeSet<Integer>(); //Treeset which will hold the page numbers
	//Treeset is needed here as a Set does not hold duplicates, benificial if a word appears twice or more on a page
	public WordDetail(){}
	
	////There may be more than one definition for a word so we use a treeset to store the 
	public Set<String> getDefinition() {
		return definitions;
	}
	public void setDefinition(String definition) { //getters and setters
		definitions.add(definition);
	}

	////Add the word name into the object to show to user
	public WordDetail(String word){
		this.word=word;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	////Word Type
	public String getWordType() {
		return wordType;
	}
	public void setWordType(String wordType) {
		this.wordType = wordType;
	}
	////Pages (Indices ) where the word appears in a book
	public Set<Integer> getPages() {
		return pages;
	}
	
	////Increment the pages TreeSet adding a page number. If page number is already there it does not store duplicate
	public void addIndex(int page){
		pages.add(page);
	}
	
	
	}//end WordDetail class
	