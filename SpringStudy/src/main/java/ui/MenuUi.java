package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	
	private SelectTeamUi selectTeamUi;
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("====================");
		System.out.println(" 팀 관리 시스템");
		System.out.println(" 1. 종료");
		System.out.println(" 2. 팀 목록 보기");
		System.out.println("");
		System.out.println("번호를 입력하고 Enter 키를 누르세요.");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 2;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch (number) {
		case 1:
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
			break;
		case 2:
			this.selectTeamUi.show();			
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
//		MenuUi menuUi = (MenuUi) context.getBean("menuUi");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while (true) {
			menuUi.show();
		}
	}
}
