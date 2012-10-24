package com.mkyong.stock.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mkyong.context.SpringApplicationContext;
import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;
 
@Path("/stock")

public interface MessageRestService {
 
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Stock printMessage(@PathParam("param") String stockCode);
 
}