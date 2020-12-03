import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        byte[] inputArray = input.getBytes();
        byte[] result = new byte[inputArray.length];

        for (int i = 0; i < inputArray.length; i++)
            result[i] = inputArray[inputArray.length - i - 1];

        String output = new String(result);
        String toCompare = new String(inputArray);
        if (output.equals(toCompare)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}