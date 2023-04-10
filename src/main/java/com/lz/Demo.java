package com.lz;

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

    public static void assignNum(String name, String number) {
        int toNumeric = convertToNumeric(number);
        assignNum(name,toNumeric);
    }

    public static void assignNum (String name, Integer number) {
        map.put(name,number);
    }

    public static Integer getNum(String name) {
        return map.get(name);
    }

    public static void addSubVar (String name, Integer inputNum) {
        Integer num = getNum(name);
        num += inputNum;
        assignNum(name,num);

    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String input1 = "整数 气温 等于 十";
        String input2 = "气温 减少 三";
        String input3 = "看看 气温";
        String input4 = "气温 增加 二";
        String input5 = "如果 气温 大于 十 则 看看 “你好，世界” 否则 看看 “冻死我了”";
        determineKeyword(input1);
        determineKeyword(input2);
        determineKeyword(input3);
        determineKeyword(input4);
        determineKeyword(input5);
        // call a function to process every input


    }

   // split the string for input
    public static String determineKeyword(String str) {
        String[] splitArr = str.trim().split("\\s+");
//
        // 整数 气温 等于 十
        if (splitArr[0].equals(WHOLE_NUMBER) && splitArr[2].equals(EQUAL_SIGN)) {
            String name = splitArr[1];
            String value = splitArr[3];
            assignNum(name,value);
        } else if(splitArr[1].equals(DECREASE)) {
               //气温 减少 三
                Integer numb = convertToNumeric(splitArr[2]);
                numb = -numb;
                addSubVar(splitArr[0],numb);
        } else if (splitArr[0].equals(PRINT)) {
            //看看 气温
            String name = splitArr[1];
            return convertToChineseNumber(getNum(name));
        }

        else if (splitArr[1].equals(INCREASE)) {
            //气温 增加 二
            Integer numb = convertToNumeric(splitArr[2]);
            addSubVar(splitArr[0],numb);
        }
        else if(splitArr[5].equals(IF) && splitArr[4].equals(NOT) && splitArr[7].equals(ELSE)) {
            //如果 气温 大于 八 则 看看 “你好，世界” 否则 看看 “冻死我了”

                if (getNum(splitArr[2]) > convertToNumeric(splitArr[3])) {
                    System.out.println(splitArr[6]);
                }else {
                    System.out.println(splitArr[9]);
                }
        }




//        switch (keyword) {
//            case WHOLE_NUMBER:
//                System.out.println("整数");
//                break;
//            case PRINT:
//                System.out.println("打印");
//                break;
//            case IF:
//                System.out.println("如果");
//                break;
//            default:
//                throw new IllegalArgumentException("没有符合的关键词");
//        }
        return null;
    }

    public static void matchVariable(String str) {
        if(map.containsKey(str)) {
            System.out.println("在里面");
            }
        else {
            System.out.println("没有这个对象");
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

