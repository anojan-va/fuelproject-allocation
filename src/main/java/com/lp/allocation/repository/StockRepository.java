package com.lp.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.allocation.model.FuelStock;

@Repository
public interface StockRepository extends JpaRepository<FuelStock, Integer>{

}
