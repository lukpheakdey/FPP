package apr_std_2;

public class Accessory implements Product{
	
	private double price;
	private int numInStock;
	private Item item;
	private String id;
	
	public Accessory(String id, double price, Item item) {
		this.id = id;
		this.price = price;
		this.item = item;
	}
	
	public double getTotalValue() {
		return numInStock * price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getId() {
		return id;
	}
	public void setNumInStock(int num) {
		numInStock = num;
	}
	public int getNumInStock() {
		return numInStock;
	}
	
}
