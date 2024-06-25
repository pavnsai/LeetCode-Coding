public class PalindromeDP2 {
        public static boolean[][] allIsPalindrome(String S, int n) {
            boolean[][] P = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                P[i][i] = true;
            }
            for (int len = 2; len <= n; len++) {
                for (int i = 1; i <= n - len + 1; i++) {
                    int j = i + len - 1;
                    if (S.charAt(i - 1) == S.charAt(j - 1)) {
                        if (len == 2) {
                            P[i][j] = true;
                        } else {
                            P[i][j] = P[i + 1][j - 1];
                        }
                    }
                }
            }
            return P;
        }

        public static void main(String[] args) {
            String S = "abccba";
            int n = S.length();
            boolean[][] P = allIsPalindrome(S, n);
            System.out.println("Palindrome DP Table:");
            System.out.print("  ");
            for (int i = 1; i <= n; i++) {
                System.out.print(S.charAt(i - 1) + " ");
            }
            System.out.println();
            for (int i = 1; i <= n; i++) {
                System.out.print(S.charAt(i - 1) + " ");
                for (int j = 1; j <= n; j++) {
                    System.out.print(P[i][j] ? "T " : "F ");
                }
                System.out.println();
            }
        }

}
