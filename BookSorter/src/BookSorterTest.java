import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This will run your custom JUnit tests and the tests provided for this
 * homework assignment. The tests provided focus on the comparators provided
 * by your Books helper class.
 */

@RunWith(Suite.class)
@SuiteClasses({
    BookTest.class,
    BookSorterTest.ComparatorTest.class
})
public class BookSorterTest {

    public static class ComparatorTest {
        @Test
        public void testDefaultSort() {
            List<Book> actual = new ArrayList<>();
            List<Book> expect = new ArrayList<>();

            Collections.addAll(actual, Books.JOSHI2008, Books.BUCKWALTER1999,
                    Books.PARR2013, Books.MURRAY2013);

            Collections.addAll(expect, Books.BUCKWALTER1999, Books.MURRAY2013,
                    Books.PARR2013, Books.JOSHI2008);

            Collections.sort(actual);
            prettyEquals(expect, actual);
        }

        @Test
        public void testAuthorSort() {
            List<Book> actual = new ArrayList<>();
            List<Book> expect = new ArrayList<>();

            Collections.addAll(actual, Books.WOLBER2014, Books.WOLBER2011,
                    Books.GALLES2004, Books.BUCKWALTER1999);

            Collections.addAll(expect, Books.BUCKWALTER1999, Books.GALLES2004,
                    Books.WOLBER2014, Books.WOLBER2011);

            Collections.sort(actual, Books.ORDER_BY_AUTHOR);
            prettyEquals(expect, actual);
        }

        @Test
        public void testTitleSort() {
            List<Book> actual = new ArrayList<>();
            List<Book> expect = new ArrayList<>();

            Collections.addAll(actual, Books.PARR2013, Books.PARR2010,
                    Books.PACHECO1996, Books.PACHECO2011);

            Collections.addAll(expect, Books.PACHECO2011, Books.PARR2010,
                    Books.PACHECO1996, Books.PARR2013);

            Collections.sort(actual, Books.ORDER_BY_TITLE);
            prettyEquals(expect, actual);
        }

        @Test
        public void testPageSort() {
            List<Book> actual = new ArrayList<>();
            List<Book> expect = new ArrayList<>();

            Collections.addAll(actual, Books.PACHECO1996, Books.JOSHI2008,
                    Books.MURRAY2013, Books.WOLBER2011);

            Collections.addAll(expect, Books.JOSHI2008, Books.MURRAY2013,
                    Books.WOLBER2011, Books.PACHECO1996);

            Collections.sort(actual, Books.ORDER_BY_PAGES);
            prettyEquals(expect, actual);
        }

        @Test
        public void testYearSort() {
            List<Book> actual = new ArrayList<>();
            List<Book> expect = new ArrayList<>();

            Collections.addAll(actual, Books.MURRAY2013, Books.PACHECO2011,
                    Books.PARR2013, Books.WOLBER2011);

            Collections.addAll(expect, Books.PACHECO2011, Books.WOLBER2011,
                    Books.MURRAY2013, Books.PARR2013);

            Collections.sort(actual, Books.ORDER_BY_YEAR);
            prettyEquals(expect, actual);
        }

        /**
         * Returns a list of books as a newline-delimited String. Useful for debugging.
         *
         * @param books
         * @return
         */
        public static String bookStream(List<Book> books) {
            return books.stream().map(book -> book.toString()).collect(Collectors.joining("\n"));
        }

        /**
         * Helper class to call {@link Assert#assertTrue(String, boolean)} with
         * useful debug output.
         *
         * @param expect
         * @param actual
         */
        public static void prettyEquals(List<Book> expect, List<Book> actual) {
            String output = String.format("%nExpected:%n%s%n%nActual:%n%s%n%n",
                    bookStream(expect), bookStream(actual));

            Assert.assertTrue(output, expect.equals(actual));
        }
    }
}
