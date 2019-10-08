package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;
import model.PlayerTeam;
import model.Team;

public class PlayerDaoImpl implements PlayerDao {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public void deletePlayer(Player p) throws DataAccessException {
		session.delete("mapper.myMapper.deletePlayer",p);
	}
	@Override
	public void updatePlayer(Player p) throws DataAccessException {
		session.update("mapper.myMapper.updatePlayer",p);
	}
	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		PlayerTeam pt = session.selectOne(
			"mapper.myMapper.getPlayerTeam",id);
		if(pt != null) {
			Player p = new Player();
			p.setPlayer_id(pt.getPlayer_id());
			p.setName(pt.getPlayerName());
			Team team = new Team();
			team.setTeam_id(pt.getTeam_id());
			team.setName(pt.getTeamName());
			p.setTeam(team);
			return p;
		}else {
			return null;
		}
	}
	@Override
	public List<PlayerTeam> getPlayerList(Integer teamId) throws DataAccessException {
		List<PlayerTeam> list = session.selectList(
			"mapper.myMapper.getTeamPlayer",teamId);
		return list;
	}
	@Override
	public void insertPlayer(Player p) throws DataAccessException {
		session.insert("mapper.myMapper.putPlayer",p);
	}

}
