import java.util.Scanner;

public class FibonacciSeries {
    // Jomarc Orogo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jomarc Orogo");
        System.out.println("Welcome to the Fibonacci Series Generator!");
        System.out.print("Enter the Fibonacci terms to generate: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a valid value for N (N >= 1).");
        } else {
            System.out.println("\nFibonacci series up to " + n + " terms:");
            long startIterative = System.nanoTime();
            System.out.print("Iterative: ");
            printFibonacciIterative(n);
            long endIterative = System.nanoTime();
            System.out.println("Iterative Time: " + (endIterative - startIterative) + " ns");
            printFibonacciIterative(n);
            long startRecursive = System.nanoTime();
            System.out.print("Recursive: ");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacciRecursive(i));
                if (i < n - 1) {
                    System.out.print(", ");
                }
            }
            long endRecursive = System.nanoTime();
            System.out.println("\nRecursive Time: " + (endRecursive - startRecursive) + " ns");
        }
        scanner.close();
    }

    public static void printFibonacciIterative(int n) {
        if (n == 1) {
            System.out.println("0");
            return;
        }
        if (n == 2) {
            System.out.println("0, 1");
            return;
        }
        int first = 0, second = 1;
        System.out.print(first + ", " + second);
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}