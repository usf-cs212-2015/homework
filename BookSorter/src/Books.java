import java.util.Comparator;

/**
 * This class consists exclusively of static methods that operate on or return
 * on {@link Book} objects.
 */
public class Books {

    /**
     * A {@link Comparator} that compares by first author. If the first authors
     * are equal, compares by year. If the years are equal, compares by ISBN.
     *
     * @see Book#compareTo(Book)
     * @see String#compareTo(String)
     * @see Integer#compare(int, int)
     */
    // TODO Replace null with a custom comparator. (Create an anonymous inner class.)
    public static final Comparator<Book> ORDER_BY_AUTHOR = null; 

    /**
     * A {@link Comparator} that compares by book title. If the titles are equal,
     * compares by ISBN.
     *
     * @see String#compareTo(String)
     * @see Book#compareTo(Book)
     */
    // TODO Replace null with a custom comparator. (Create an anonymous inner class.)
    public static final Comparator<Book> ORDER_BY_TITLE = null;

    /**
     * A {@link Comparator} that compares by number of pages. If the pages are
     * equal, compares by ISBN.
     *
     * @see Integer#compare(int, int)
     * @see String#compareTo(String)
     */
    // TODO Replace null with a custom comparator. (Create an anonymous inner class.)
    public static final Comparator<Book> ORDER_BY_PAGES = null;

    /**
     * A {@link Comparator} that compares by year. If the years are equal,
     * compares by ISBN.
     *
     * @see Integer#compare(int, int)
     * @see String#compareTo(String)
     */
    // TODO Replace null with a custom comparator. (Create an anonymous inner class.)
    public static final Comparator<Book> ORDER_BY_YEAR = null;

    /**
     * Example book by Professor Buckwalter.
     */
    public static final Book BUCKWALTER1999 = new Book(
            "Frame Relay: Technology and Practice",
            "078-5342485240",
            Book.Author.get("Jeff", "Buckwalter"),
            1999,
            368
    );

    /**
     * Example book by Professor Galles.
     */
    public static final Book GALLES2004 = new Book(
            "Modern Compiler Design",
            "978-1576761052",
            Book.Author.get("David", "Galles"),
            2004,
            361
    );

    /**
     * Example book by Professor Joshi.
     */
    public static final Book JOSHI2008 = new Book(
            "Art-Inspired Techniques for Visualizing Time-Varying Data",
            "978-3639067699",
            Book.Author.get("Alark", "Joshi"),
            2008,
            228
    );

    /**
     * Example book by Professor Murray.
     */
    public static final Book MURRAY2013 = new Book(
            "Interactive Data Visualization for the Web",
            "978-1449339739",
            Book.Author.get("Scott", "Murray"),
            2013,
            272
    );

    /**
     * Example book by Professor Pacheco.
     */
    public static final Book PACHECO1996 = new Book(
            "Parallel Programming with MPI",
            "978-1558603394",
            Book.Author.get("Peter", "Pacheco"),
            1996,
            500
    );

    /**
     * Example book by Professor Pacheco.
     */
    public static final Book PACHECO2011 = new Book(
            "An Introduction to Parallel Programming",
            "978-0123742605",
            Book.Author.get("Peter", "Pacheco"),
            2011,
            392
    );

    /**
     * Example book by Professor Parr.
     */
    public static final Book PARR2010 = new Book(
            "Language Implementation Patterns",
            "978-1934356456",
            Book.Author.get("Terence", "Parr"),
            2010,
            374
    );

    /**
     * Example book by Professor Parr.
     */
    public static final Book PARR2013 = new Book(
            "The Definitive ANTLR 4 Reference",
            "978-1934356999",
            Book.Author.get("Terence", "Parr"),
            2013,
            328
    );

    /**
     * Example book by Professor Wolber.
     */
    public static final Book WOLBER2011 = new Book(
            "App Inventor: Create Your Own Android Apps",
            "978-1449397487",
            new Book.Author[] {
                   Book.Author.get("David", "Wolber"),
                   Book.Author.get("Hal", "Abelson"),
                   Book.Author.get("Ellen", "Spertus"),
                   Book.Author.get("Liz", "Looney")
            },
            2011,
            386
    );

    /**
     * Example book by Professor Wolber.
     */
    public static final Book WOLBER2014 = new Book(
            "App Inventor 2",
            "978-1491906842",
            new Book.Author[] {
                    Book.Author.get("David", "Wolber"),
                    Book.Author.get("Hal", "Abelson"),
                    Book.Author.get("Ellen", "Spertus"),
                    Book.Author.get("Liz", "Looney")
             },
            2014,
            360
    );
}
