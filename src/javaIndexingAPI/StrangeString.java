package javaIndexingAPI;



public class StrangeString{
	private String word; //An instance variable
	
	public StrangeString(String s){ //Our constructor
		this.word = s;
	}
	
	public String getWord() { //An accessor method
		return word;
	}

	//The hashCode method is used to determine which hash map bucket an object is in
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
	}
}