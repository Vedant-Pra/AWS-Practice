package com.ibm.MyFactory;

import java.util.Scanner;
import java.util.UUID;

import com.ibm.Models.Book;

public class BookFactory {
	private static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public Book createBookObject() {
		String bookId = UUID.randomUUID().toString().split("-")[0];
		Book book=new Book();
		book.setBookId(bookId);
		String bookName;
		System.out.println("Enter Book Name");
		bookName = sc.next();
		book.setBookName(bookName);
		String author;
		System.out.println("Enter Author name");
		author = sc.next();
		book.setAuthor(author);
		return book;
	}
}
