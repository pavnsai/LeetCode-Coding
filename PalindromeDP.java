public class PalindromeDP {
    public static boolean[][] allIsPalindrome(String S, int n) {
        boolean[][] P = new boolean[n + 1][n + 1];

        // Base cases: empty string and single character
        for (int i = 1; i <= n; i++) {
            P[i][i] = true;
            if (i < n && S.charAt(i - 1) == S.charAt(i))
                P[i][i + 1] = true; // Adjacent characters are the same
        }

        // Fill the DP table
        for (int length = 3; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                if (S.charAt(i - 1) == S.charAt(j - 1) && P[i + 1][j - 1])
                    P[i][j] = true;
            }
        }

        return P;
    }

    public static void main(String[] args) {
        String S = "aaaaaa";
        int n = S.length();
        boolean[][] P = allIsPalindrome(S, n);

        // Output the DP table
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
