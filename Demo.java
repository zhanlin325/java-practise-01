import java.util.HashMap;
import java.util.Map;

public class Demo {
    private final static String[] CHINESE_NUMBERS1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private final static String WHOLE_NUMBER = "整数";
    private final static String EQUAL_SIGN = "等于";

    private final static String DECREASE = "减少";

    private final static String PRINT = "看看";

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String input1 = "整数 气温 等于 十";
        String input2 = "气温 减少 三";
        String input3 = "看看 气温";
        String[] input1Arr = input1.trim().split("\\s+");
        String varName1 = input1Arr[1];
        String varValue1 = input1Arr[3];
        if (input1Arr[0].equals(WHOLE_NUMBER) && input1Arr[2].equals(EQUAL_SIGN)) {
            varName1 = input1Arr[3];
        }

        String[] input2Arr = input2.trim().split("\\s+");
        String varName2 = input2Arr[0];
        String varValue2 = input2Arr[2];
        Integer varResult2 = 0;
        if (input2Arr[0].equals(varName2) && input2Arr[1].equals(DECREASE)) {
            int temp = convertToNumeric(varValue1);
            temp -= convertToNumeric(varValue2);
            varResult2 = temp;
        }

        String[] input3Arr = input3.trim().split("\\s+");
        if (input3Arr[0].equals(PRINT)) {
            System.out.println(convertToChineseNumber(varResult2));
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

