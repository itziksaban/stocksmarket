using System.Collections.Generic;

internal interface IStocksRepository
{
    List<string> LoadAll();
    void Delete(Stock stock);
}