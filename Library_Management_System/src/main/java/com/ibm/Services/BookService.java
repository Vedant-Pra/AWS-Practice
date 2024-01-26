package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Book;
import com.ibm.Models.Library;

public interface BookService {
	Book insertBook(Book book, String libraryId);
	List<Book> getAllBooks();
	Book findBookById(String bookId);
	Book updateBook(Book book);
	void deleteBook(String bookId);
}
