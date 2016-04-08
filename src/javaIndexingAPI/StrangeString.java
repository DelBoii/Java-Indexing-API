//JavaIndexingAPI - A program which parses a book and displays the page numbers that word is on and its definition, if any.
//Ryan Gordon - G00326349 - ryangordon210@gmail.com
package javaIndexingAPI;

public class StrangeString{
	private String word; //An instance variable
	
	public StrangeString(String s){ //Our constructor
		this.word = s;
	}
	
	public String getWord() { //A method to access the wrapped string
		return word;
	}

	//The hashCode method is used to determine which hash map bucket an object is in 
	//In this method we are overridding the hashcode method to get the hashcode of the word rather than its object ID
	public int hashCode() {
		return word.hashCode();
	}
	
	//The default implementation of equals() tests for the same Object ID. We are over-riding
	//this behaviour and testing that both objects share the exact same sequence of characters
	public boolean equals(Object obj) {
		if (obj instanceof StrangeString){
			StrangeString ss = (StrangeString) obj;
			return word.equals(ss.getWord());
		}else{
			return false;
		}
	}//equals method
}//end strange string