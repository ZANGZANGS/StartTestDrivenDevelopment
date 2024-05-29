package zzs.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate date, int amount){

        return amount == 10_000 ?
                date.plusMonths(1L) : date;

    }
}
