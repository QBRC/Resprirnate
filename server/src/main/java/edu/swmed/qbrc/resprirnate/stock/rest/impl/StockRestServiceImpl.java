package edu.swmed.qbrc.resprirnate.stock.rest.impl;

import javax.persistence.NoResultException;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.swmed.qbrc.resprirnate.shared.models.Stock;
import edu.swmed.qbrc.resprirnate.shared.rest.MessageRestService;
import edu.swmed.qbrc.resprirnate.stock.bo.StockBo;
 
@Component
public class StockRestServiceImpl implements MessageRestService{
 
	@Autowired
	StockBo stockBo;
	
	public Stock get(@PathParam("param") String stockCode) {				
    			
		try{
			Stock result = stockBo.findByStockCode(stockCode);
			return result;
		} catch(NoResultException e){
			throw new BadRequestException("Invalid stock code provided -- no such stock.");
		} 
	}
 
}