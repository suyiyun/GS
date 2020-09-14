package goldman.StringCompression;

public class Solution {
    public static String compress(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        StringBuilder res = new StringBuilder();
        
        int l = 0;
        for (int r = 0; r <= s.length(); r++) {
            if (r == s.length() || s.charAt(l) != s.charAt(r)) {
                int length = r - l;
                char c = s.charAt(l);
                res.append(c).append(length);
                l = r;
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
		String s = "abaasass"; 
		System.out.println(compress(s)); 
	}
}
