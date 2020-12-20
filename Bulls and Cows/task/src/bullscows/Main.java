package bullscows;

import java.util.*;

public class Main {
    static String secretCode;
    static String result;
    static boolean gameOver;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");

        int guessLength = scanner.nextInt();
        String guessNumber;
        int count = 0;

        System.out.println("Okay, let's start a game!");

        generateCode(guessLength);

        while (true) {
            count++;
            System.out.println("Turn " + count + ":");
            guessNumber = scanner.next();
            gradeProcessor(secretCode, guessNumber);
            System.out.println(result);

            if (gameOver) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
        }
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
                secretCode = result.toString();
            }
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", length);
        }

    }

    /**
     * Checks if the char containing in the provided string is unique
     * @param ch
     * @param token
     * @return
     */
    private static boolean isUniqueChar(char ch, String token) {
        if (token.isEmpty()) {
            return false;
        } else {
            return token.contains(String.valueOf(ch));
        }
    }

    /**
     * Grade Processor method implementation. Covers all the logic for the game, related to counting the bulls and cows and printing out the result of the analysis.
     * @param code
     * @param answer
     */
    private static void gradeProcessor(String code, String answer) {
        int bullCounter = 0;
        int cowCounter = 0;
        result = "None";

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
            bullCounter = answer.length();
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

        // Creating a result string
        if (bullCounter != 0 && cowCounter == 0) {
            result = bullCounter + " bull(s)";
            if (bullCounter == answer.length()) {
                gameOver = true;
            }
        } else if (bullCounter == 0 && cowCounter != 0) {
            result = cowCounter + " cow(s)";
        } else if (bullCounter != 0 && cowCounter != 0) {
            result = bullCounter + " bull(s) and " + cowCounter + " cow(s)";
        }

    }
}
