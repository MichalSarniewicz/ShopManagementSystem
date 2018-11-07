package app;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Supply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal netSum;
	
	@NotNull
	private BigDecimal grossSum;
	
	@NotNull
	private Timestamp dateAndTime;

	@NotNull
	private Long supplierId;

	public Supply() {
	}
	
	public Supply(Long id, @NotNull BigDecimal netSum, @NotNull BigDecimal grossSum, @NotNull Timestamp dateAndTime, Long supplierId) {
		super();
		this.id = id;
		this.netSum = netSum;
		this.grossSum = grossSum;
		this.dateAndTime = dateAndTime;
		this.supplierId = supplierId;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getNetSum() {
		return netSum;
	}

	public void setNetPrice(BigDecimal netSum) {
		this.netSum = netSum;
	}

	public BigDecimal getGrossSum() {
		return grossSum;
	}

	public void setGrossPrice(BigDecimal grossSum) {
		this.grossSum = grossSum;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
}
