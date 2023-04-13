package com.lz;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    void testAssignNum () {
        Demo.assignNum("气温","十");
        Integer result = Demo.getNum("气温");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testDetermineKeywordAssignVariable() {
        String input = "整数 气温 等于 十";
        Demo.determineKeyword(input);
        Integer result = Demo.getNum("气温");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testDetermineKeywordDecrease() {
        String inputDecrease = "气温 减少 三";
        String inputAssign = "整数 气温 等于 十";
        Demo.determineKeyword(inputAssign);
        Demo.determineKeyword(inputDecrease);
        Integer result = Demo.getNum("气温");
        Assertions.assertThat(result).isEqualTo(7);
    }

    @Test
    void testDetermineKeywordPrint() {
        String inputDecrease = "气温 减少 三";
        String inputAssign = "整数 气温 等于 十";
        String print = "看看 气温";
        Demo.determineKeyword(inputAssign);
        Demo.determineKeyword(inputDecrease);
        String result = Demo.determineKeyword(print);
        Assertions.assertThat(result).isEqualTo("七");
    }

    @Test
    void testDetermineKeywordIf() {
        String wholeNumber = "整数 气温 等于 十";
//        String inputDecrease = "气温 减少 三";
//        String inputAssign = "整数 气温 等于 十";

        String  ifStatement= "如果 气温 大于 十 则 看看 “你好，世界” 否则 看看 “冻死我了”";
        Demo.determineKeyword(wholeNumber);
        String result = Demo.determineKeyword(ifStatement);
        Assertions.assertThat(result).isEqualTo("冻死我了");

//        Assertions.assertThat(result).isEqualTo();
    }

    @Test
    void testDetermineKeywordIFPlus() {
        String wholeNumber = "整数 气温 等于 十";
//        String inputDecrease = "气温 减少 三";
//        String inputAssign = "整数 气温 等于 十";
        String  ifStatement= "如果 气温 大于 九 则 看看 “你好，世界” 否则 看看 “冻死我了”";
        Demo.determineKeyword(wholeNumber);
        String result = Demo.determineKeyword(ifStatement);
        Assertions.assertThat(result).isEqualTo("你好，世界");
//        Assertions.assertThat(result).isEqualTo();
    }



}
