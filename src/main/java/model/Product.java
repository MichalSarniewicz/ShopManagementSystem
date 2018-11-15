package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create products.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	private String brand;

	@NotNull
	private int quantity;

	private String category;

	@NotNull
	private BigDecimal netPrice;

	@NotNull
	private BigDecimal grossPrice;

	@NotNull
	private int taxRate;

	@NotNull
	private int quantityInWarehouse;

	@NotNull
	private int quantityInStore;

	@NotNull
	private String unit;

	/**
	 * The contructor of the product with all parameters
	 * 
	 * @param name
	 * @param brand
	 * @param quantity
	 * @param category
	 * @param netPrice
	 * @param grossPrice
	 * @param taxRate
	 * @param quantityInWarehouse
	 * @param quantityInStore
	 * @param unit
	 */
	public Product(@NotNull String name, String brand, @NotNull int quantity, String category,
			@NotNull BigDecimal netPrice, @NotNull BigDecimal grossPrice, @NotNull int taxRate,
			@NotNull int quantityInWarehouse, @NotNull int quantityInStore, @NotNull String unit) {
		super();
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.category = category;
		this.netPrice = netPrice;
		this.grossPrice = grossPrice;
		this.taxRate = taxRate;
		this.quantityInWarehouse = quantityInWarehouse;
		this.quantityInStore = quantityInStore;
		this.unit = unit;
	}

	/**
	 * Empty contructor of the Product
	 */
	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(BigDecimal grossPrice) {
		this.grossPrice = grossPrice;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public int getQuantityInWarehouse() {
		return quantityInWarehouse;
	}

	public void setQuantityInWarehouse(int quantityInWarehouse) {
		this.quantityInWarehouse = quantityInWarehouse;
	}

	public int getQuantityInStore() {
		return quantityInStore;
	}

	public void setQuantityInStore(int quantityInStore) {
		this.quantityInStore = quantityInStore;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
