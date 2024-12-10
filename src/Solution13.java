// 9. 回文数
public class Solution13 {

    public boolean isPalindrome1(int x) {

        String reversed = new StringBuilder(x + "").reverse().toString();
        return reversed.equals(x + "");

    }

}
