import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A custom class for storing basic book information. This class is not suitable
 * for use in a set or to use a Book object as a key in a map, since it is a
 * mutable class.
 *
 * @see Comparable
 */
public class Book implements Comparable<Book> {

    /** Title of the book, without quotation marks. */
    private String title;

    /** ISBN number of the book. */
    private String isbn;

    /** Year book was published. */
    private int year;

    /** Number of pages in the book. */
    private int pages;

    /** Authors of the book. */
    private final List<Author> authors;

    /**
     * Initializes an empty book object with no authors.
     */
    public Book() {
        this.authors = new ArrayList<>();
    }

    /**
     * Initializes a book object with a single author.
     *
     * @param title
     * @param isbn
     * @param onlyAuthor
     * @param year
     * @param pages
     */
    public Book(String title, String isbn, Author onlyAuthor, int year, int pages) {
        this(title, isbn, new Author[] {onlyAuthor}, year, pages);
    }

    /**
     * Initializes a book object with multiple authors.
     *
     * @param title
     * @param isbn
     * @param authors
     * @param year
     * @param pages
     */
    public Book(String title, String isbn, Author[] authors, int year, int pages) {
        this();

        setTitle(title);
        setISBN(isbn);
        setYear(year);
        setPages(pages);

        Collections.addAll(this.authors, authors);
    }

    /**
     * Sets the title if it is non-null and non-empty.
     *
     * @param title
     * @return true if the title was set
     */
    public boolean setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }

        this.title = title;
        return true;
    }

    /**
     * Sets the ISBN if it is non-null and non-empty.
     *
     * @param isbn
     * @return true if the isbn was set
     */
    public boolean setISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return false;
        }

        this.isbn = isbn;
        return true;
    }

    /**
     * Sets the year if it is a 4 digit number.
     *
     * @param year
     * @return true if the year was set
     */
    public boolean setYear(int year) {
        if (year < 1000 || year > 9999) {
            return false;
        }

        this.year = year;
        return true;
    }

    /**
     * Sets the pages if it is a non-negative value.
     *
     * @param pages
     * @return true if the pages was set
     */
    public boolean setPages(int pages) {
        if (pages < 0) {
            return false;
        }

        this.pages = pages;
        return true;
    }

    /**
     * Resets the author list to the one provided if it is non-empty.
     *
     * @param authors
     * @return true if the author list was set
     */
    public boolean setAuthors(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            return false;
        }

        this.authors.clear();
        this.authors.addAll(authors);
        return false;
    }

    /**
     * Adds an author to the end of the author list if it non-null and non-empty.
     * Does not make sure it is a non-duplicate name!
     *
     * @param author
     * @return true if the author was added
     */
    public boolean addAuthor(Author author) {
        if (author == null || author.toString().trim().isEmpty()) {
            return false;
        }

        this.authors.add(author);
        return true;
    }

    /**
     * Adds all authors in the order provided.
     *
     * @param authors
     * @return true if the authors were added
     */
    public boolean addAuthors(Author[] authors) {
        if (authors == null || authors.length == 0) {
            return false;
        }

        return Collections.addAll(this.authors, authors);
    }

    /**
     * Returns the book title.
     *
     * @return book title
     */
    public String getTitle() {
        return this.title;
    };

    /**
     * Returns the book ISBN.
     *
     * @return book ISBN
     */
    public String getISBN() {
        return this.isbn;
    };

    /**
     * Returns the year published.
     *
     * @return year published
     */
    public int getYear() {
        return this.year;
    };

    /**
     * Returns the number of pages.
     *
     * @return number of pages
     */
    public int numPages() {
        return this.pages;
    };

    /**
     * Returns the number of authors.
     *
     * @return number of authors
     */
    public int numAuthors() {
        return this.authors.size();
    }

    /**
     * Returns the first author of the book. The author values are not mutable,
     * so this reference is safe to return.
     *
     * @return first author
     */
    public Author getFirstAuthor() {
        if (this.authors.isEmpty()) {
            return null;
        }

        return this.authors.get(0);
    };

    /**
     * Returns book authors as a single String.
     * @return a comma-separated String of author names
     */
    public String getAuthorText() {
        // This uses Java 8 streams and lambda expressions. Check it out if you
        // are interested, otherwise just consider it ::waves hands:: magic.
        return authors.stream()
                .map(author -> author.toString())
                .collect(Collectors.joining(", "));
    };

    @Override
    public String toString() {
        return String.format("\"%s\" by %s, %d pages, %04d, ISBN: %s",
                getTitle(),
                getAuthorText(),
                numPages(),
                getYear(),
                getISBN()
        );
    }

    @Override
    public int compareTo(Book other) {
        return this.getISBN().compareTo(other.getISBN());
    }

    /** Inner class for storing comparable authors. */
    public static class Author implements Comparable<Author> {
        /** Author first name. */
        private final String firstName;

        /** Author last name. */
        private final String lastName;

        /** Initialize an author. */
        public Author(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }

        @Override
        public int compareTo(Author other) {
            // if last names are equal, use first names
            if (this.lastName.equals(other.lastName)) {
                return this.firstName.compareTo(other.firstName);
            }

            // otherwise, compare by last name
            return this.lastName.compareTo(other.lastName);
        }

        /** Helper method for conveniently creating authors. */
        public static Author get(String firstName, String lastName) {
            return new Author(firstName, lastName);
        }
    }
}
