public class StringPermutations {
    //iterative m
    static String[] permutationsIterative(String str) {
        int n = str.length();
        int total = factorial(n);

        String[] result = new String[total];
        result[0] = "";

        int size = 1;

        for (int i = 0; i < n; i++) {
            char current = str.charAt(i);
            String[] temp = new String[size * (i + 1)];
            int index = 0;

            for (int j = 0; j < size; j++) {
                String word = result[j];
                for (int k = 0; k <= word.length(); k++) {
                    temp[index++] =
                            word.substring(0, k) + current + word.substring(k);
                }
            }
            result = temp;
            size = index;
        }
        return result;
    }
    //recursive m
    static String[] permutationsRecursive(String str) {
        if (str.length() == 0) {
            return new String[]{""};
        }
        char first = str.charAt(0);
        String remaining = str.substring(1);
        String[] smaller = permutationsRecursive(remaining);
        String[] result = new String[smaller.length * (remaining.length() + 1)];
        int index = 0;
        for (int i = 0; i < smaller.length; i++) {
            String word = smaller[i];
            for (int j = 0; j <= word.length(); j++) {
                result[index++] =
                        word.substring(0, j) + first + word.substring(j);
            }
        }
        return result;
    }
    static boolean areArraysEqual(String[] a, String[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i].equals(b[j])) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }
    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
    public static void main(String[] args) {
        String input = "HEY";

        String[] iterative = permutationsIterative(input);
        String[] recursive = permutationsRecursive(input);

        System.out.println("Iterative Permutations:");
        for (int i = 0; i < iterative.length; i++)
            System.out.println(iterative[i]);

        System.out.println("\nRecursive Permutations:");
        for (int i = 0; i < recursive.length; i++)
            System.out.println(recursive[i]);

        System.out.println("\nArrays Equal: " +
                areArraysEqual(iterative, recursive));
    }
}
