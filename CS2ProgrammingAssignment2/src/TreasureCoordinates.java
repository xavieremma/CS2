/* Xavier Emma
   Dr. Steinberg
   COP3503 Fall 2024
   Programming Assignment 2
*/

import java.util.ArrayList;

public class TreasureCoordinates {

    // Method to determine all possible valid coordinates
    public ArrayList<String> determineCoordinates(String digits) {
        ArrayList<String> result = new ArrayList<>();

        // Strip the parentheses from the input
        digits = digits.substring(1, digits.length() - 1);

        // Try all possible splits for x and y
        for (int i = 1; i < digits.length(); i++) {
            String xPart = digits.substring(0, i);
            String yPart = digits.substring(i);

            // Generate all valid combinations for x and y
            ArrayList<String> xOptions = generateValidNumbers(xPart);
            ArrayList<String> yOptions = generateValidNumbers(yPart);

            // Combine all x and y options into coordinates
            for (String x : xOptions) {
                for (String y : yOptions) {
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }

        return result;
    }

    // Generate all valid numbers by considering decimal placements
    private ArrayList<String> generateValidNumbers(String part) {
        ArrayList<String> possibilities = new ArrayList<>();

        // Case 1: No decimal point, valid if no leading zeros (unless it's just "0")
        if (isValidInteger(part)) {
            possibilities.add(part);
        }

        // Case 2: Try placing a decimal in all possible positions
        for (int i = 1; i < part.length(); i++) {
            String left = part.substring(0, i);
            String right = part.substring(i);

            if (isValidInteger(left) && isValidDecimal(right)) {
                possibilities.add(left + "." + right);
            }
        }

        return possibilities;
    }

    // Check if a string is a valid integer (no leading zeros, except for "0")
    private boolean isValidInteger(String s) {
        return s.equals("0") || (s.charAt(0) != '0');
    }

    // Check if a decimal part is valid (no trailing zeros)
    private boolean isValidDecimal(String s) {
        return s.length() > 0 && !s.endsWith("0");
    }
}


