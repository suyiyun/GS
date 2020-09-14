package goldman.balancedarray;

public class Solution {
    public static int pivotIndex(int[] nums) {
        // Write your code here
        int sum = 0, left = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - left - nums[i] == left) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
		int s[] = {1,2,3,4,6} ; 
		System.out.println(pivotIndex(s)); 
	}
}
