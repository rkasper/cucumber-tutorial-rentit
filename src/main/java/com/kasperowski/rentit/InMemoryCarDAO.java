package com.kasperowski.rentit;

import java.util.LinkedList;
import java.util.List;

import com.kasperowski.rentit.Car;

public class InMemoryCarDAO implements CarDAO {
	private static CarDAO instance;
	private List<Car> cars;
	public boolean initialized = false;

	private InMemoryCarDAO() {
	}

	// TODO Wow, this Singleton code is really messy! Improve it!
	public static CarDAO getCarDAO() {
		if (instance == null) {
			instance = new InMemoryCarDAO();
			if (!((InMemoryCarDAO) instance).initialized) {
				instance.initialize();
			}
		}
		return instance;
	}

	public void add(Car car) {
		cars.add(car);
	}

	public Car findAvailableCar() {
		for (Car car : cars) {
			if (!car.isRented()) {
				return car;
			}
		}
		throw new RuntimeException("No car available");
	}

	public int getNumberOfAvailableCars() {
		int availableCars = 0;
		for (Car car : cars) {
			if (!car.isRented()) {
				availableCars++;
			}
		}
		return availableCars;
	}

	public void initialize() {
		cars = new LinkedList<Car>();
		initialized = true;
	}
}