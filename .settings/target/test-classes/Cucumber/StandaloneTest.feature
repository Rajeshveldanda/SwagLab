
@tag
Feature: Purchase the Order from Ecommerse Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page
 
  @tag2
  Scenario Outline: Positive Test of submitting the order
    Given Logged on with username <username> and pasword <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order page
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username          											|    password 				| productName  				 |
      | performance_glitch_user       					|    secret_sauce		  | Sauce Labs Backpack  |
      
