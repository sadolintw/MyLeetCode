package medium.N0005;

class Solution {
    public String longestPalindrome(String s) {
        String reverse = null;

        if(s != null){
            reverse = (new StringBuilder()).append(s).reverse().toString();
        }

        int offset = 0;
        String lcs = "";
        do {
            lcs = LCS(s.substring(offset, s.length()).toCharArray(), reverse.substring(0, reverse.length() - offset).toCharArray(), s.length() - offset, reverse.length() - offset);
            offset++;
            //System.out.println("hi " +lcs + " " + s.substring(offset, s.length()) + " " + reverse.substring(0, reverse.length() - offset));
        }while(!checkPalindrome(lcs));

        return lcs;
    }

    static boolean checkPalindrome(String s){
        String reverse = (new StringBuilder()).append(s).reverse().toString();
        return reverse.equals(s);
    }

    static String LCS(char X[], char Y[], int m, int n) {
        int LCSMatrix[][] = new int[m + 1][n + 1];

        int length = 0;
        int row = 0, col = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCSMatrix[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCSMatrix[i][j] = LCSMatrix[i - 1][j - 1] + 1;
                    if(length < LCSMatrix[i][j]){
                        length = LCSMatrix[i][j];
                        row = i;
                        col = j;
                    }
                }
                else
                    LCSMatrix[i][j] = 0;
            }
        }

        String result = "";

        while(LCSMatrix[row][col] !=0 ){
            result = X[row - 1] + result;

            row--;
            col--;
        }

        return result;
    }
}

public class N0005_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //String input = "bacabbad";
        //String input = "abacdfgdcaba";
        String input = "aacabdkacaa";
        System.out.println(solution.longestPalindrome(input));
    }
}
