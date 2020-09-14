package goldman.unixPalindromSubstrings;

public class unixPalindromSubstrings {
    public String longestPalindrome2(String s) {
        
        if (s == null || s.isEmpty()) {
            return "";
        }
        int N = 2 * s.length() + 1;
        char[] chars = new char[N];
        int[] RL = new int[N];
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                chars[i] = '*';
            } else {
                chars[i] = s.charAt(i / 2);
            }
            RL[i] = 0;
        }
        int maxRight = -1, centOfMaxRight = -1, maxRL = 0, posOfMaxRL = 0;
        for (int i = 0; i < N; i++) {
            if (i > maxRight) {
                RL[i] = 1 + helper(chars, i, i);
            } else {
                int j = 2 * centOfMaxRight - i;
                if (i + RL[j] - 1 < maxRight) {
                    RL[i] = RL[j];
                } else {
                    RL[i] = (maxRight - i + 1) + helper(chars, 2 * i - maxRight, maxRight);
                }
            }
            if (i + RL[i] -1 > maxRight) {
                maxRight = i + RL[i] -1;
                centOfMaxRight = i;
            }
            if (RL[i] > maxRL) {
                maxRL = RL[i];
                posOfMaxRL = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = posOfMaxRL - maxRL + 1; i <= posOfMaxRL + maxRL -1; i++) {
            if (chars[i] != '*') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    int helper(char[] chars, int left, int right) {
        int move = 0;
        while (left - 1 >=0 && right + 1 < chars.length && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
            move++;
        }
        return move;
    }
}