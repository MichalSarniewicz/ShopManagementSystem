package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SupplyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplyDetailsId;

	@NotNull
	private Long supplyId;

	@NotNull
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "id", nullable = false)
	private Long productId;

	@NotNull
	private int quantity;

	public SupplyDetails() {
	}
	
	public SupplyDetails(Long supplyDetailsId, @NotNull Long supplyId, @NotNull Long productId, @NotNull int quantity) {
		super();
		this.supplyDetailsId = supplyDetailsId;
		this.supplyId = supplyId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
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
	
	public Long getSupplyDetailsId() {
		return supplyDetailsId;
	}

	public void setSupplyDetailsId(Long orderDetailsId) {
		this.supplyDetailsId = orderDetailsId;
	}


}
