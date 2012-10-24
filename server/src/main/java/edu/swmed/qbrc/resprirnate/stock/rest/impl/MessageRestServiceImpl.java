package edu.swmed.qbrc.resprirnate.stock.rest.impl;

import javax.ws.rs.PathParam;


import edu.swmed.qbrc.resprirnate.context.SpringApplicationContext;
import edu.swmed.qbrc.resprirnate.shared.models.Stock;
import edu.swmed.qbrc.resprirnate.shared.rest.MessageRestService;
import edu.swmed.qbrc.resprirnate.stock.bo.StockBo;
 
public class MessageRestServiceImpl implements MessageRestService{
 
	public Stock printMessage(@PathParam("param") String stockCode) {				
    	StockBo stockBo = (StockBo)SpringApplicationContext.getBean("stockBo");
		
		Stock result = stockBo.findByStockCode(stockCode);
 
		return result; 
	}
 
}