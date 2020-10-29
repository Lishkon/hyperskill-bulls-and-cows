package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String code = generateCode();
        String answer = "";
        String grade = "";

        int attepmptCounter = 0;
        boolean stop = false;
        Main main = new Main();

        // Prompt the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("The secret code is prepared: ****.");

        while (!stop) {
            attepmptCounter++;

            System.out.print("Turn " + attepmptCounter + ". Answer: ");
            answer = scanner.nextLine();
            grade = main.gradeProcessor(code, answer);

            if (grade.equals("4 bull(s)")) {
                System.out.println("Congrats! The secret code is: " + code);
                stop = true;
            } else {
                System.out.println("Grade: " + grade + ". The secret code is " + code);
            }
        }

    }

    public static String generateCode() {
        Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
        Collections.shuffle(Arrays.asList(arr));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

    public String gradeProcessor(String code, String answer) {
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
