package app;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailsId;

	@NotNull
	//@ManyToOne(targetEntity = Order.class)
	//@JoinColumn(name = "id", nullable = false)
	private Long orderId;

	@NotNull
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "id", nullable = false)
	private Long productId;

	@NotNull
	private int quantity;

	public OrderDetails() {
	}
	
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
