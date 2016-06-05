import java.util.List;


public interface IStocksRepository {

	List<String> loadAll();

	void delete(Stock stock);

}
