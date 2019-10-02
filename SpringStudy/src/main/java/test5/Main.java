package test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test5/beans.xml");
		MessageBean bean = (MessageBean) context.getBean("MessageBeanImpl");
		bean.sayHello();
	}
}
