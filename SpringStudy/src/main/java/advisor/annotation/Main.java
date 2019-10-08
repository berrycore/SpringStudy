package advisor.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("advisor/annotation/beans.xml");
		
		//MessageBean bean = context.getBean(MessageBeanImpl.class);
		//MessageBean bean = (MessageBean) context.getBean("MessageBean");
		MessageBean bean = (MessageBean) context.getBean("MessageBean");
		bean.sayHello();
	}
}

