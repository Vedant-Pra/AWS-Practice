package com.ibm.Library_Management_System;

import java.util.List;
import java.util.Scanner;

import com.ibm.Models.Book;
import com.ibm.Models.Library;
import com.ibm.MyFactory.BookFactory;
import com.ibm.MyFactory.LibraryFactory;
import com.ibm.Services.BookService;
import com.ibm.Services.BookServiceImplementation;
import com.ibm.Services.LIbraryServiceImplementation;
import com.ibm.Services.LibraryServisec;

public class App 
{
	private static Scanner sc;
	private static LibraryFactory libraryFactory;
	private static BookFactory bookFactory;
	private static LibraryServisec libraryService;
	private static BookService bookService;
	static {
		sc=new Scanner(System.in);
		libraryFactory = new LibraryFactory();
		libraryService = new LIbraryServiceImplementation();
		bookService = new BookServiceImplementation();
		bookFactory = new BookFactory();
	}
    public static void main( String[] args )
    {	
    	
    	int choice=0;
        do {
        	System.out.println("0. Exit\n1. Enter Library\n2. Get all Library\n3. Find Library by ID\n4. Update Library\n5. Delete Library\n6. Insert Book\n7. Get all Books\n8. Find book by ID\n9. Update Book\n10.Delete Book");
        	System.out.println("Enter your choice");
        	choice=sc.nextInt();
        	switch(choice) {
        	case 0:{
        		System.out.println("Exiting app");
        		break;
        	}
        	case 1:{
        		Library library = libraryFactory.createLibraryObject();
        		System.out.println(library);
        		libraryService.insertLibrary(library);
        		System.out.println("Reached here");
        		break;
        	}
        	case 2:{
        		List<Library> libraryList = libraryService.getAllLibrary();
        		for(Library l:libraryList)
        			System.out.println(l);
        		break;
        	}
        	case 3:{
        		String libraryId;
        		System.out.println("Enter Library Id");
        		libraryId=sc.next();
        		Library lb=libraryService.findLibraryById(libraryId);
        		if(lb==null)
        			System.out.println("Library not found");
        		else {
        			System.out.println("Library found\n" + lb.toString());
        		}
        		break;
        	}
        	case 4:{
        		String libraryId;
        		System.out.println("Enter Library Id");
        		libraryId=sc.next();
        		Library lb=libraryService.findLibraryById(libraryId);
        		if(lb==null) {
        			System.out.println("Library not found");
        		}
        		else {
	        		String libraryName;
	        		System.out.println("Enter Library Name");
	        		libraryName=sc.next();
	        		lb.setLibraryName(libraryName);
	        		libraryService.updateLibrary(lb);
        		}
        		break;
        	}
        	case 5:{
        		String libraryId;
        		System.out.println("Enter Library Id");
        		libraryId=sc.next();
        		libraryService.deleteLibrary(libraryId);
        		break;
        	}
        	case 6:{
        		
        		String libraryId;
        		System.out.println("Enter Library Id with which the book is associated");
        		libraryId = sc.next();
        			Book book= bookFactory.createBookObject();
        			bookService.insertBook(book,libraryId);
        		break;
        	}
        	case 7:{
        		List<Book> bookList=bookService.getAllBooks();
        		for(Book b:bookList)
        			System.out.println(b);
        		break;
        	}
        	case 8:{
        		String bookId;
        		System.out.println("Enter Book Id");
        		bookId=sc.next();
        		Book b=bookService.findBookById(bookId);
        		if(b==null)
        			System.out.println("Book not found");
        		else {
        			System.out.println("Book found\n" + b.toString());
        		}
        		break;
        	}
        	case 9:{
        		String bookId;
        		System.out.println("Enter Book Id");
        		bookId=sc.next();
        		Book b=bookService.findBookById(bookId);
        		if(b==null) {
        			System.out.println("Book not found");
        		}
        		else {
	        		String bookName;
	        		System.out.println("Enter Book Name");
	        		bookName=sc.next();
	        		b.setBookName(bookName);
	        		String bookAuthor;
	        		System.out.println("Enter Book Author");
	        		bookAuthor=sc.next();
	        		b.setAuthor(bookAuthor);
	        		String genre;
	        		System.out.println("Enter Book genre");
	        		genre=sc.next();
	        		b.setGenre(genre);
        		}
        		break;
        	}
        	case 10:{
        		String bookId;
        		System.out.println("Enter Book Id");
        		bookId=sc.next();
        		bookService.deleteBook(bookId);
        		break;
        	}
        	default:{
        		System.out.println("Wrong Choice!!!");
        		break;
        	}
        	}
        	
        }while(choice!=0);
    }
}
