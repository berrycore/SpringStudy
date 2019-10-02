package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {
	
	private SqlSession session;

	@Override
	public List<Team> getTeamList() throws DataAccessException {
		return session.selectList("mapper.myMapper.getTeamList");
	}

	
	public void setSession(SqlSession session) {
		this.session = session;
	}
}
