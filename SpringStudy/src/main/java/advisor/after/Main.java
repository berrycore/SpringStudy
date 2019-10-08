package advisor.after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("advisor/after/beans.xml");
		
		//MessageBean bean = context.getBean(MessageBeanImpl.class);
		//MessageBean bean = (MessageBean) context.getBean("MessageBean");
		MessageBean bean = (MessageBean) context.getBean("proxy");
		bean.sayHello();
	}
}