package egovframework.example.account.service;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 계좌 정보 VO.
 */
public class AccountVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountId;
    private String custId;
    private String accountNo;
    private String holderNm;
    private String bankCd;
    private BigDecimal balance;
    private String openDe;

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public String getCustId() { return custId; }
    public void setCustId(String custId) { this.custId = custId; }
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }
    public String getHolderNm() { return holderNm; }
    public void setHolderNm(String holderNm) { this.holderNm = holderNm; }
    public String getBankCd() { return bankCd; }
    public void setBankCd(String bankCd) { this.bankCd = bankCd; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public String getOpenDe() { return openDe; }
    public void setOpenDe(String openDe) { this.openDe = openDe; }
}
