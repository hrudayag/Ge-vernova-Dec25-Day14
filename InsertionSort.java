import java.util.Scanner;
public class InsertionSort{
    static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int j = i - 1;
            while (j >= 0 && compareStrings(arr[j], current) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
    static int compareStrings(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
            i++;
        }
        return s1.length() - s2.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        insertionSort(words);
        System.out.println("\nSorted words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}