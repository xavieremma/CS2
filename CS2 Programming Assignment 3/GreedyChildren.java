/* Xavier Emma
 * Dr. Steinberg
 * COP3503 Fall 2024
 * Programming Assignment 3
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// Class definition + attributes
public class GreedyChildren {
    private int[] greedyFactors;
    private int[] sweetFactors;
    private int happyChildren;
    private int angryChildren;

    // Constructor
    public GreedyChildren(int numCandyPieces, int numChildren, String greedyFile, String candyFile) {
        greedyFactors = new int[numChildren];
        sweetFactors = new int[numCandyPieces];
        happyChildren = 0;
        angryChildren = 0;

        // read method ton aquire data from the specific text files
        read(greedyFile, greedyFactors);
        read(candyFile, sweetFactors);
    }

    public void read(String fileName, int[] array) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;

            while ((line = reader.readLine()) != null && i < array.length) {
                array[i] = Integer.parseInt(line);
                i++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Solution using the greedy algorithm
    public void greedyCandy() {
        Arrays.sort(greedyFactors);
        Arrays.sort(sweetFactors);

        int gIndex = 0;
        int sIndex = 0;

        while (gIndex < greedyFactors.length && sIndex < sweetFactors.length) {
            if (sweetFactors[sIndex] >= greedyFactors[gIndex]) {
                happyChildren++;
                gIndex++;
            }
            sIndex++;
        }

        angryChildren = greedyFactors.length - happyChildren;
    }

    // Results :D
    public void display() {
        System.out.println("There are " + happyChildren + " happy children.");
        System.out.println("There are " + angryChildren + " angry children.");
    }


}