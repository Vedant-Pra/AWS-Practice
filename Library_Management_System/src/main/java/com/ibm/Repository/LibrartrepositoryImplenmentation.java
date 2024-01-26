package com.ibm.Repository;
import java.util.List;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import com.ibm.Models.Book;
import com.ibm.Models.Library;
import com.ibm.MyFactory.MySessionFactory;

public class LibrartrepositoryImplenmentation implements LibraryRepository {
	private static SessionFactory sessionfactory;
	private static List<Library> libraryList;
	static {
		try {
			sessionfactory = MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Library insertLibrary(Library library) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.openSession();
		session.getTransaction().begin();
		session.persist(library);
		session.getTransaction().commit();
		session.close();
		return library;
	}

	@Override
	public List<Library> getAllLibrary() {
		// TODO Auto-generated method stub
		Session session= sessionfactory.openSession();
		TypedQuery<Library> typedQuery = session.createQuery("from Library l", Library.class);
		libraryList=typedQuery.getResultList();
		session.close();
		return libraryList;
	}

	@Override
	public Library findLibraryById(String libraryId) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		Library  library = session.find(Library.class, libraryId);
		session.close();
		return library;
	}

	@Override
	public Library updateLibrary(Library library) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		session.merge(library);
		session.getTransaction().commit();
		System.out.println("Library Updated");
		session.close();
		return library;
	}

	@Override
	public void deleteLibrary(String libraryId) {
		// TODO Auto-generated method stub
		Library library=findLibraryById(libraryId);
		if(library==null)
			System.out.println("Library not found");
		else {
			Session session = sessionfactory.openSession();
			session.getTransaction().begin();
			session.delete(library);
			session.getTransaction().commit();
			System.out.println("Library Deleted.");
			session.close();
		}
	}

}
