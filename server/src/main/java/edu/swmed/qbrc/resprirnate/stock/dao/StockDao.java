package edu.swmed.qbrc.resprirnate.stock.dao;

import edu.swmed.qbrc.resprirnate.shared.models.Stock;

public interface StockDao {
	
	void save(Stock stock);
	
	void update(Stock stock);
	
	void delete(Stock stock);
	
	Stock findByStockCode(String stockCode);

}
