package ui;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import model.Player;
import model.PlayerTeam;
import model.Team;

public class SelectPlayerUi extends AbstractUiTemplate {
	private PlayerDao playerDao;
	private UpdatePlayerUi updatePlayerUi;
	private DeletePlayerUi deletePlayerUi;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public void setUpdatePlayerUi(UpdatePlayerUi updatePlayerUi) {
		this.updatePlayerUi = updatePlayerUi;
	}

	public void setDeletePlayerUi(DeletePlayerUi deletePlayerUi) {
		this.deletePlayerUi = deletePlayerUi;
	}
	public void showHeader() {
		System.out.println("---------------------");
		System.out.println(" 선수 명단 선수 목록 ");
		System.out.println();
	}
	protected Integer getTeamId() {
		System.out.println("선수 목록을 출력하려는 팀의 "+
			"ID를 입력하고 Enter를 누르세요.");
		String teamId = this.getInputedString();
		if(StringUtils.isNotEmpty(teamId) && 
			StringUtils.isNumeric(teamId)) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	protected void showPlayerList(List<PlayerTeam> l) {
		showHeader();
		if( ! l.isEmpty()) {//선수목록이 존재하는 경우
			PlayerTeam pt = l.get(0);
			Player player = new Player();
			player.setPlayer_id(pt.getPlayer_id());
			player.setName(pt.getPlayerName());
			Team team = new Team();
			team.setTeam_id(pt.getTeam_id());
			team.setName(pt.getTeamName());
			player.setTeam(team);
			System.out.printf("팀명: %s\n", 
					player.getTeam().getName());
		}
		System.out.println(" ID   이름");
		for(PlayerTeam pt : l) {
			System.out.printf("%d %s\n",pt.getPlayer_id(),
					pt.getPlayerName());
		}
	}
	public void show() {
		showHeader();
		Integer teamId = getTeamId();
		showPlayerList(this.playerDao.getPlayerList(
				teamId));//선수 목록 출력
		System.out.println("Enter를 누르세요.");
		this.getInputedString();
		super.show();
	}
	@Override
	protected void showMenu() {
		showHeader();
		System.out.println("1. 선수 정보 변경");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 메뉴로 돌아가기");
		System.out.println();
		System.out.println("번호를 입력하고 Enter를 "+
				"누르세요");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1: updatePlayerUi.show();
				break;
		case 2: deletePlayerUi.show();
				break;
		default :
				return;
		}

	}

}







