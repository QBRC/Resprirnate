package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.mkyong.context.SpringApplicationContext;
import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;
 
@Path("/stock")
public class MessageRestService {
 
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String stockCode) {				
    	StockBo stockBo = (StockBo)SpringApplicationContext.getBean("stockBo");
		
		Stock result = stockBo.findByStockCode(stockCode);
 
		return Response.status(200).entity(result).build(); 
	}
 
}