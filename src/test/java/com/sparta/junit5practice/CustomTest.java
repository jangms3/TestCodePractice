package com.sparta.junit5practice;

import org.junit.jupiter.api.*;

public class CustomTest {

    @Test
    @DisplayName("테스트의 내용을 한눈에 알아볼 수 있게 네이밍 해줄 때 사용/ 메서드 명을 신경 안써도됨./")
    void test1(){
        System.out.println("테스트 내용 빠르게 파악");
    }
    //nested test는 특히 계층 구조가 필요한 복잡한 애플리케이션에서 유용합니다.
    //예를 들어, 사용자 로그인 기능을 테스트하는 경우,
    // 먼저 아이디와 비밀번호 입력 검증(유닛 테스트)을 수행하고,
    // 이후 로그인 후 메인 화면으로의 전환을 확인하는 통합 테스트를 적용할 수 있습니다.
    // 이러한 접근 방식은 에러 발생 시 문제의 원인을 보다 쉽게 추적할 수 있도록 도와줍니다.

    // "Order test"는 소프트웨어 테스트에서 테스트 실행 순서가 중요한 경우에 사용하는 방법입니다.
    // 이는 특정 순서대로 실행되어야 하는 테스트 케이스들을 말하며,
    // 예를 들어 테스트가 특정 순서대로 실행되어야 일관된 결과를 얻을 수 있는 경우에 사용됩니다.
    @Nested
    @DisplayName("주제 별로 테스트를 그룹지어서 파악하기 좋습니다.")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class Test1 {

        @Order(1)
        @Test
        @DisplayName("Test1 클래스")
        void test() {
            System.out.println("\nTest1 클래스");
        }

        @Order(3)
        @Test
        @DisplayName("Test1 - test1()")
        void test1() {
            System.out.println("Test1.test1");
        }

        @Order(2)
        @Test
        @DisplayName("Test1 - test2()")
        void test2() {
            System.out.println("Test1.test2");
        }
    }

    @Nested
    @DisplayName("Test2 다른 주제")
    class Test2 {
        @Test
        @DisplayName("Test2 - test1()")
        void test1() {
            System.out.println("Test2.test1");
        }

        @Test
        @DisplayName("Test2 - test2()")
        void test2() {
            System.out.println("Test2.test2");
        }
    }


}
