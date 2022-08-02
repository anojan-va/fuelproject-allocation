package com.lp.allocation.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.model.FuelStock;
import com.lp.allocation.repository.StockRepository;
import com.lp.order.model.Order;

@Service
public class StockUpdateServiceImpl implements StockUpdateService {
	
	
	
	
	@Autowired
	StockRepository stockRepository;
	
	

	@Override
	public void updateStock(Order order, FuelStock fuelStock) {
		
		FuelStock fuelUpdatedStock = new FuelStock();
		fuelUpdatedStock.setAvailableStock(fuelStock.getAvailableStock());
		fuelUpdatedStock.setFuelId(fuelStock.getFuelId());
		fuelUpdatedStock.setFuelName(fuelStock.getFuelName());
		fuelUpdatedStock.setReservedStock(fuelStock.getReservedStock()+order.getQuantity());
		fuelUpdatedStock.setUseableStock(fuelStock.getUseableStock()-order.getQuantity());
		
		// update the database after reservation 
		
		stockRepository.save(fuelUpdatedStock);
		
	}
	

}
