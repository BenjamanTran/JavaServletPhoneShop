package model;

public class ProductOrders {
	private int orderId;
	private int productId;
	private int amountProduct;//so luong product trong gio hang
	private int price;
	public ProductOrders(int orderId, int productId, int amountProduct, int price) {
		
		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}
	
}
