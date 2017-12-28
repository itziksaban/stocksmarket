

using System;
using System.Collections.Generic;

public class StockSeller {
	private const double MIN_PRICE = 5.5;
	private const int MIN_TRANSACTIONS = 0;
	private IStockMarketAPI stockMarketApi;
	private IStocksRepository stocksRepository;

	public void Sell() {
		List<String> stocksIds = stocksRepository.LoadAll();
		foreach (string id in stocksIds) {
			Stock stock = new Stock(id);
			stockMarketApi.CompleteTradeDetails(stock);
			if (stock.Price < MIN_PRICE && stock.NumOfTransactions > MIN_TRANSACTIONS) {
				stockMarketApi.Sell(stock);
				DeleteWithRetries(stock);
			}
		}
	}

	private void DeleteWithRetries(Stock stock) {
		int retries = 3;
		while (retries > 0) {
			try {
				stocksRepository.Delete(stock);
				return;
			} catch (DBConnectionException e) {
				retries--;
				continue;
			}
		}
		
	}
}