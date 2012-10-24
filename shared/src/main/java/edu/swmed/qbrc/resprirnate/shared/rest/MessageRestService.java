package edu.swmed.qbrc.resprirnate.shared.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.swmed.qbrc.resprirnate.shared.models.Stock;
 
@Path("/stock")

public interface MessageRestService {
 
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Stock printMessage(@PathParam("param") String stockCode);
 
}