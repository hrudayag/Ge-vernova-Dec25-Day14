public class PrimeAnagramPalindrome {
    static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static boolean isPalindrome(int n) {
        int temp = n;
        int rev = 0;

        while (temp > 0) {
            rev = rev * 10 + (temp % 10);
            temp = temp / 10;
        }
        return rev == n;
    }
    static boolean isAnagram(int a, int b) {
        int[] freq1 = new int[10];
        int[] freq2 = new int[10];
        while (a > 0) {
            freq1[a % 10]++;
            a = a / 10;
        }
        while (b > 0) {
            freq2[b % 10]++;
            b = b / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] primeList = new int[200];
        int count = 0;
        //range[0,1000]
        for (int i = 0; i <= 1000; i++) {
            if (i > 9 && isPrime(i)) {
                primeList[count++] = i;
            }
        }
        System.out.println("Prime numbers that are Anagram and Palindrome:");
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (isPalindrome(primeList[i]) &&
                        isPalindrome(primeList[j]) &&
                        isAnagram(primeList[i], primeList[j])) {
                    System.out.println(primeList[i] + " & " + primeList[j]);
                }
            }
        }

    }
}
