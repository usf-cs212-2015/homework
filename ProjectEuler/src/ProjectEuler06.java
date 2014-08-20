import java.util.Scanner;

/**
 * Find the difference between the sum of the squares of the first n
 * natural numbers and the square of the sum. This is problem #6 from
 * Project Euler.
 *
 * @see <a href="http://projecteuler.net/problem=6">Project Euler #6</a>
 */
public class ProjectEuler06 {

    /**
     * Calculates the sum of squares from 1 to max (inclusive). Each integer
     * is first squared, and then added to the overall sum.
     *
     * @param max - maximum value (inclusive)
     * @return sum of squares
     */
    public static int sumSquares(int max) {
        // TODO Fill in missing code.
        return 0;
    }

    /**
     * Calculates the square of the sum from 1 to max (inclusive). Each
     * integer is first summed together, and then the result is squared.
     *
     * @param max - maximum value (inclusive)
     * @return square of the sum
     */
    public static int squareSums(int max) {
        // TODO Fill in missing code.
        return 0;
    }

    /**
     * Calculates the difference between the sum of the squares and the
     * square of the sum of the integers from 1 to max (inclusive). Uses
     * the {@link #sumSquares(int)} and {@link #squareSums(int)} methods.
     *
     * @param max - maximum value (inclusive)
     * @return
     */
    public static int solve(int max) {
        int sumSquare = sumSquares(max);
        int squareSum = squareSums(max);

        return squareSum - sumSquare;
    }

    /**
     * Prompts the user for an integer, and displays the sum of squares,
     * square of sums, and difference between them. Useful for debugging.
     *
     * @param args - unused
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter integer: ");
            int n = in.nextInt();

            System.out.printf("sumOfSquares(%d) = %d\n", n, sumSquares(n));
            System.out.printf("squareOfSums(%d) = %d\n", n, squareSums(n));
            System.out.printf("solve(%d) = %d\n", n, solve(n));
        }
        catch (Exception e) {
            System.out.println("Unable to parse integer. Please try again.");
        }
    }
}
