package com.kasperowski.rentit;

import com.kasperowski.rentit.Car;

public interface CarDAO {
	
//	CarDAO getCarDAO();

	void add(Car car);

	Car findAvailableCar();

	int getNumberOfAvailableCars();
	
	void initialize();
}
