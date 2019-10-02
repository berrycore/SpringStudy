package ui;

import java.util.List;

import dao.UserAccountDao;
import model.UserAccount;

public class SelectUserAccountUi extends AbstractUi {

	private UserAccountDao userAccountDao;
	
	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Override
	public void show() {
		showUserAccountList(this.userAccountDao.getUserAccountList());
		System.out.println("Enter 를 누르세요");
		this.getInputedString();
	}

	protected void showUserAccountList(List<UserAccount> userAccountList) {
		
		for( UserAccount ua : userAccountList) {
			System.out.println("##################");
			System.out.printf("USER_ID   : %s\n", ua.getUser_id());
			System.out.printf("USER_NAME : %s\n", ua.getUser_name());
			System.out.printf("EMAIL     : %s\n", ua.getEmail());
			System.out.printf("JOB       : %s\n", ua.getJob());
			System.out.printf("GENDER    : %s\n", ua.getGender());
		}
	}
}
