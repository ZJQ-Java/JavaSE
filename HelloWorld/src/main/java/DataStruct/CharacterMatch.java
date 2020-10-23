package DataStruct;

public class CharacterMatch {
   /* 总结思路：正向遍历，把*当做左括号统计，如果左括号的数量大于右括号，继续反向遍历，否则返回false；
            * 反向遍历，把*当做右括号统计，如果左括号的数量大于右括号，返回false，否则返回true；
            * 因为如果正向遍历，左括号大于右括号，说明要么是左括号和*相加的数量多于右括号，要么是左括号的数量
            * 多于右括号，同时如果反向遍历，左括号小于右括号，说明要么是左括号小于右括号加*的数量，要么是左括
            * 号的数量小于右括号。如果正反遍历都是正数，那么只能是其中存在*这种情况。*/
    public static boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int LeftParenthesis = 0, RightParenthesis = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '*') {
                LeftParenthesis++;
            } else {
                RightParenthesis++;
            }
            if (RightParenthesis > LeftParenthesis)
                return false;
        }
        LeftParenthesis = 0;
        RightParenthesis = 0;
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] == ')' || chars[j] == '*') {
                RightParenthesis++;
            } else {
                LeftParenthesis++;
            }
            if (LeftParenthesis > RightParenthesis)
                return false;
        }

        return true;
    }


    public static boolean checkCharacterString(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }

        if (str.startsWith(")") || str.endsWith("(")) {
            return false;
        }
        int leftIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (c.equals("*") || c.equals("(")) {
                leftIndex++;
            }
            if (c.equals(")")) {
                leftIndex--;
            }
        }
        if (leftIndex == 0) {
            return true;
        } else if (leftIndex < 0) {
            return false;
        }
        leftIndex = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            String c = String.valueOf(str.charAt(i));
            if (c.equals("*") || c.equals(")")) {
                leftIndex++;
            }
            if (c.equals("(")) {
                leftIndex--;
            }
        }
        return leftIndex == 0 || leftIndex > 0;
    }


    public static void main(String[] args) {
//        String s = "(()";
        String s = ")**(";
        System.out.println(checkValidString(s));
        System.out.println(checkCharacterString(s));
    }
}
