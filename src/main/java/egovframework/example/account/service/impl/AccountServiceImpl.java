package egovframework.example.account.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

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
}
