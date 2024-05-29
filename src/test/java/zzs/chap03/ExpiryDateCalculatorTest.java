package zzs.chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    @DisplayName("만원 납부하면 한달 뒤가 만료일이 됨")
    void test1(){
        assertExpiryDate(LocalDate.of(2019, 3, 1), 10_000,
                LocalDate.of(2019, 4, 1));

        assertExpiryDate(LocalDate.of(2019, 5, 5), 10_000,
                LocalDate.of(2019, 6, 5));


    }

    @Test
    @DisplayName("납부일과_한달 뒤 일자가 같지 않음")
    void test2() {
        assertExpiryDate(LocalDate.of(2019, 1, 31), 10_000,
                LocalDate.of(2019, 2, 28));

        assertExpiryDate(LocalDate.of(2019, 5, 31), 10_000,
                LocalDate.of(2019, 6, 30));

        assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000,
                LocalDate.of(2020, 2, 29));
    }

    private static void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate ) {

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(expectedExpiryDate, expiryDate);
    }
}
