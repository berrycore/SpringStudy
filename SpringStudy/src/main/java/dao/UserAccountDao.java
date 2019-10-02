package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.UserAccount;

public interface UserAccountDao {

	List<UserAccount> getUserAccountList() throws DataAccessException;
}
