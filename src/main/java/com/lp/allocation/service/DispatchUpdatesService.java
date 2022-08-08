package com.lp.allocation.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.model.FuelStock;
import com.lp.allocation.repository.StockRepository;
import com.lp.order.model.OrderEvent;

@Service
public class DispatchUpdatesService {
	
	@Autowired
	StockRepository stockRepository;
	
	public void updateDispatchStatus(OrderEvent event) {
		
		// get the fuelstock and update 
		
		
		
		
		
		FuelStock updatedFuelStock = stockRepository.findByFuelId("Petrol 92");
		
	
		//System.out.println("TEst3"+stockopt.get().getAvailableStock());
		//System.out.println("TEST5T"+event.getOrder().getQuantity());
		
		updatedFuelStock.setAvailableStock(updatedFuelStock.getAvailableStock()-event.getOrder().getQuantity());
		updatedFuelStock.setReservedStock(updatedFuelStock.getReservedStock()-event.getOrder().getQuantity());
		
		// save the updated stock
		
		stockRepository.save(updatedFuelStock);
		
	}

}
