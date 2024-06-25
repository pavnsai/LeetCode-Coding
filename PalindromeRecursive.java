public class PalindromeRecursive {
        public static boolean isPalindrome(String S, int p, int q) {
            if (p > q) {
                return true;
            } else if (p == q) {
                return true;
            } else if (S.charAt(p) != S.charAt(q)) {
                return false;
            } else {
                return isPalindrome(S, p + 1, q - 1);
            }
        }

        public static void main(String[] args) {
            String S1 = "ATRSSRTA";
            int p1 = 0;
            int q1 = S1.length() - 1;
            String S2 = "ACAATRSSRTANAN";
            int p2 = 0;
            int q2 = S2.length() - 1;
            System.out.println("IsPalindrome(" + S1 +  "): " + isPalindrome(S1, p1, q1));
            System.out.println("IsPalindrome(" + S2 +  "): " + isPalindrome(S2, p2, q2));
        }

}
