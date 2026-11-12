package egovframework.example.account.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.text.StringEscapeUtils;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.example.account.service.AccountSearchVO;
import egovframework.example.account.service.AccountService;
import egovframework.example.account.service.AccountVO;
import egovframework.example.cmmn.util.MaskingUtil;

@Service("accountService")
public class AccountServiceImpl extends EgovAbstractServiceImpl implements AccountService {

    @Resource(name = "accountDAO")
    private AccountDAO accountDAO;

    @Override
    public List<AccountVO> selectAccountList(String custId) throws Exception {
        List<AccountVO> list = accountDAO.selectAccountList(custId);
        for (AccountVO vo : list) {
            vo.setAccountNo(MaskingUtil.maskAccountNo(vo.getAccountNo()));
        }
        return list;
    }

    @Override
    public List<AccountVO> selectAccountSearch(AccountSearchVO searchVO) throws Exception {
        List<AccountVO> list = accountDAO.selectAccountSearch(searchVO);
        for (AccountVO vo : list) {
            vo.setAccountNo(MaskingUtil.maskAccountNo(vo.getAccountNo()));
            vo.setHolderNm(StringEscapeUtils.escapeHtml4(vo.getHolderNm()));
        }
        return list;
    }

    @Override
    public AccountVO selectAccountDetail(String accountId) throws Exception {
        AccountVO vo = accountDAO.selectAccountDetail(accountId);
        if (vo == null) {
            throw processException("fail.common.msg");
        }
        vo.setAccountNo(MaskingUtil.maskAccountNo(vo.getAccountNo()));
        return vo;
    }
}
