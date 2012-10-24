package com.mkyong.stock.rest.impl;

import javax.ws.rs.PathParam;

import com.mkyong.context.SpringApplicationContext;
import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;
import com.mkyong.stock.rest.MessageRestService;
 
public class MessageRestServiceImpl implements MessageRestService{
 
	public Stock printMessage(@PathParam("param") String stockCode) {				
    	StockBo stockBo = (StockBo)SpringApplicationContext.getBean("stockBo");
		
		Stock result = stockBo.findByStockCode(stockCode);
 
		return result; 
	}
 
}