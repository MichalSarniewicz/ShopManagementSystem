package model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create orders.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal netPrice;
	
	@NotNull
	private BigDecimal grossPrice;
	
	@NotNull
	private Timestamp dateAndTime;

	@NotNull
	private int employeeId;

	@NotNull
	private int cashdeskId;

	/**
	 * Empty constructor.
	 */
	protected Order() {
	}
	
	/**
	 * Costructor with all parameters.
	 * 
	 * @param netPrice
	 * @param grossPrice
	 * @param dateAndTime
	 * @param employeeId
	 * @param cashdeskId
	 */
	public Order( @NotNull BigDecimal netPrice, @NotNull BigDecimal grossPrice, @NotNull Timestamp dateAndTime,
			@NotNull int employeeId, @NotNull int cashdeskId) {
		super();
		this.netPrice = netPrice;
		this.grossPrice = grossPrice;
		this.dateAndTime = dateAndTime;
		this.employeeId = employeeId;
		this.cashdeskId = cashdeskId;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCashdeskId() {
		return cashdeskId;
	}

	public void setCashdeskId(int cashdeskId) {
		this.cashdeskId = cashdeskId;
	}
}
