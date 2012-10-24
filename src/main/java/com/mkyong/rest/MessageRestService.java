package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.mkyong.context.SpringApplicationContext;
import com.mkyong.stock.bo.StockBo;
 
@Path("/stock")
public class MessageRestService {
 
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String stockCode) {
		/*ApplicationContext appContext = 
	    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");*/
		
    	StockBo stockBo = (StockBo)SpringApplicationContext.getBean("stockBo");
		
		String result = "Restful example : " + stockBo.findByStockCode(stockCode).getStockName();
 
		return Response.status(200).entity(result).build();
 
	}
 
}