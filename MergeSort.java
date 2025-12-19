import java.util.Scanner;
public class MergeSort{
    static void mergeSort(String[] arr, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid, hi);
        merge(arr, lo, mid, hi);
    }
    static void merge(String[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo;
        int n2 = hi - mid;
        String[] left = new String[n1];
        String[] right = new String[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[lo + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + j];
        }
        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
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
        mergeSort(words, 0, words.length);
        System.out.println("Sorted words:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}