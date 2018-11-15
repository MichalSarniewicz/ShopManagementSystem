package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create objects of the order with more details.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailsId;

	@NotNull
	private Long orderId;

	@NotNull
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "id", nullable = false)
	private Long productId;

	@NotNull
	private int quantity;

	/**
	 * Empty contructor.
	 */
	public OrderDetails() {
	}
	
	/**
	 * Constructor with all parameters.
	 * 
	 * @param orderDetailsId
	 * @param orderId
	 * @param productId
	 * @param quantity
	 */
	public OrderDetails(Long orderDetailsId, @NotNull Long orderId, @NotNull Long productId, @NotNull int quantity) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
}
