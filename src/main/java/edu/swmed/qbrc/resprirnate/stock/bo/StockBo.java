package edu.swmed.qbrc.resprirnate.stock.bo;

import edu.swmed.qbrc.resprirnate.stock.model.Stock;

public interface StockBo {
	
	void save(Stock stock);
	
	void update(Stock stock);
	
	void delete(Stock stock);
	
	Stock findByStockCode(String stockCode);

}
