package edu.swmed.qbrc.resprirnate.stock.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import edu.swmed.qbrc.resprirnate.context.SpringApplicationContext;
import edu.swmed.qbrc.resprirnate.stock.bo.StockBo;
import edu.swmed.qbrc.resprirnate.stock.model.Stock;
 
@Path("/stock")

public interface MessageRestService {
 
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Stock printMessage(@PathParam("param") String stockCode);
 
}