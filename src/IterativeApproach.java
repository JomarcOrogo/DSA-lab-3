public class IterativeApproach {
    //Jomarc Orogo
    public static void main(String[] args) {
        System.out.println("Jomarc Orogo");
        int b = 2;
        int e = 5;
        System.out.println("Iterative approach result: " + powIterative(b, e));
    }

    public static int powIterative(int b, int e) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result *= b;
        }
        return result;
    }
}
