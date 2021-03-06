package model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create OrderWithOrderDetailsInfo objects.
 * These objects are used to pass the results of queries from repository
 * to the template.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
public class OrderWithOrderDetailsInfo {

	@Id
	private Long id;
	
	@NotNull
	private Timestamp dateAndTime;

	@NotNull
	private int quantity;

	/**
	 * Empty contructor.
	 */
	public OrderWithOrderDetailsInfo() {
		super();
	}
	
	/**
	 * The contructor with all parameters.
	 * 
	 * @param id
	 * @param dateAndTime
	 * @param quantity
	 */
	public OrderWithOrderDetailsInfo(Long id, @NotNull Timestamp dateAndTime, @NotNull int quantity) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}