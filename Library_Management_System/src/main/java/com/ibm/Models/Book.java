package com.ibm.Models;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Books")
public class Book {
	@Id
	@Column(name="book_id")
	private String bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="author")
	private String author;
	@Column(name="genre")
	private String genre;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}) // Many instances of Books entity can be associated with one instance of the Library
	//not adding CascaseTpe.Delete because it is a child table and on deleting child parent entity should not be deleted
	@JoinColumn(name="library_id") //used as foreign key for the book entity
	private Library library;
}
