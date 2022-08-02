package com.lp.allocation.service;

import com.lp.allocation.model.FuelStock;
import com.lp.order.model.Order;

public interface StockUpdateService {

	void updateStock(Order order, FuelStock fuelStock);

}
