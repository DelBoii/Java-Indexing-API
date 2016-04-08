package javaIndexingAPI;

import java.util.Set;
import java.util.TreeSet;

public class WordDetail{
	private String word;
	//private Set<String> definitions = new TreeSet<String>(); //Treeset which will hold the page numbers

	private String definition; //The definition for the word //Change this to a Treeset containing defitions allows multple difinitions with no chance of duplicates
	private String wordType; //Type of word, i.e noun, verb
	private Set<Integer> pages = new TreeSet<Integer>(); //Treeset which will hold the page numbers
	//Treeset is needed here as a Set does not hold duplicates, benificial if a word appears twice or more on a page
	public WordDetail(){}
	
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) { //getters and setters
		this.definition = definition;
	}

	public String getWordType() {
		return wordType;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setWordType(String wordType) {
		this.wordType = wordType;
	}
	public Set<Integer> getPages() {
		return pages;
	}
	public void setPages(Set<Integer> pages) {
		this.pages = pages;
	}
	public WordDetail(String word){
		this.word=word;
	}
	public void addIndex(int page){
		pages.add(page);
	}
	
	
	}
	