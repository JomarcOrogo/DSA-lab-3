import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class LinearSearching {
    //Jomarc Orogo
    public static void main(String[] args) {
        final int N = 100; // You can change this to 1000, 10000, or 100000
        int[] arr = addElements(N);
        System.out.println("Jomarc Orogo");
        System.out.println("\n" + Arrays.toString(arr));
        int value = 5;
        long start, end;

        System.out.println("\nValue to find: " + value);
        start = System.nanoTime();
        boolean linearResult = linearSearch(arr, value);
        end = System.nanoTime();
        System.out.println("Linear Search\t\t\t: " + linearResult + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        boolean binaryResult = binarySearch(arr, value);
        end = System.nanoTime();
        System.out.println("Binary Search(BS)\t\t: " + binaryResult + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        boolean builtInBinaryResult = binarySearchBuiltIn(arr, value);
        end = System.nanoTime();
        System.out.println("Built-in BS\t\t\t\t: " + builtInBinaryResult + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        boolean hashMapResult = hashMapSearch(arr, value);
        end = System.nanoTime();
        System.out.println("HashMap Search\t\t\t: " + hashMapResult + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        boolean streamResult = streamSearch(arr, value);
        end = System.nanoTime();
        System.out.println("Stream Search\t\t\t: " + streamResult + " (Time: " + (end - start) + " ns)");
        start = System.nanoTime();
        boolean parallelResult = parallelSearch(arr, value);
        end = System.nanoTime();
        System.out.println("Parallel Stream Search\t: " + parallelResult + " (Time: " + (end - start) + " ns)");
        System.out.println("---Nothing follows---");
    }
    public static int[] addElements(int N) {
        int[] num = new int[N];
        Random rnd = new Random();
        for (int i = 0; i < N; i++)
            num[i] = rnd.nextInt(2 * N + 1) - N; // Generates numbers between -N and N
        return num;
    }
    public static boolean linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int value) {
/** We need to copy the original array to another array object
 because we need to sort the elements of the array here.
 Note that sorting the array will modify its order internally. */
        int arrCopy[] = Arrays.copyOf(arr, arr.length);
/**Sorting is necessary for the binary search to function correctly.
 * You can uncomment the following line to see the effect. */
        Arrays.sort(arrCopy);
        int left = 0;
        int right = arrCopy.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrCopy[mid] == value) {
                return true;
            }
            if (arrCopy[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static boolean binarySearchBuiltIn(int[] arr, int value) {
        int arrCopy[]=Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        return Arrays.binarySearch(arrCopy, value) >= 0;
    }
    public static boolean hashMapSearch(int[] arr, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map.containsKey(value);
    }
    public static boolean streamSearch(int[] arr, int value) {
        return Arrays.stream(arr).anyMatch(x -> x == value);
    }
    public static boolean parallelSearch(int[] arr, int value) {
        return Arrays.stream(arr).parallel().anyMatch(x -> x == value);
    }
}//end of class