package edu.swmed.qbrc.resprirnate.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.swmed.qbrc.resprirnate.shared.models.Stock;
import edu.swmed.qbrc.resprirnate.shared.rest.MessageRestService;

public class App {
	
	private static MessageRestService messageRestService;
	
	public static void main(String[] args) {
		
		ApplicationContext appContext =
			     new ClassPathXmlApplicationContext("spring/config/applicationContext.xml");		
		
		messageRestService = (MessageRestService)appContext.getBean("stockClient");
		
		Stock stock = messageRestService.printMessage("7668");
		System.out.println(stock);
	}

}
