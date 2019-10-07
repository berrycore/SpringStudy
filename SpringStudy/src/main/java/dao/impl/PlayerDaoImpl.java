package dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertPlayer(Player p) throws DataAccessException {
		session.insert("mapper.myMapper.putPlayer", p);
	}

}
