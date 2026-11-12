package egovframework.example.cmmn.util;

/**
 * 개인정보·금융정보 마스킹 유틸리티.
 */
public final class MaskingUtil {

    private MaskingUtil() {
    }

    /**
     * 계좌번호의 앞 3자리와 뒤 3자리 숫자만 남기고 나머지 숫자를 별표로 가린다. 구분자(하이픈)는 유지한다.
     * 예) 110-123-456789 -> 110-***-***789
     */
    public static String maskAccountNo(String accountNo) {
        if (accountNo == null) {
            return null;
        }
        int digits = 0;
        for (char c : accountNo.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            }
        }
        StringBuilder sb = new StringBuilder(accountNo.length());
        int seen = 0;
        for (char c : accountNo.toCharArray()) {
            if (Character.isDigit(c)) {
                seen++;
                sb.append(seen <= 3 || seen > digits - 3 ? c : '*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
