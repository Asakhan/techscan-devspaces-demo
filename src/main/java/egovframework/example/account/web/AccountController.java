package egovframework.example.account.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.account.service.AccountSearchVO;
import egovframework.example.account.service.AccountService;
import egovframework.example.account.service.AccountVO;

/**
 * 계좌 조회 API.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Resource(name = "accountService")
    private AccountService accountService;

    /** 고객 계좌 목록 조회. 예) GET /api/accounts?custId=C0001 */
    @GetMapping
    public List<AccountVO> selectAccountList(@RequestParam("custId") String custId) throws Exception {
        return accountService.selectAccountList(custId);
    }

    /** 예금주명 검색. 예) GET /api/accounts/search?holderNm=홍&sort=BALANCE */
    @GetMapping("/search")
    public List<AccountVO> selectAccountSearch(@RequestParam("holderNm") String holderNm,
                                               @RequestParam(value = "sort", defaultValue = "OPEN_DE") String sort) throws Exception {
        AccountSearchVO searchVO = new AccountSearchVO();
        searchVO.setHolderNm(holderNm);
        searchVO.setSortColumn(sort);
        return accountService.selectAccountSearch(searchVO);
    }

    /** 계좌 상세 조회. 예) GET /api/accounts/A0001 */
    @GetMapping("/{accountId}")
    public AccountVO selectAccountDetail(@PathVariable("accountId") String accountId) throws Exception {
        return accountService.selectAccountDetail(accountId);
    }
}
