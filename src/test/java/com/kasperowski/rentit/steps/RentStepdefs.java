package com.kasperowski.rentit.steps;

import static org.junit.Assert.assertEquals;
import com.kasperowski.rentit.CarDAO;
import com.kasperowski.rentit.InMemoryCarDAO;
import com.kasperowski.rentit.Car;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RentStepdefs {
    private CarDAO carDatabase;

    @Given("^there are (\\d+) cars available for rental$")
    public void there_are_cars_available_for_rental(int availableCars) throws Throwable {
    	carDatabase = InMemoryCarDAO.getCarDAO();
        for (int i = 0; i < availableCars; i++) {
            Car car = new Car();
            carDatabase.add(car);
        }
    }

    @When("^I rent one$")
    public void rent_one_car() throws Throwable {
    	Car car = carDatabase.findAvailableCar();
        car.rent();
    }

    @Then("^there will only be (\\d+) cars available for rental$")
    public void there_will_be_less_cars_available_for_rental(int expectedAvailableCars) throws Throwable {
    	int actualAvailableCars = carDatabase.getNumberOfAvailableCars();
    	assertEquals(expectedAvailableCars, actualAvailableCars);
    }
    
    @Given("^there are \"([^\"]*)\" cars available for rental$")
    public void there_are_cars_available_for_rental(String availableCarsString) throws Throwable {
    	int availableCars = Integer.parseInt(availableCarsString);
    	carDatabase = InMemoryCarDAO.getCarDAO();
    	carDatabase.initialize(); // Reset the cars database for each test
        for (int i = 0; i < availableCars; i++) {
            Car car = new Car();
            carDatabase.add(car);
        }
    }

    @Then("^there will only be \"([^\"]*)\" cars available for rental$")
    public void there_will_only_be_cars_available_for_rental(String expectedAvailableCarsString) throws Throwable {
    	int expectedAvailableCars = Integer.parseInt(expectedAvailableCarsString);
    	int actualAvailableCars = carDatabase.getNumberOfAvailableCars();
    	assertEquals(expectedAvailableCars, actualAvailableCars);
    }
}
