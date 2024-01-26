package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Library;
import com.ibm.Repository.LibrartrepositoryImplenmentation;
import com.ibm.Repository.LibraryRepository;

public class LIbraryServiceImplementation implements LibraryServisec{
	private static LibraryRepository libraryRepo;
	static {
		libraryRepo = new LibrartrepositoryImplenmentation();
	}
	@Override
	public Library insertLibrary(Library library) {
		// TODO Auto-generated method stub
		return libraryRepo.insertLibrary(library);
	}

	@Override
	public List<Library> getAllLibrary() {
		// TODO Auto-generated method stub
		return libraryRepo.getAllLibrary();
	}

	@Override
	public Library findLibraryById(String libraryId) {
		// TODO Auto-generated method stub
		return libraryRepo.findLibraryById(libraryId);
	}

	@Override
	public Library updateLibrary(Library library) {
		// TODO Auto-generated method stub
		return libraryRepo.updateLibrary(library);
	}

	@Override
	public void deleteLibrary(String libraryId) {
		// TODO Auto-generated method stub
		libraryRepo.deleteLibrary(libraryId);
		
	}

}
