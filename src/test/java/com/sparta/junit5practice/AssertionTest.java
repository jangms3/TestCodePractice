package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//calculator 검증

public class AssertionTest {

    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("assertEquals")
    void test1() {
        Double result = calculator.operate(5, "/", 2);
        assertEquals(2.5, result); //체크 표시로 문제 없음을 보여줌.
    }

    @Test // 일부로 오류
    @DisplayName("assertEquals - Supplier")
    void test1_1() {
        Double result = calculator.operate(5, "/", 0);
        // 테스트 실패 시 메시지 출력 (new Supplier<String>())
        assertEquals(2.5, result, () -> "연산자 혹은 분모가 0이 아닌지 확인해보세요!");
    }

    @Test
    @DisplayName("assertNotEquals")
    void test1_2() {
        Double result = calculator.operate(5, "/", 0);
        assertNotEquals(2.5, result);
    }

    //boolean 타입
    @Test
    @DisplayName("assertTrue 와 assertFalse")
    void test2() {
        assertTrue(calculator.validateNum(9)); //true 인지 아닌지 true - ok
        assertFalse(calculator.validateNum(0)); //false 인지 아닌지  false -ok
    }

    @Test
    @DisplayName("assertNotNull 과 assertNull")
    void test3() {
        Double result1 = calculator.operate(5, "/", 2);
        assertNotNull(result1);
        Double result2 = calculator.operate(5, "/", 0);
        assertNull(result2);
    }

    //exception 처리를 잘했는지 확인하는 test
    @Test
    @DisplayName("assertThrows")
    void test4() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, ()
                        //예측 하는 메세지 파라미터
                        -> calculator.operate(5, "?", 2));
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }
}
