package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Library;

public interface LibraryServisec {
	Library insertLibrary(Library library);
	List<Library> getAllLibrary();
	Library findLibraryById(String libraryId);
	Library updateLibrary(Library library);
	void deleteLibrary(String libraryId);
}
