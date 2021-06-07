/**
 * Manager of the library
 * @author Mustafa Gurler
 * @author yesimyalc
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author yesimyalc
 */
public class Manager extends User
{
	Library lib;

	public Manager()
	{
		super("name","surname","pw");
		lib=null;
	}

	public Manager(String name, String surname, String pw, Library workingLib)
	{
		super(name,surname,pw);
		lib=workingLib;
	}
	/**
	 * Adds a book to the library stock
	 * @param addedBook is the book that will be added.
	 * @return the added book
	 */
	public Publication addBook(Publication addedBook)
	{
		lib.changeStock(addedBook, 1);
		return addedBook;
	}
	
	/**
	 * Removes a book from the stock of the library. 
	 * @param removedBook is the book that will be removed from the stock
	 * @return the removed book. If the book is not in the stock, returns null.
	 */
	public Publication removeBook(Publication removedBook)
	{
		if(!searchBook(removedBook.getName(), removedBook.getLang()))
			return null;
		else
		{
			lib.changeStock(removedBook, -1);
			return removedBook;
		}
	}
	
	/**
	 * Adds a librarian to the library. If the librarian already exists does not add again.
	 * @param newLibrarian is the librarian that will be added.
	 * @return true if added, false if not
	 */
	public boolean addLibrarian(Librarian newLibrarian)
	{
		if(searchLibrarian(newLibrarian.getID()))
			return false;
		else
			return lib.addLibrarian(newLibrarian);
	}
	
	/**
	 * Removes a librarian from the library. If the librarian does not exist, doesnt do anything.
	 * @param oldLibrarian is the librarian that will be removed
	 * @return the removed librarian, null if no one is removed
	 */
	public Librarian removeLibrarian(Librarian oldLibrarian)
	{
		if(!searchLibrarian(oldLibrarian.getID()))
			return null;
		else
		{
			lib.removeLibrarian(oldLibrarian);
			return oldLibrarian;
		}	
	}
	
	/**
	 * Adds a janitor to the library. If the janitor already exists does not add again.
	 * @param newJanitor is the janitor that will be added.
	 * @return true if added, false if not
	 */
	public boolean addJanitor(Janitor newJanitor)
	{
		if(searchJanitor(newJanitor.getID()))
			return false;
		else
			return lib.addJanitor(newJanitor);
	}
	
	/**
	 * Removes a janitor from the library. If the janitor does not exist, doesnt do anything.
	 * @param oldJanitor is the janitor that will be removed
	 * @return the removed janitor, null if no one is removed
	 */
	public Janitor removeJanitor(Janitor oldJanitor)
	{
		if(!searchJanitor(oldJanitor.getID()))
			return null;
		else
		{
			lib.removeJanitor(oldJanitor);
			return oldJanitor;
		}
	}
	
	/**
	 * Adds a new task to a janitor. If the janitor does not belong to the library, does nothing.
	 * @param janitorID is the janitor's ID that will have the new task
	 * @param theTask is the new task that will be added to a janitor
	 * @return true if added, false if not
	 */
	public boolean addTasks(String janitorID, Integer theTaskID)
	{
		/*
		 * Assumed that there is addTask(Task newTask) method in janitor class.
		 * This method adds the task to the janitor, returns true.
		 * If the janitor already has the task returns false.
		 * DELETE THIS LATER ON
		 */
		if(!searchJanitor(janitorID))
			return false;
		else
			return lib.getJanitor(janitorID).addTask(theTaskID);
	}
	
	/**
	 * Gets all the demands from the demandedBooks data field of library and adds them to
	 * the stock of the library. At the end demandedBooks data field must be empty and all
	 * the books must be added to the stock.
	 */
	public void arrangeBookDemands()
	{
		/*
		 * Assumed that there is a removeDemandedBook() method in Library class that removes the 
		 * book in the last index of demandedBooks list and returns the removed book. Returns null
		 * if there is no books to remove.
		 */
		//DELETE THIS LATER
		Publication demandedBook=lib.removeDemandedBook();
		while(demandedBook!=null)
		{
			lib.changeStock(demandedBook, 1);
			demandedBook=lib.removeDemandedBook();
		}
		while(demandedBook!=null);
	}
	
	/**
	 * Prints out all the past events in the library.
	 */
	public void listPastEvents()
	{
		lib.printPastEvents();
	}
	
	/**
	 * Prints out all the upcoming events in the library.
	 */
	public void listUpcomingEvents()
	{
		lib.printUpcomingEvents();
	}
	
	/**
	 * Accepts an event and adds it to upcoming event list.
	 * @param newEvent is the event that will be added to the upcoming events list.
	 * @return true if added, false if not.
	 */
	public boolean acceptEvent(Event newEvent)
	{
		/*
		 * Assumed there is a addUpcomingEvent(Event addedEvent) method in library class
		 * This method should return true after adding to upcomingEvenets data field. 
		 * It should return false if the event is already in the upcoming events list.
		 * DELETE THIS LATER ON
		 */
		return lib.addUpcomingEvent(newEvent);
	}
	
	public boolean declineEvent(Event newEvent)
	{
		return lib.removeEvent(newEvent);
	}
	
	/**
	 * Moves the first element from upcoming events to past events meaning it has ended.
	 * @param endedEvent is the event that will be moved to pastEvents
	 * @return the removed event, null if nothing is removed
	 */
	public Event endEvent()
	{
		return lib.endEvent();
	}
	
	/**
	 * Searches for a specific book in the library stock.
	 * @return true if the book is found in the stock, false if not.
	 */
	public boolean searchBook(String bookName, Language bookLanguage)
	{
		if(lib.isInStock(bookName, bookLanguage) != 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Prints out all the books with this genre in the library.
	 */
	public void searchGenre(BookGenre searchedGenre)
	{
		/*
		 * Assumed that there is a method in library that prints out all the
		 * books with the given category.
		 * Does not include the books with the same name more than once.
		 */
		lib.printGenre(searchedGenre);
	}
	
	/**
	 * Searches for a librarian
	 * @param searchedLID is the ID of the searched librarian
	 */
	public boolean searchLibrarian(String searchedLID)
	{
		if(lib.isLibrarian(searchedLID)!=-1)
			return true;
		else
			return false;
	}
	
	public boolean searchJanitor(String searchedJID)
	{
		if(lib.isJanitor(searchedJID)!=-1)
			return true;
		else
			return false;
	}
}