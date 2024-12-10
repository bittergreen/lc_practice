// 13. 罗马数字转整数
public class Solution15 {

    public int romanToInt(String s) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return getValue(s.charAt(0));
        int res = 0;
        int last = 0;

        for (int i=0; i<s.length()-1; i++) {
            int v = getValue(s.charAt(i));
            int next = getValue(s.charAt(i+1));
            if (next > v) {
                v = -v;
            }
            res += v;
            last = i;
        }

        res += getValue(s.charAt(last + 1));
        return res;
    }

    private int getValue(char ch) {
        // 'I', 'V', 'X', 'L', 'C', 'D', 'M'
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
