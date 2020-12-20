import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        Random rnd = new Random();

        for (int i = k; i <= Integer.MAX_VALUE; i++) {
            rnd.setSeed(i);
            boolean correct = true;

            for (int j = 0; j < n; j++) {
                correct &= rnd.nextGaussian() <= m;
            }

            if (correct) {
                System.out.println(i);
                break;
            }
        }

    }
}