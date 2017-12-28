import java.util.List;


public class StockSeller {
	private static final double MIN_PRICE = 5.5;
	private static final int MIN_TRANSACTIONS = 0;
	private IStockMarketAPI stockMarketApi;
	private IStocksRepository stocksRepository;

	public void sell() {
		List<String> stocksIds = stocksRepository.loadAll();
		for (String id : stocksIds) {
			Stock stock = new Stock(id);
			stockMarketApi.completeTradeDetails(stock);
			if (stock.getPrice() < MIN_PRICE && stock.getNumOfTransactions() > MIN_TRANSACTIONS) {
				stockMarketApi.sell(stock);
				deleteWithRetries(stock);
			}
		}
	}

	private void deleteWithRetries(Stock stock) {
		int retries = 3;
		while (retries > 0) {
			try {
				stocksRepository.delete(stock);
				return;
			} catch (DBConnectionException e) {
				retries--;
				continue;
			}
		}
		printToScreen("failed to delete stock {" + stock.getId() + "} from db");
	}

	private void printToScreen(String message) {
		System.out.println(message);
	}
}
