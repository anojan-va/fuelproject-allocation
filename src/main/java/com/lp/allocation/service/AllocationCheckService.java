package com.lp.allocation.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.model.FuelStock;
import com.lp.allocation.repository.StockRepository;
import com.lp.order.model.OrderEvent;

@Service
public class AllocationCheckService{

	
	@Autowired
	StockRepository stockRepository;
	@Autowired
	StockUpdateServiceImpl stockUpdateService;
	

	public void checkStock(OrderEvent event) {
		
		
		Optional<FuelStock> fuelstockopt= stockRepository.findById(92);
		//Optional<FuelStock> fuelstockopt= stockRepository.findById(event.getOrder().getFuelType());
		if(fuelstockopt.isPresent()) {
			System.out.println(fuelstockopt.get().getUseableStock());
			if(fuelstockopt.get().getUseableStock()>=event.getOrder().getQuantity()) {
				stockUpdateService.updateStock(event.getOrder(),fuelstockopt.get());
				System.out.println("Allocation Sucess ...!");
			}
		}else {
			System.out.println("Data is empty");
		}
		
		/*
		FuelStock fs = new FuelStock();
		
		fs.setFuelId(96);
		fs.setFuelName("PS95");
		fs.setReservedStock(0);
		fs.setUseableStock(100);
		System.out.println(fs.toString());

		return stockRepository.save(fs);
		 */
	}

	

}
