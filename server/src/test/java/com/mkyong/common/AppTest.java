package com.mkyong.common;

import javax.persistence.NoResultException;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

import org.jboss.resteasy.spi.BadRequestException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.swmed.qbrc.resprirnate.shared.models.Stock;
import edu.swmed.qbrc.resprirnate.stock.bo.StockBo;
import edu.swmed.qbrc.resprirnate.stock.rest.impl.StockRestServiceImpl;


public class AppTest{
   
	@InjectMocks
	private StockRestServiceImpl stockRestServiceImpl;
    
	
	@Mock
    private StockBo stockBo;
            
    @Before
    public void init(){
    	MockitoAnnotations.initMocks(this);
    
    }
    
    
    @Test
    public void validStock(){
    	// Given
    	Stock s = new Stock("1", "ABCD");
    	given(stockBo.findByStockCode(any(String.class))).willReturn(s);
    	
    	// When
    	Stock returned = stockRestServiceImpl.get("1");	
    	
    	//Then
    	assertEquals(s, returned);
    }
    
    @Test(expected = BadRequestException.class)
    public void invalidStock(){
    	// Given
    	given(stockBo.findByStockCode(any(String.class))).willThrow(NoResultException.class);
    	
    	// When
    	stockRestServiceImpl.get("1");	
    	    	
    }
    
}
