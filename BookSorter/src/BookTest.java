import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class BookTest {

    /**
     * Simple test cases for setting valid values.
     * Each operation should return true if it worked.
     */
    public static class SimpleValidTest {

        private Book book;

        @Before
        public void setup() {
            // Do not modify. Start with an empty book for each test.
            book = new Book();
        }

        /**
         * Test setting a simple valid title.
         *
         * @see Book#setTitle(String)
         */
        @Test
        public void testValidTitle() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple valid ISBN.
         *
         * @see Book#setISBN(String)
         */
        @Test
        public void testValidISBN() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple valid year.
         *
         * @see Book#setYear(int)
         */
        @Test
        public void testValidYear() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple valid number of pages.
         *
         * @see Book#setPages(int)
         */
        @Test
        public void testValidPages() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple valid author.
         *
         * @see Book#addAuthor(Book.Author)
         */
        @Test
        public void testValidAuthor() {
            // This test is given for you as an example.
            Book.Author test = new Book.Author("Alan", "Turing");
            boolean actual = book.addAuthor(test);
            Assert.assertTrue(actual);
        }
    }

    /**
     * Simple test cases for setting invalid values.
     * Each operation should return false.
     */
    public static class SimpleInvalidTest {
        private Book book;

        @Before
        public void setup() {
            // Do not modify. Start with an empty book for each test.
            book = new Book();
        }

        /**
         * Test setting a simple invalid title.
         *
         * @see Book#setTitle(String)
         */
        @Test
        public void testInvalidTitle() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple invalid ISBN.
         *
         * @see Book#setISBN(String)
         */
        @Test
        public void testInvalidISBN() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple invalid year.
         *
         * @see Book#setYear(int)
         */
        @Test
        public void testInvalidYear() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple invalid number of pages.
         *
         * @see Book#setPages(int)
         */
        @Test
        public void testInvalidPages() {
            // TODO Replace with an actual unit test.
            Assert.fail("You must write this test.");
        }

        /**
         * Test setting a simple invalid author.
         *
         * @see Book#addAuthor(Book.Author)
         */
        @Test
        public void testInvalidAuthor() {
            // This test is given for you as an example.
            Book.Author test = null;
            boolean actual = book.addAuthor(test);
            Assert.assertFalse(actual);
        }
    }

}
