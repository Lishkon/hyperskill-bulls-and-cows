package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        generateCode(scanner.nextInt());

    }


    /**
     * Generates a random code of a given length with unique numbers
     * @param length
     * @return String
     */
    public static void generateCode(int length) {
        Long randomNumber = System.nanoTime();
        String numToString = String.valueOf(randomNumber);
        StringBuilder result = new StringBuilder();

        if (length <= 10) {
            for (int i = numToString.length() - 1; i > 0; i--) {
                if (result.length()<length) {
                    if (result.length() == 0) {
                        if (!(numToString.charAt(i) == '0')) {
                            result.append(numToString.charAt(i));
                        }
                    } else if (!isUniqueChar(numToString.charAt(i), result.toString())) {
                        result.append(numToString.charAt(i));
                    }
                }
            }
            System.out.println("The random secret number is " + result.toString());
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", length);
        }

    }

    private static boolean isUniqueChar(char ch, String token) {
        if (token.isEmpty()) {
            return false;
        } else {
            return token.contains(String.valueOf(ch));
        }
    }

    private String gradeProcessor(String code, String answer) {
        int bullCounter = 0;
        int cowCounter = 0;
        String result = "None";

        // Arranging the codeArray
        int[] codeArray = new int[code.length()];
        for (int i = 0; i < code.length(); i++) {
            codeArray[i] = Character.getNumericValue(code.charAt(i));
        }

        // Arranging the cowArray
        int[] answerArray = new int[code.length()];
        for (int i = 0; i < code.length(); i++) {
            answerArray[i] = Character.getNumericValue(answer.charAt(i));
        }

        // Counting the bulls and cows
        if (code.equals(answer)) {
            bullCounter = 4;
        } else {
            for (int i = 0; i < answerArray.length; i++) {
                for (int j = 0; j < codeArray.length; j++) {
                    if (answerArray[i] == codeArray[j] && i==j) {
                        bullCounter++;
                    } else if (answerArray[i] == codeArray[j]) {
                        cowCounter++;
                    }
                }
            }
        }

        if (bullCounter != 0 && cowCounter == 0) {
            result = bullCounter + " bull(s)";
        } else if (bullCounter == 0 && cowCounter != 0) {
            result = cowCounter + " cow(s)";
        } else if (bullCounter != 0 && cowCounter != 0) {
            result = bullCounter + " bull(s) and " + cowCounter + " cow(s)";
        }

        return result;
    }
}
