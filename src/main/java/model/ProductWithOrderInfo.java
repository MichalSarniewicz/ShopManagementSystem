package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create ProductWithOrderInfo objects.
 * These objects are used to pass the results of queries from repository
 * to the template.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
public class ProductWithOrderInfo {

	@Id
	private Long id;
	
	private String brand;
	
	@NotNull
	private String name;
	
	@NotNull
	private BigDecimal grossPrice;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private BigDecimal grossSum;
	

	/**
	 * Empty contructor.
	 */
	public ProductWithOrderInfo() {
		super();
	}

	/**
	 *  The contructor with all parameters.
	 *  
	 * @param id
	 * @param brand
	 * @param name
	 * @param grossPrice
	 * @param quantity
	 * @param grossSum
	 */
	public ProductWithOrderInfo(Long id, String brand, @NotNull String name, @NotNull BigDecimal grossPrice,
			@NotNull int quantity, @NotNull BigDecimal grossSum) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.grossPrice = grossPrice;
		this.quantity = quantity;
		this.grossSum = grossSum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(BigDecimal grossPrice) {
		this.grossPrice = grossPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getGrossSum() {
		return grossSum;
	}

	public void setGrossSum(BigDecimal grossSum) {
		this.grossSum = grossSum;
	}
}

