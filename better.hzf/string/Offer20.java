package string;

public class Offer20 {
    public boolean isNumber(String s) {
        String trimStr = s.trim();
        String left = "", right = "";
        if (trimStr.contains("e") && trimStr.contains("E")) {
            return false;
        } else if (trimStr.contains("e")) {
            if (trimStr.indexOf("e") != trimStr.lastIndexOf("e")) {
                return false;
            }
            String[] split = trimStr.split("e");
            if (split.length != 2) {
                return false;
            }
            left = split[0];
            right = split[1];
            return checkXiao(left) && checkZheng(right);
        } else if (trimStr.contains("E")) {
            if (trimStr.indexOf("E") != trimStr.lastIndexOf("E")) {
                return false;
            }
            String[] split = trimStr.split("E");
            if (split.length != 2) {
                return false;
            }
            left = split[0];
            right = split[1];
            return checkXiao(left) && checkZheng(right);
        } else {
            left = trimStr;
            return checkXiao(left);
        }
    }

    private boolean checkXiao(String s) {
        if (s.indexOf(".") != s.lastIndexOf(".")) {
            return false;
        }
        String[] split = s.split("\\.");
        if (split.length == 1) {
            return checkZheng(split[0]);
        }
        if (split.length > 2) {
            return false;
        }
        if (s.charAt(s.length() - 1) == '.') {
            return false;
        }
        return (isOneOf(split[0], "", "+", "-") || checkZheng(split[0])) && isAllDigit(split[1]);
    }

    private boolean isAllDigit(String s) {
        for (char ch : s.toCharArray()) {
            if (!isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneOf(String x, String... args) {
        for (String str : args) {
            if (x.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkZheng(String s) {
        if (s.length() < 1) {
            return false;
        }
        if (s.length() == 1) {
            return isDigit(s.charAt(0));
        }
        char first = s.charAt(0);
        if (!isDigit(first) && first != '+' && first != '-') {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char ch) {
        return ch - '0' >= 0 && ch - '0' <= 9;
    }

    public static void main(String[] args) {
        Offer20 solution = new Offer20();
        String[] right = {"    7e69e  "};
        for (String str : right) {
            System.out.println(solution.isNumber(str));
        }
    }
}
