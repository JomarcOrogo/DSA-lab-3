import java.util.Scanner;

public class FactorialCalculator {
    //Jomarc Orogo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jomarc Orogo");
        System.out.println("Welcome to the Factorial Calculator!");
        System.out.print("Enter a non-negative integer: ");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            // Calculate factorial iteratively
            long startIterative = System.nanoTime();
            long iterativeResult = factorialIterative(num);
            long endIterative = System.nanoTime();
            long iterativeTime = endIterative - startIterative;

            // Calculate factorial recursively
            long startRecursive = System.nanoTime();
            long recursiveResult = 0;
            recursiveResult = factorialRecursive(num);
            long endRecursive = System.nanoTime();
            long recursiveTime = endRecursive - startRecursive;

            // Output results
            System.out.println("\nResults:");
            System.out.println("Iterative Factorial: " + iterativeResult + " (Time: " + iterativeTime + " ns)");
            System.out.println("Recursive Factorial: " + recursiveResult + " (Time: " + recursiveTime + " ns)");

            // Analysis
            System.out.println("\nAnalysis:");
            if (iterativeTime < recursiveTime) {
                System.out.println("The iterative method was faster.");
            } else {
                System.out.println("The recursive method was faster.");
            }
        }
        scanner.close();
    }

    // Iterative method for factorial
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive method for factorial
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }
}