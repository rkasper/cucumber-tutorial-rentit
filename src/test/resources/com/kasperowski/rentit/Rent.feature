Feature: Rental cars should be possible to rent to gain revenue to the rental company.
  
  You can write anything you want here. How about some background info? Maybe a user story?
  Perhaps a Jira ID number? Anything goes.
  
  As an owner of a car rental company
  I want to make cars available for renting
  So I can make money

   Scenario: Find and rent a car
     Given there are 18 cars available for rental
     When I rent one
     Then there will only be 17 cars available for rental
     
  Scenario Outline: Find and rent a car, with examples
    Given there are "<available-cars>" cars available for rental
    When I rent one
    Then there will only be "<remaining-cars>" cars available for rental

    Examples: 
      | available-cars | remaining-cars |
      | 99             | 98             |
      | 18             | 17             |
      | 1              | 0              |
      | 6              | 5     			|
