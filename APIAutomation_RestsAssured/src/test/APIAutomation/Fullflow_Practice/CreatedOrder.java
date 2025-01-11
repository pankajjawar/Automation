package Fullflow_Practice;

import java.util.List;

public class CreatedOrder {
	
	private List<String> orders;
	private List<String> productOrderId;
	private String message;
	
	/**
	 * @return the orders
	 */
	public List<String> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	/**
	 * @return the productOrderId
	 */
	public List<String> getProductOrderId() {
		return productOrderId;
	}
	/**
	 * @param productOrderId the productOrderId to set
	 */
	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


}
