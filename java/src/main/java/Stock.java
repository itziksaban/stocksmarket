
public class Stock {

	private double price;
	private double numOfTransactions;
	private String id;

	public Stock(String id) {
		this.id = id;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public double getNumOfTransactions() {
		// TODO Auto-generated method stub
		return numOfTransactions;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setNumOfTransactions(double numOfTransactions) {
		this.numOfTransactions = numOfTransactions;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
