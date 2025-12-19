public class FindYourNumber {
    static void findNumber(int low, int high, int target) {
        if (low > high)
            return;
        int mid = (low + high) / 2;
        System.out.println("Check: " + mid);
        if (mid == target) {
            System.out.println("Found: " + mid);
            return;
        } else if (target < mid) {
            findNumber(low, mid - 1, target);
        } else {
            findNumber(mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int N = 16;
        findNumber(0, N - 1, 9);
    }
}