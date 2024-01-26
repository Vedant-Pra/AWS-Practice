package com.ibm.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
@Entity
@Table(name="library")
public class Library {
	@Id
	@Column(name="library_id")
	private String libraryId;
	
	@Column(name="library_name")
	private String libraryName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "library")
	private List<Book> books;
	
	public Library() {
		super();
	}
	
}
