package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	
	private TeamDao teamDao;
	private PlayerDao playerDao;
	
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public void show() {
		final String playerName = "선수명";
		showMenu(playerName);
		String name = this.getInputedString();
		if( StringUtils.isEmpty(name)) {
			return;
		}else if(name.length() < 128) {
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		}else {
			show();
		}
	}
	
	protected void showMenu(String wanted) {
		System.out.println("****************************");
		System.out.printf("%s 를 입력하고 Enter 를 누르세요", wanted);
	}
	
	protected void showTeamField(Player p) {
		final String teamId = "팀ID";
		showMenu(teamId);
		String id = this.getInputedString();
		if( StringUtils.isEmpty(id)) {
			return;
		}else if(NumberUtils.isNumber(id)) {
			Team team = teamDao.getTeam(Integer.valueOf(id));
			if( team == null ) {
				System.out.printf("%s인 팀은 존재하지 않습니다", id);
				showTeamField(p);
			}else {
				p.setTeam_id(Integer.valueOf(id));
				showPlayerId(p, team);
			}
		}
	}
	
	protected void showPlayerId(Player p, Team t) {
		final String playerId = "선수ID";
		showMenu(playerId);
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) {
			return;
		}else if(NumberUtils.isNumber(id)) {
			p.setPlayer_id(Integer.valueOf(id));
			playerDao.insertPlayer(p);
			System.out.printf("팀 %s 에 %s 선수를 등록했습니다", t.getName(), p.getName());
		}
	}

}
