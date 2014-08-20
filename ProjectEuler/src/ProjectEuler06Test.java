import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link ProjectEuler06} for correctness.
 *
 * @see ProjectEuler06
 */
public class ProjectEuler06Test {

    @Test
    public void testSumSquares10() {
        int max = 10;
        int expect = 385;
        int actual = ProjectEuler06.sumSquares(max);

        String debug = String.format("%nsumSquares(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);

    }

    @Test
    public void testSquareSums10() {
        int max = 10;
        int expect = 3025;
        int actual = ProjectEuler06.squareSums(max);

        String debug = String.format("%nsquareSums(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testSolve10() {
        int max = 10;
        int expect = 2640;
        int actual = ProjectEuler06.solve(max);

        String debug = String.format("%nsolve(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testSumSquares100() {
        int max = 100;
        int expect = 338350;
        int actual = ProjectEuler06.sumSquares(max);

        String debug = String.format("%nsumSquares(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testSquareSums100() {
        int max = 100;
        int expect = 25502500;
        int actual = ProjectEuler06.squareSums(max);

        String debug = String.format("%nsquareSums(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testSolve100() {
        int max = 100;
        int expect = 25164150;
        int actual = ProjectEuler06.solve(max);

        String debug = String.format("%nsolve(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testSolve42() {
        int max = 42;
        int expect = 789824;
        int actual = ProjectEuler06.solve(max);

        String debug = String.format("%nsolve(%d) = %d (expected %d)%n",
                max, actual, expect);

        Assert.assertEquals(debug, expect, actual);
    }

    @Test
    public void testFuzzy() {
        Random random = new Random(System.currentTimeMillis());

        int max = random.nextInt(100);
        int sumSquares = ProjectEuler06.sumSquares(max);
        int squareSums = ProjectEuler06.squareSums(max);

        String debug = String.format(
                "%nsumSquares(%d) = %d" +
                "%nsquareSums(%d) = %d" +
                "%n(expected %d <= %d)%n",
                max, sumSquares,
                max, squareSums,
                sumSquares, squareSums);

        Assert.assertTrue(debug, sumSquares <= squareSums);
    }
}
