package egovframework.example.account.service;

import java.util.List;

/**
 * 계좌 조회 서비스.
 */
public interface AccountService {

    /** 고객의 계좌 목록을 조회한다(계좌번호는 마스킹). */
    List<AccountVO> selectAccountList(String custId) throws Exception;

    /** 예금주명으로 계좌를 검색한다. */
    List<AccountVO> selectAccountSearch(AccountSearchVO searchVO) throws Exception;

    /** 계좌 상세 정보를 조회한다. */
    AccountVO selectAccountDetail(String accountId) throws Exception;
}
