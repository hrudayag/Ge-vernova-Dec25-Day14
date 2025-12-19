public class PrimeNumbers {
    static boolean checkprime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++)
            if (checkprime(i))
                System.out.print(i + " ");
    }
}