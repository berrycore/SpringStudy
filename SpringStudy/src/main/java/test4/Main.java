package test4;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test4/beans.xml");
		
		Outputter outputter =  (Outputter) context.getBean("FileOutputter");
		try {
			outputter.output("하고싶은말");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
