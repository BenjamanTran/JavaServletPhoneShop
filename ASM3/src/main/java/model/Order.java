package model;

import java.sql.Date;
import java.util.List;

public class Order {
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", status=" + status + ", orderDate=" + orderDate
				+ ", addres=" + addres + ", phoneNumber=" + phoneNumber + ", lp=" + lp + ", userEmail=" + userEmail
				+ ", receivedDate=" + receivedDate + ", discount=" + discount + "]";
	}
	private int orderId;
	private float price;
	private int status;
	private Date orderDate;
	private String addres;
	private String phoneNumber;
	private List<ProductOrders> lp;
	private String userEmail;
	private Date receivedDate;
	private String discount;
	public Order() {
	
	}
	public Order(int orderId, float price, int status, Date orderDate, String addres, String phoneNumber,
			List<ProductOrders> lp, String userEmail, Date receivedDate, String discount) {
		
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.addres = addres;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userEmail = userEmail;
		this.receivedDate = receivedDate;
		this.discount = discount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<ProductOrders> getLp() {
		return lp;
	}
	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
}
