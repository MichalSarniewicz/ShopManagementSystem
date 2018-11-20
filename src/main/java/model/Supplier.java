package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This class is used to create suppliers.
 * 
 * @author Michał Sarniewicz
 *
 */
@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	private String adress;
	
	private String comment;

	@NotNull
	private long phoneNumber;

	@NotNull
	private String email;

	/**
	 * The contructor of the supplier with all parameters.
	 * 
	 * @param name
	 * @param adress
	 * @param comment
	 * @param phoneNumber
	 * @param email
	 */
	public Supplier( @NotNull String name, @NotNull String adress, String comment, @NotNull long phoneNumber,
			@NotNull String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.comment = comment;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Empty contructor.
	 */
	public Supplier() {
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
