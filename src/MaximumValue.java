import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
// Jomarc Orogo
public class MaximumValue {
    public static void main(String[] args) {
        // Make this less if your machine might encounter an out-of-memory error
        final int N = 1000; // Try with smaller values like 1000, 10000, or 100000 for testing
        int[] arr = addElements(N);
        long start, end;

        System.out.println("Jomarc Orogo");
        System.out.println(Arrays.toString(arr));
        start = System.nanoTime();
        int maxSimpleLoop = findMaxSimpleLoop(arr);
        end = System.nanoTime();
        System.out.println("\n\nSimple Loop\t\t: " + maxSimpleLoop + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        int maxStream = findMaxStream(arr);
        end = System.nanoTime();
        System.out.println("\nMax Stream\t\t: " + maxStream + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        int maxCollections = findMaxCollections(arr);
        end = System.nanoTime();
        System.out.println("\nMax Collection\t: " + maxCollections + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        int maxParallel = findMaxParallel(arr);
        end = System.nanoTime();
        System.out.println("\nMax Parallel\t: " + maxParallel + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        int maxSorting = findMaxSorting(arr, N);
        end = System.nanoTime();
        System.out.println("\nMax Sorting\t\t: " + maxSorting + " (Time: " + (end - start) + " ns)");

        start = System.nanoTime();
        int maxRecursion = findMaxRecursion(arr, N);
        end = System.nanoTime();
        System.out.println("\nMaximum Value\t: " + maxRecursion + " (Time: " + (end - start) + " ns)");

    }

    // Method to generate random elements in an array
    public static int[] addElements(int N) {
        int[] num = new int[N];
        Random rnd = new Random();
        for (int i = 0; i < N; i++)
            num[i] = rnd.nextInt(-N, N)+1;
        return num;
    }

    // Iterate through the array to find the max value
    public static int findMaxSimpleLoop(int[] arr) {
        int max = arr[0]; // Assume first element is the max initially
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int findMaxStream(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static int findMaxCollections(int[] arr) {
        List<Integer> list = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        return Collections.max(list);
    }

    public static int findMaxParallel(int[] arr) {
        return Arrays.stream(arr).parallel().max().getAsInt();
    }

    public static int findMaxSorting(int[] arr, int N) {
        if (N == 1)
            return arr[0];
        else {
            Arrays.sort(arr);
            return arr[N-1];
        }
    }


    public static int findMaxRecursion(int[] arr, int N) {
        if (N == 1) {
            return arr[0];
        }
        return Math.max(arr[N-1], findMaxRecursion(arr, N - 1));
    }


}