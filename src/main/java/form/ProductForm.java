package form;

import java.math.BigDecimal;

public class ProductForm {

	private String name;
	private String brand;
	private int quantity;
	private String category;
	private BigDecimal netPrice;
	private BigDecimal grossPrice;
	private int taxRate;
	private int quantityInWarehouse;
	private int quantityInStore;
	private String unit;

	public ProductForm( String name, String brand, int quantity, String category,
			 BigDecimal netPrice,  BigDecimal grossPrice,  int taxRate,
			 int quantityInWarehouse,  int quantityInStore,  String unit) {
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

	public ProductForm() {
		super();
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
