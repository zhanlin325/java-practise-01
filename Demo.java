import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Demo {
    private final static String[] CHINESE_NUMBERS1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String input = "整数 气温 等于 十";
        String input2 = "气温 减少 三";
        String input3 = "看看 气温";
        String[] split = input.trim().split("\\s+");
        String variable = split[1];
        String var_number = split[3];
        if (split[0].equals("整数") && split[2].equals("等于")) {
            variable = split[3];
            // System.out.println(variable);
        }
        // System.out.println(convertToNumeric("四"));

        String[] str2 = input2.trim().split("\\s+");
        String str2Variable = str2[0];
        String str2varNumber2 = str2[2];
        Integer varNumber = 0;
        // System.out.println(str2Variable);
        // System.out.println(str2varNumber2);
        if (str2[0].equals(str2Variable) && str2[1].equals("减少")) {
            int temp = convertToNumeric(var_number);
            temp -= convertToNumeric(str2[2]);
            varNumber = temp;
        //    System.out.println(temp);
        }
        String[] str3 = input3.trim().split("\\s+");
        if (str3[0].equals("看看")) {
            System.out.println(convertToChineseNumber(varNumber));
        }

    }

    public static String convertToChineseNumber(int number) {
        return CHINESE_NUMBERS1[number];
    }





    private static final Map<Character, Integer> CHINESE_NUMBERS = new HashMap<>();
    static {
        CHINESE_NUMBERS.put('零', 0);
        CHINESE_NUMBERS.put('一', 1);
        CHINESE_NUMBERS.put('二', 2);
        CHINESE_NUMBERS.put('三', 3);
        CHINESE_NUMBERS.put('四', 4);
        CHINESE_NUMBERS.put('五', 5);
        CHINESE_NUMBERS.put('六', 6);
        CHINESE_NUMBERS.put('七', 7);
        CHINESE_NUMBERS.put('八', 8);
        CHINESE_NUMBERS.put('九', 9);
        CHINESE_NUMBERS.put('十', 10);
    }

    public static int convertToNumeric(String chineseNumber) {
        int result = 0;
        int lastNumber = -1;
        for (int i = 0; i < chineseNumber.length(); i++) {
            char c = chineseNumber.charAt(i);
            int currentNumber = CHINESE_NUMBERS.get(c);
            if (currentNumber == 10) {
                if (lastNumber < 0) {
                    result += 10;
                } else {
                    result += lastNumber * 10;
                }
                lastNumber = -1;
            } else {
                if (lastNumber < 0) {
                    lastNumber = currentNumber;
                } else {
                    result += lastNumber;
                    lastNumber = currentNumber;
                }
            }
        }
        if (lastNumber >= 0) {
            result += lastNumber;
        }
        return result;
    }
}

