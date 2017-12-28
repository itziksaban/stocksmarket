public class Stock
{
    public Stock(string id)
    {
        Id = id;
    }

    public string Id { get; }
    public double Price { get; set; }
    public int NumOfTransactions { get; set; }
}