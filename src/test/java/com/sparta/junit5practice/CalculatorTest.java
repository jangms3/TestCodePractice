package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    //given - when - then
    // Given: 테스트의 초기 상태를 설정합니다. 필요한 데이터나 조건을 준비합니다.
    // When: 테스트의 실제 동작을 수행합니다. 주로 테스트하고자 하는 메서드를 호출하는 단계입니다.
    // Then: 동작에 대한 결과를 검증합니다. 예상한 결과가 나왔는지 확인합니다.
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("계산기 연산 성공 테스트")
    void test1() {
        // given
        int num1 = 5;
        String op = "/";
        int num2 = 2;

        // when
        Double result = calculator.operate(num1, op, num2);

        // then
        assertNotNull(result);
        assertEquals(2.5, result);
    }

    @Test
    @DisplayName("계산기 연산 실패 테스트 : 분모가 0일 경우")
    void test1_1() {
        // given
        int num1 = 5;
        String op = "/";
        int num2 = 0;

        // when
        Double result = calculator.operate(num1, op, num2);

        // then
        assertNull(result); //null 반환하니? null 로 반환을 잘 하면 성공으로 뜸.
    }

    @Test
    @DisplayName("계산기 연산 실패 테스트 : 연산자가 잘못됐을 경우")
    void test1_2() {
        // given
        int num1 = 5;
        String op = "?";
        int num2 = 2;

        // when - then //실행하는거랑 예측을 한번에
        // 예외가 발생하는지와 예외 메시지가 예상한 대로 나오는지를 동시에 확인
        // assertThrows 는 지정한 예외(IllegalArgumentException)가 발생하는지 확인
        //calculator.operate(num1, op, num2)에서
        // IllegalArgumentException 예외가 발생할 것으로 예상하며,
        // 예외가 발생하지 않으면 테스트는 실패
        //예외가 발생하면 exception 객체를 반환하여,
        // 예외의 메시지가 예상한 메시지 "잘못된 연산자입니다."와 일치하는지 assertEquals 로 검증
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> calculator.operate(5, "?", 2));
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }
}