package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.stock.bo.StockBo;
 
@Path("/stock")
public class MessageRestService {
 
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String stockCode) {
		ApplicationContext appContext = 
	    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
		
		String result = "Restful example : " + stockBo.findByStockCode(stockCode).getStockName();
 
		return Response.status(200).entity(result).build();
 
	}
 
}