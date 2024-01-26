package com.ibm.Repository;

import java.util.List;

import com.ibm.Models.Book;
import com.ibm.Models.Library;

public interface BookRepository {
	Book insertBook(Book book, String libraryId);
	List<Book> getAllBooks();
	Book findBookById(String bookId);
	Book updateBook(Book book);
	void deleteBook(String bookId);
//	List<Book> getAllBooksInALibrary(String libraryId);	To be implemented later
}
