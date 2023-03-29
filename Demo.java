import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private final static String[] CHINESE_NUMBERS1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private final static String WHOLE_NUMBER = "整数";
    private final static String EQUAL_SIGN = "等于";
    private final static String DECREASE = "减少";
    private final static String INCREASE = "增加";
    private final static String PRINT = "看看";
    private final static String IF = "如果";
    private final static String NOT = "则";
    private final static String ELSE = "否则";

//    private static final Map<Character, Integer> CHINESE_NUMBERS = new HashMap<>();
    private static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String input1 = "整数 气温 等于 十";
        String input2 = "气温 减少 三";
        String input3 = "看看 气温";
        String input4 = "气温 增加 二";
        String input5 = "如果 气温 大于 十 则 看看 “你好，世界” 否则 看看 “冻死我了”";
        String[] input1Arr = input1.trim().split("\\s+");


        if (input1Arr[0].equals(WHOLE_NUMBER) && input1Arr[2].equals(EQUAL_SIGN)) {
            Integer varValue1 = 0;
            String varName1 = input1Arr[1];
            varValue1 = convertToNumeric(input1Arr[3]);
            map.put(varName1,varValue1);
        }

        String[] input2Arr = input2.trim().split("\\s+");
        String varName2 = input2Arr[0];
        String varValue2 = input2Arr[2];

        if (input2Arr[0].equals(varName2) && input2Arr[1].equals(DECREASE)) {
            String varName = input2Arr[0];
            Integer keyValue = map.get(varName);
            keyValue -= convertToNumeric(varValue2);
            map.put(varName,keyValue);
        }

        String[] input3Arr = input3.trim().split("\\s+");

        if (input3Arr[0].equals(PRINT)) {
            System.out.println(convertToChineseNumber(varValue1));
        }

        String[] input4Arr = input4.trim().split("\\s+");
        String varValue4 = input4Arr[2];

        if (input4Arr[0].equals(varName2) && input4Arr[1].equals(INCREASE)) {
            varValue1 += convertToNumeric(varValue4);
            // System.out.println(varValue1);
        }
//        如果 气温 大于 八 则 看看 “你好，世界” 否则 看看 “冻死我了”
        String[] input5Arr = input5.trim().split("\\s+");

        if (input5Arr[0].equals(IF) && input5Arr[4].equals(NOT) && input5Arr[7].equals(ELSE)){
            if (varValue1 > convertToNumeric(input5Arr[3])) {
                System.out.println(input5Arr[6]);
            }else {
                System.out.println(input5Arr[9]);
            }
        }
    }

    public static int findIndex(String[] stringArray, String target) {
        return Arrays.asList(stringArray).indexOf(target);
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

