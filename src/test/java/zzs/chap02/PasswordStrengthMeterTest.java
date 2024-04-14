package zzs.chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("암호 검사기")
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();
    private void assertStrength(String password, PasswordStrength normal) {
        PasswordStrength result = meter.meter(password);
        Assertions.assertEquals(result, normal);
    }

    @Test
    @DisplayName("첫 번째 테스트: 모든 규칙을 충족하는 경우")
    void test1(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }


    @Test
    @DisplayName("두 번째 테스트: 길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    void test2() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("세 번째 테스트: 숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void test3() {
        assertStrength("ab!@Aqwer", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("네 번째 테스트: 값이 없는 경우")
    void test4() {
        assertStrength("", PasswordStrength.INVALID);
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("다섯 번째 테스트: 대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void test5() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("여섯 번째 테스트: 길이가 8글자 이상인 조건만 충족하는 경우")
    void test6() {
        assertStrength("abcdefghijklmk", PasswordStrength.WEEK);
    }

    @Test
    @DisplayName("일곱 번째 테스트: 숫자포함 조건만 충족하는 경우")
    void test7() {
        assertStrength("a12k", PasswordStrength.WEEK);
    }

    @Test
    @DisplayName("여덟 번째 테스트: 대문자 포함 조건만 충족하는 경우")
    void test8() {
        assertStrength("aABCk", PasswordStrength.WEEK);
    }

    @Test
    @DisplayName("아홉 번째 테스트: 아무 조건도 충족하지 않은 경우")
    void test9() {
        assertStrength("abc", PasswordStrength.WEEK);
    }

}
