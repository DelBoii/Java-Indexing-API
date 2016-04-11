package javaIndexingAPI;

import java.util.Set;

public interface IndexingAPI {

	public Set<Integer> getPageNumbers(String parse_file, String searchTerm);
	
}
