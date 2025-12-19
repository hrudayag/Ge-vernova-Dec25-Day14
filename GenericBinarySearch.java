package Generics;
import java.util.Scanner;
public class GenericBinarySearch {
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
    static <T extends Comparable<T>> boolean binarySearch(T[] arr, T key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(key);
            if (cmp == 0)
                return true;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter comma separated words:");
        String input = sc.nextLine();
        String[] words = input.split(",");
        insertionSort(words);
        System.out.println("Enter word to search:");
        String search = sc.next();
        if (binarySearch(words, search))
            System.out.println("Word Found");
        else
            System.out.println("Word Not Found");
    }
}