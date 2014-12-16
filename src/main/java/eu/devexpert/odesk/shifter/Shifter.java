package eu.devexpert.odesk.shifter;

import eu.devexpert.odesk.shifter.exception.InvalidStepsException;

/**
 * Shifter class, which receives an array of integers on the construction and is able to reorder this array with variable number of positions to the right
 * <code>
 * Shifter shifter = new Shifter(new int[]{1, 2, 3, 4, 5, 6});
 * shifter.rotate(2);// will return {5, 6, 1, 2, 3, 4}
 * </code>
 *
 * @author Dumitru Ciubenco
 *         Created on 16.12.2014.
 * @since 1.0
 */
public class Shifter {
    private final int[] numbers;

    /**
     * Unique constructor which accepts only array of int
     *
     * @param numbers - array of int which can be rotated
     */
    public Shifter(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * This method will use input parameter(N) in order to rotate to the right this array.
     *
     * @param n - positive number of positions used on rotation
     * @return int array rotated by N positions
     */
    public int[] rotate(int n) {
        if (n > 0) {
            int[] rotated = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                rotated[((n + i) % numbers.length)] = numbers[i];
            }
            return rotated;
        } else if (n == 0) {
            //return the original array if the N is zero
            return numbers;
        } else {
            throw new InvalidStepsException("The number of steps should be positive");
        }
    }
}
