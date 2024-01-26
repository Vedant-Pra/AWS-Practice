package com.ibm.Repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.Models.Book;
import com.ibm.Models.Library;
import com.ibm.MyFactory.MySessionFactory;

public class BookRepositoryImplementation implements BookRepository{
	private static SessionFactory sessionFactory;
	private static LibraryRepository libraryRepository;
	List<Book> bookList;
	static {
		try {
			sessionFactory = MySessionFactory.getSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		libraryRepository = new LibrartrepositoryImplenmentation();
	}
	@Override
//	public Book insertBook(Book book, Library library) {
		// TODO Auto-generated method stub
//		book.setLibrary(library);
//		Session session = sessionFactory.openSession();
//		session.getTransaction().begin();
//		library.getBooks().add(book);
//		session.persist(book);
//		session.persist(library);
//		session.getTransaction().commit();
//		libraryRepository.updateLibrary(library);
//		System.out.println("Book added");
//		return book;
		
		
//	}
	
	public Book insertBook(Book book, String libraryId) {
        // Create a SessionFactory using hibernate.cfg.xml
        // Open a new session
        Session session = sessionFactory.openSession();

        // Start a transaction
//        Transaction transaction = session.beginTransaction();
        session.getTransaction().begin();
        // Fetch the Library entity from the database
        Library library = session.get(Library.class, libraryId);

        // If the Library entity exists, associate it with the Book entity
        if (library != null) {
            book.setLibrary(library);
            // Save the Book entity to the database
            session.save(book);
        } else {
            System.out.println("Library with id " + libraryId + " does not exist.");
        }

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
        return book;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		TypedQuery<Book> typedquery=session.createQuery("from Book b", Book.class);
		bookList=typedquery.getResultList();
		return bookList;
	}

	@Override
	public Book findBookById(String bookId) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		Book book=session.find(Book.class, bookId);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(book);
		session.getTransaction().commit();
		System.out.println("Book updated");
		return book;
	}

	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		Book book=findBookById(bookId);
		if(book==null)
			System.out.println("Book not found");
		else {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(book);
			System.out.println("Book deleted");
		}
	}

}
