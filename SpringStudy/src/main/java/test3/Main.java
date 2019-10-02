package test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test3/beans.xml");
		
		Human hong = (MrHong) context.getBean("MrHong");
		hong.has();

		Human kim = (MrKim) context.getBean("MrKim");
		kim.has();
		
	}

}
