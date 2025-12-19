public class Anagram {
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] arr1 = new char[s1.length()];
        char[] arr2 = new char[s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            arr1[i] = s1.charAt(i);
            arr2[i] = s2.charAt(i);
        }
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr1.length - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    char temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
                if (arr2[j] > arr2[j + 1]) {
                    char temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "act";
        if (isAnagram(str1, str2))
            System.out.println("The Two Strings are Anagram");
        else
            System.out.println("The Two Strings are NOT Anagram");
    }
}