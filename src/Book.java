/**
 * Book class for the Automation System.
 * @author gokbey_gazi_keskin
 */
public class Book extends AbstractPublication {
    private BookGenre genre;
    private String comment;

    public Book() {
        super(null, null, null, null);
        this.genre = null;
    }

    /**
     * Constructor for Book.
     * @param nm Name of the publication.
     * @param athr Information of the author.
     * @param lng Language of the Publication.
     * @param pg Page amounr of the Publication.
     * @param genre Genre of the book.
     */
    public Book(String nm, Author athr, Language lng, Integer pg,BookGenre genre) {
        super(nm, athr, lng, pg);
        this.genre = genre;
    }

    /**
     * Setter for genre.
     * @param gnr Genre of the book.
     */
    public void setGenre(BookGenre gnr){genre = gnr;}

    /**
     * Getter for genre.
     * @return Genre of the book.
     */
    public BookGenre getGenre(){return genre;}

    public String getComment()
    {
        return comment;
    }

    /**
     * Method to set comment of Book.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Returns string representation of the object.
     * @return Information of Book.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre;
    }
}
