package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class UpdatePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	private TeamDao	teamDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	protected void showMenu(String wanted) {
		System.out.println("####################");
		System.out.printf("%s를 입력하고 Enter를 "+
				"누르세요.", wanted);
	}
	protected Player getPlayer() {
		final String playerId="선수ID";
		showMenu(playerId);
		String id= this.getInputedString();
		if(StringUtils.isEmpty(id)) return null;
		else if(NumberUtils.isNumber(id)) {
			Player p=playerDao.getPlayer(
					Integer.valueOf(id));
			if(p == null) {
				System.out.printf("%s 번호의 선수는 "+
						"없습니다.", id);
				return getPlayer();
			}
			return p;
		}
		return getPlayer();
	}
	protected String getName(Player p) {
		final String playerName="선수명";
		showMenu(playerName);
		System.out.printf("변경전:%s\n", p.getName());
		String name=this.getInputedString();//이름입력
		if(StringUtils.isEmpty(name)) return null;
		if(name.length() < 128) return name;
		return getName(p);
	}
	protected Team getTeam(Player p) {
		final String teamId = "팀ID";
		showMenu(teamId);
		System.out.printf("변경전:%d %s\n", 
				p.getTeam().getTeam_id(),
				p.getTeam().getName());
		String id=this.getInputedString();
		if(StringUtils.isEmpty(id)) return null;
		if(NumberUtils.isNumber(id)) {
			Team team=teamDao.getTeam(
					Integer.valueOf(id));
			if(team == null) {
				System.out.printf("%s인 팀은 없습니다.",id);
				return getTeam(p);
			}
			return team;
		}
		return getTeam(p);
	}
	@Override
	public void show() {
		Player player = getPlayer();
		if(player==null) return;
		String name=this.getName(player);
		if(StringUtils.isNotEmpty(name))
			player.setName(name);//새로운 이름으로 설정
		Team team = this.getTeam(player);
		if(team != null) {
			player.setTeam(team);//새로운 팀으로 설정
			player.setTeam_id(team.getTeam_id());
		}
		this.playerDao.updatePlayer(player);//DB Update
		System.out.printf("%s인 선수를, 선수명 %s, "+
			"팀 %s로 변경합니다.\n", 
			player.getPlayer_id(),player.getName(),
			player.getTeam().getName());
	}

}











