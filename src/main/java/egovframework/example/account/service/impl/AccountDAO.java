package egovframework.example.account.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import egovframework.example.account.service.AccountVO;

/**
 * 계좌 DAO. 쿼리는 egovframework/mapper/account/Account_SQL.xml 에 있다.
 */
@Repository("accountDAO")
public class AccountDAO extends EgovAbstractMapper {

    public List<AccountVO> selectAccountList(String custId) {
        return selectList("accountDAO.selectAccountList", custId);
    }
}
