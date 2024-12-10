// 12. 整数转罗马数字
public class Solution16 {

    public String intToRoman(int num) {

        int[] numGuys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strGuys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<numGuys.length; i++) {
            while (num >= numGuys[i]) {
                num -= numGuys[i];
                builder.append(strGuys[i]);
            }
        }

        return builder.toString();
    }

}
