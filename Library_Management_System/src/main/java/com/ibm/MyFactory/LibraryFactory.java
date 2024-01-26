package com.ibm.MyFactory;

import java.util.Scanner;
import java.util.UUID;

import com.ibm.Models.Library;

public class LibraryFactory {
	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public Library createLibraryObject() {
		Library library = new Library();
		String libraryId=UUID.randomUUID().toString().split("-")[0];
		library.setLibraryId(libraryId);
		String libraryName;
		System.out.println("Enter Library Name");
		libraryName=sc.next();
		library.setLibraryName(libraryName);
		return library;
	}
}
