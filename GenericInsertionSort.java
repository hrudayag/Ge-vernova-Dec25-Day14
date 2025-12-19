package Generics;
import java.util.Scanner;
public class GenericInsertionSort {
    static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of words:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = sc.nextLine();
        insertionSort(words);
        System.out.println("Sorted Words:");
        for (String word : words)
            System.out.println(word);
    }
}
