package com.ibm.Repository;

import java.util.List;

//import com.ibm.Models.Book;
import com.ibm.Models.Library;

public interface LibraryRepository {
	Library insertLibrary(Library library);
	List<Library> getAllLibrary();
	Library findLibraryById(String libraryId);
	Library updateLibrary(Library library);
	void deleteLibrary(String libraryId);
//	Book addBook(Book book);
//	List<Book> getAllBooksInALibrary(String libraryId); To be implemented later
//	List<Book> getAllBooksInALibraryOfAGenre(String libraryId, String genre); To be implemented later
	
	
	
}
