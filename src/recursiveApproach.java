public class recursiveApproach {
    //Jomarc Orogo
    public static void main(String[] args) {
        System.out.println("Jomarc Orogo");
        int b = 2;
        int e = 5;
        System.out.println("Recursive approach result: " + powRecursive(b, e));
    }

    private static int powRecursive(int b, int e) {
        if(e == 0) return 1;
        else return b * powRecursive(b, e - 1);
    }
}
