package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Book;
import com.ibm.Models.Library;
import com.ibm.Repository.BookRepository;
import com.ibm.Repository.BookRepositoryImplementation;

public class BookServiceImplementation implements BookService {
	private static BookRepository bookService;
	static {
		bookService= new BookRepositoryImplementation();
	}
	@Override
	public Book insertBook(Book book, String libraryId) {
		// TODO Auto-generated method stub
		return bookService.insertBook(book,libraryId);
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookService.getAllBooks();
	}
	@Override
	public Book findBookById(String bookId) {
		// TODO Auto-generated method stub
		return bookService.findBookById(bookId);
	}
	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookService.updateBook(book);
	}
	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		bookService.deleteBook(bookId);
	}
	
}
