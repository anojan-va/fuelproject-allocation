package com.lp.allocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="fuel_stock")
@Data
public class FuelStock {
	@Id
	@Column(name="fuel_id")
	private String fuelId;
	@Column(name="fuel_name")
	private String fuelName;
	@Column(name="available_stock")
	private int availableStock;
	@Column(name="useable_stock")
	private int useableStock;
	@Column(name="reserved_stock")
	private int reservedStock;
	

}
