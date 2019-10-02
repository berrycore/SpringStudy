package test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test2/beans.xml");
		
		
		MyMessage msg = (MyMessage) context.getBean("MyMessageKR"); 
		msg.sayHello("아리랑");
		
		msg = (MyMessage) context.getBean("MyMessageEN");
		msg.sayHello("Arirang");
	}

}
