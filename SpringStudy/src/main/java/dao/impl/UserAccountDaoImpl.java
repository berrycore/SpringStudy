package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.UserAccountDao;
import model.UserAccount;

public class UserAccountDaoImpl implements UserAccountDao {

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<UserAccount> getUserAccountList() throws DataAccessException {
		return session.selectList("mapper.myMapper.getUserAccountList");
	}

}
