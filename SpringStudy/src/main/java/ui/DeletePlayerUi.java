package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import dao.PlayerDao;
import model.Player;

public class DeletePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu() {
		System.out.println("======================");
		System.out.println("선수 ID를 입력하고 Enter를 "+
				"누르세요.");
		System.out.println("아무것도 입력하지 않고 "+
				"Enter를 누르면 메뉴로 돌아갑니다.");
	}
	@Override
	public void show() {
		showMenu();
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else if(NumberUtils.isNumber(id)) {
			Player p=playerDao.getPlayer(
					Integer.valueOf(id));//운동선수를 찾음
			if(p == null) {//운동선수가 없슴
				System.out.printf("%s 번호의 선수는 "+
						"없습니다.\n", id);
			}else {//있슴
				playerDao.deletePlayer(p);//DB에서 삭제
				System.out.printf("%s 번호의 선수를 "+
						"삭제합니다.\n", id);
			}
		}else {
			show();
		}
	}

}






