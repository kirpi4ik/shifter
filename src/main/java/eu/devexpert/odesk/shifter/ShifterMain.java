package eu.devexpert.odesk.shifter;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main console based class, should be invoked from the commandline :<br/>
 * <code>java -jar shifter-1.0-SNAPSHOT.jar</code>
 * Created by Dumitru Ciubenco on 16.12.2014.
 */
public class ShifterMain {

    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            try {

                int length = Integer.parseInt(console.readLine("Please enter the length of the array:"));
                int[] shiftArray = new int[length];
                for (int i = 0; i < length; i++) {
                    try {
                        shiftArray[i] = Integer.parseInt(console.readLine("a[" + i + "]="));
                    } catch (NumberFormatException nfe) {
                        console.printf("Array accepts only integers");
                        return;
                    }
                }
                try {
                    int n = Integer.parseInt(console.readLine("Please enter the N(number of position to move):"));
                    if (n > 0) {
                        Shifter s = new Shifter(shiftArray);
                        int[] rotated = s.rotate(n);
                        console.printf("Shifted array = [");
                        for (int item : rotated) {
                            console.printf(String.valueOf(item));
                        }
                        console.printf("]");
                    } else {
                        console.printf("Number of positions N should be integer an greater than 0");
                        return;
                    }
                } catch (NumberFormatException nfe) {
                    console.printf("Number of positions N should be integer an greater than 0");
                    return;
                }


            } catch (NumberFormatException | NegativeArraySizeException ex) {
                console.printf("Invalid length, it should be positive integer");
                return;
            }
        } else {
            throw new RuntimeException("Please run this application with console");
        }
    }
}
