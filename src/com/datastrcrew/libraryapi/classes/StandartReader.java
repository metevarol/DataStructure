package com.datastrcrew.libraryapi.classes;
import com.datastrcrew.libraryapi.service.Database;

import java.util.LinkedList;
import java.util.List;

/**
 * Reader of the library
 * @author Mustafa Gurler
 */
public class StandartReader extends User
{
    /**Holds the information of the library that this StandartUser is a member of*/
    String lib;
	List<Publication> borrowedBooks;

	public StandartReader() {
		super("name","surname","pw");
		lib = null;
        borrowedBooks = new LinkedList<>();
	}

    public StandartReader(String name,String surname,String pw, Library workingLib)
	{
        super(name,surname,pw);
		lib=workingLib.getID();
        borrowedBooks = new LinkedList<>();
    }



    public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

    public Library getLibrary(){
        for(Library i: Database.libraries){
            if(i.getID().equals(lib))
                return i;
        }
        return null;
    }

    public void setLibrary(Library lib){
	    this.lib = lib.getID();
    }

	public List<Publication> getBorrowed(){ return borrowedBooks; }

    /**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if it is not.
	 */
	public boolean searchBook(String searchedBook, Language bookLanguage)
	{
        return getLibrary().isInStock(searchedBook, bookLanguage);
	}

    /**
	 * borrowing the requested book if it is available in the library stocks
	 * @return true if the borrowing is successful, false if it is not.
	 */
	public boolean borrowBook(Publication borrowBook)
	{
		String book_name = borrowBook.getName();
		Language book_lan = borrowBook.getLang();
		if(searchBook(book_name,book_lan))
		{
			borrowedBooks.add(borrowBook);
			return true;
		}
		return false;
	}

    /**
	 * returning the borrowed book
	 * @return true if the returning is successful, false otherwise
	 */
	public boolean returnTheBook(Publication returningBook)
	{
		if(borrowedBooks.contains(returningBook))
		{
			borrowedBooks.remove(returningBook);
			return true;
		}
		return false;
	}

    /**
	 * leave a comment for the book
	 * @return true if the commenting is successful, false otherwise
	 */
	public boolean commentBook(Publication book , String comment)
	{
		if(isBorrowed(book.getName(), book.getLang()))
		{
			book.addComment(comment);
			return true;
		}
		return false;
	}

    /**
     * check whether the book is in the list of borrowed books
     * @return true if the book is borrowed, false otherwise
     */
    public boolean isBorrowed(String bookName, Language bookLanguage)
    {
		Publication book = new Book(bookName,null,bookLanguage,null,null);
		if(borrowedBooks.contains(book))
		{
			return true;
		}
		return false;
	}

    /**
	 * viewing the events in the library
	 * @return list of events in the library
	 */
	public List<Event> view_events()
	{
		System.out.println(getLibrary().getOfferedEvents());
		return getLibrary().getOfferedEvents();
	}

    /**
	 * voting the event
	 * @return true if the voting is successful, false if it is not.
	 */
	public boolean vote_event(int vote , Event event)
	{
		if((vote > 0) && (vote < 10))
		{
			event.addVote(vote);
			return true;
		}
		return false;
	}

    /**
	 * participating the event
	 * @return true if the participating is successful, false if it is not.
	 */
	public boolean participate_event(Event event)
	{
		if(!event.getParticipants().contains(this))
		{
			event.addParticipant(this);
			return true;
		}
		return false;
	}


	//-----------------------------------------ENTITY METHODS--------------------------

    // /**
    //  * StandartReader constructor for Database operations.
    //  * @param entity StandartReaderEntity class object.
    //  */
    // public StandartReader(StandartReaderEntity entity){
    //     super(entity.name, entity.surname, entity.password);
    //     this.lib = entity.getLib();
    //     this.borrowedBooks = getBorrowed();
    // }

	// public StandartReader(PremiumReaderEntity entity){

    //     super(entity);
    //     this.lib = entity.getLib();
    //     this.borrowedBooks = getBorrowed();
    // }

    // /**
    //  * Method to save StandartReader data field to StandartReaderEntity object.
    //  * @return StandartReaderEntity object.
    //  */

    // public StandartReaderEntity getEntity() {

    //     StandartReaderEntity entity;

    //     entity.setName(getName());
    //     entity.setSurname(getSurname());
    //     entity.setId(getID());
    //     entity.setPassword(getPW());
    //     entity.setLib(getLib().getEntity());

    //     for (Publication book : borrowedBooks)
    //       entity.borrowedBooks.add(book.getEntity());

    //     return entity;

	// }

}
