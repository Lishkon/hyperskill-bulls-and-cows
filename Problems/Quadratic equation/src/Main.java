import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double root = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double firstRoot = (-b + root) / (2 * a);
        double secondRoot = (-b - root) / (2 * a);
        if (firstRoot < secondRoot) {
            System.out.println(firstRoot + " " + secondRoot);
        } else {
            System.out.println(secondRoot + " " + firstRoot);
        }
    }
}
