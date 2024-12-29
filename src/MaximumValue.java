import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MaximumValue {
    public static void main(String[] args) {
        // Make this less if your machine might encounter an out-of-memory error
        final int N = 10; // Try with smaller values like 1000, 10000, or 100000 for testing
        int[] arr = addElements(N);
        System.out.println(Arrays.toString(arr));
        System.out.println("\n\nSimple Loop\t\t: " + findMaxSimpleLoop(arr));
        System.out.println("Max Stream\t\t: " + findMaxStream(arr));
        System.out.println("Max Collection\t: " + findMaxCollections(arr));
        System.out.println("Max Parallel\t: " + findMaxParallel(arr));
        System.out.println("Max Sorting\t\t: " + findMaxSorting(arr, N));
        System.out.println("Maximum Value\t: " + findMaxRecursion(arr, N));
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