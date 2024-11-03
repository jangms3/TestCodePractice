package com.sparta.junit5practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {

    @RepeatedTest(value = 5,// 5번 돌림
            name = "반복 테스트 {currentRepetition} / {totalRepetitions}")
    void repeatTest(RepetitionInfo info) {
        //RepetitionInfo 는 JUnit 5에서 제공하는
        // 반복 관련 정보 객체로, 테스트 메서드에 전달됩니다.
        // 이 객체를 통해 현재 반복 횟수와 총 반복 횟수를 확인할 수 있습니다.
        System.out.println("테스트 반복 : "
                + info.getCurrentRepetition() //현재 반복횟수
                + " / "
                + info.getTotalRepetitions()); //총 반복 횟수
    }

    @DisplayName("파라미터 값 활용하여 테스트 하기")
    @ParameterizedTest
    //이 어노테이션은 테스트 메서드가 여러 개의 매개변수 값으로 반복 실행됨을 나타냅니다.
    //@ValueSource 와 같은 추가 어노테이션을 사용하여
    // 테스트 메서드에 전달할 값의 집합을 정의할 수 있습니다.
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
//    @ValueSource는 테스트 메서드에 전달할 인자 값을 정의합니다.
//    ints 속성에 {1, 2, 3, 4, 5, 6, 7, 8, 9}라는 정수 배열을 지정하여, parameterTest 메서드가 이 값들로 반복 실행되도록 설정합니다.
//    따라서 parameterTest 메서드는 num이 1부터 9까지 하나씩 대입되며, 총 9번 실행됩니다.
    void parameterTest(int num) {
        //void parameterTest(int num):
        //parameterTest 메서드는 int형 파라미터 num을 받습니다.
        //@ValueSource에서 지정한 값들이 순서대로 num에 대입되어 테스트 메서드가 실행됩니다.
        System.out.println("5 * num = " + 5 * num);
    }

}
