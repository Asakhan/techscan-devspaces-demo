package egovframework.example.account.service;

import java.io.Serializable;

/**
 * 계좌 검색 조건 VO.
 */
public class AccountSearchVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 예금주명(부분 일치) */
    private String holderNm;
    /** 정렬 컬럼 */
    private String sortColumn = "OPEN_DE";

    public String getHolderNm() { return holderNm; }
    public void setHolderNm(String holderNm) { this.holderNm = holderNm; }
    public String getSortColumn() { return sortColumn; }
    public void setSortColumn(String sortColumn) { this.sortColumn = sortColumn; }
}
