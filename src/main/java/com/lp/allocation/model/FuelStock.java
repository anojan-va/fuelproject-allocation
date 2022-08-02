package com.lp.allocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fuel_stock")
public class FuelStock {
	@Id
	@Column(name="fuel_id")
	private int fuelId;
	@Column(name="fuel_name")
	private String fuelName;
	@Column(name="available_stock")
	private int availableStock;
	@Column(name="useable_stock")
	private int useableStock;
	@Column(name="reserved_stock")
	private int reservedStock;
	
	// getters and setters
	
	public int getFuelId() {
		return fuelId;
	}
	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}
	public String getFuelName() {
		return fuelName;
	}
	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}
	public int getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	public int getUseableStock() {
		return useableStock;
	}
	public void setUseableStock(int useableStock) {
		this.useableStock = useableStock;
	}
	public int getReservedStock() {
		return reservedStock;
	}
	public void setReservedStock(int reservedStock) {
		this.reservedStock = reservedStock;
	}
	

}
