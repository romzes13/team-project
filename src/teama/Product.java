package teama;
/**
 * 
 * Product class defines product object.
 * Each product has name, price and quantity.
 */
public class Product {
	
	private String name;
	private double price;
	private int	   quantity;
	private int productId;
	
	
	public Product() {
		
	}
	
	// Product constructor
	public Product(String name, double price, int quantity, int id) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.productId = id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setId(int id) {
		this.productId = id;
	}
	public int getId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Product [Name: " + name + ", Price: $" + price + ", Quantity: " + quantity + ", Product ID: " + productId + "] \n";
	}
	
	
	
}
