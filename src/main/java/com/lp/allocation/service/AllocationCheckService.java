package com.lp.allocation.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.model.Allocation;
import com.lp.allocation.model.FuelStock;
import com.lp.allocation.repository.StockRepository;
import com.lp.order.model.OrderEvent;

@Service
public class AllocationCheckService{

	
	@Autowired
	StockRepository stockRepository;
	@Autowired
	StockUpdateServiceImpl stockUpdateService;
	@Autowired
	AllocationResponseService allocationResponseService;
	@Autowired
	AllocationService allocationService;

	public void checkStock(OrderEvent event) {
		
		
		Optional<FuelStock> fuelstockopt= stockRepository.findById(92);
		//Optional<FuelStock> fuelstockopt= stockRepository.findById(event.getOrder().getFuelType());
		if(fuelstockopt.isPresent()) {
			
			System.out.println(fuelstockopt.get().getUseableStock());
			
			if(fuelstockopt.get().getUseableStock()>=event.getOrder().getQuantity()) {
				
				// Update the Fuel Stock
				stockUpdateService.updateStock(event.getOrder(),fuelstockopt.get());
				
				// Update the Allocation Table
				Allocation allocation = allocationService.allocate(event.getOrder());
				
				
				event.getOrder().setAllocationId(allocation.getAllocationId());
				event.getOrder().setOrderStatus("Allocated");
				event.getOrder().setStatusDate(java.time.LocalDate.now());
				
				
				System.out.println("Allocation Sucess ...!");
				
				//Send Kafka message => Allocation Success 
				allocationResponseService.produceAllocationResponse(event.getOrder());
				
			}
		}else {
			System.out.println("Data is empty");
		}
		
		
	}

	

}
