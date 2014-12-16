package eu.devexpert.odesk.shifter;

import eu.devexpert.odesk.shifter.categories.AcceptanceTest;
import eu.devexpert.odesk.shifter.exception.InvalidStepsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by ro1v02c1 on 16.12.2014.
 */
@Category(AcceptanceTest.class)
public class ShifterTest {

    /**
     * For the same array we will check if the rotation is correct,
     */
    @Test
    public void check16() {
        Shifter shifter = new Shifter(new int[]{1, 2, 3, 4, 5, 6});

        Assert.assertArrayEquals(shifter.rotate(2), new int[]{5, 6, 1, 2, 3, 4});
        Assert.assertArrayEquals(shifter.rotate(3), new int[]{4, 5, 6, 1, 2, 3});
        Assert.assertArrayEquals(shifter.rotate(4), new int[]{3, 4, 5, 6, 1, 2});
        Assert.assertArrayEquals(shifter.rotate(27), new int[]{4, 5, 6, 1, 2, 3});
    }

    /**
     * Test will fail if the N number is negative
     */
    @Test(expected = InvalidStepsException.class)
    public void checkFailNegative() {
        Shifter shifter = new Shifter(new int[]{1, 2, 3, 4, 5, 6});
        shifter.rotate(-2);
    }

    /**
     * If the step number iz zero , the output array should be identical with the original one
     */
    @Test
    public void checkZeroSteps() {
        int[] notRotated = new int[]{1, 2, 3, 4, 5, 6};
        Shifter shifter = new Shifter(notRotated);
        Assert.assertArrayEquals(shifter.rotate(0), notRotated);
    }
}
