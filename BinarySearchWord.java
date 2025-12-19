public class BinarySearchWord {
    static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    static boolean binarySearch(String[] arr, String key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(arr[mid]);
            if (cmp == 0) return true;
            if (cmp > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] words = {"hey", "how", "hrudaya", "yet"};
        insertionSort(words);
        System.out.println(binarySearch(words, "yeah"));
    }
}
