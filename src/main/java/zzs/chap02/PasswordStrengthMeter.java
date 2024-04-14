package zzs.chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password){
        if (password == null || password.isBlank()) return PasswordStrength.INVALID;

        int meetCounts = getMeetCriteriaCounts(password);
        if(meetCounts <= 1) return PasswordStrength.WEEK;
        else if(meetCounts == 2) return PasswordStrength.NORMAL;
        else return PasswordStrength.STRONG;
    }

    private int getMeetCriteriaCounts(String password) {
        int meetCounts= 0;

        //길이가 8이 넘는지 확인
        if (password.length() >=8) meetCounts++;
        //숫자를 포함하고 있는지 확인
        if(meetContainingNumberCriteria(password)) meetCounts++;
        //영어 대문자를 포함하고 있는지 확인
        if(meetContainingUppercaseCriteria(password)) meetCounts++;
        return meetCounts;
    }

    private boolean meetContainingNumberCriteria(String password){
        for (char ch : password.toCharArray()) {
            if(ch >= '0' && ch <= '9') return true;
        }
        return false;
    }

    private boolean meetContainingUppercaseCriteria(String password){
        for (char ch : password.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z') return true;
        }
        return false;
    }
}

