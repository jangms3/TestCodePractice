package com.sparta.junit5practice;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {
    //각각의 테스트가 실행되기 전의 테스트
    @BeforeEach
    void setUp() {
        System.out.println("각각의 테스트 코드가 실행되기 전에 수행");
    }

    @AfterEach
    void tearDown() {
        System.out.println("각각의 테스트 코드가 실행된 후에 수행\n");
    }

    //최초로
    @BeforeAll
    static void beforeAll() {
        System.out.println("모든 테스트 코드가 실행되기 전에 최초로 수행\n");
    }

    //마지막으로
    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트 코드가 수행된 후 마지막으로 수행");
    }

    @Test
    void test1() {
        System.out.println("테스트 코드 작성 1");
    }
    @Test
    void test2() {
        System.out.println("테스트 코드 작성 2");
    }
}
