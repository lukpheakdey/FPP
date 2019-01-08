package prob2;

public class Bicycle {
	private double price;
	private int numInStock;
	private Brand brand;
	private String id;
	public Bicycle(String id, double price, Brand brand) {
		this.id = id;
		this.price = price;
		this.brand = brand;
	}
	public String getId() {
		return id;
	}
	
	public double getTotalValue() {
		return price * numInStock;
	}
	
	public void setNumInStock(int x) {
		numInStock = x;
	}
	public double getPrice() {
		return price;
	}
	
	public Brand getBrand() {
		return brand;
	}

}
