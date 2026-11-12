package egovframework.example.account.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
