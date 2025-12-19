package Generics;
import java.util.Scanner;
public class GenericMergeSort {
    static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high) {
        if (high - low <= 1)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);
        merge(arr, low, mid, high);
    }
    static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high) {
        Object[] temp = new Object[high - low];
        int i = low, j = mid, k = 0;
        while (i < mid && j < high) {
            if (arr[i].compareTo(arr[j]) <= 0)
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i < mid)
            temp[k++] = arr[i++];

        while (j < high)
            temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[low + x] = (T) temp[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLine();
        mergeSort(arr, 0, arr.length);
        System.out.println("Sorted Strings:");
        for (String s : arr)
            System.out.println(s);
    }
}
