@automationPractice:cart
Feature: As certification analyst
  I need to validate the functionality add to the automationpractice application cart

  Background:
    Given that the user open the web page

  Scenario: verify cart after to choose two products
    When the user search dress and choose the products
    Then should see 2 number in the cart

  Scenario: verify checkout screen after choose two products
    Given the user search dress and choose the products
    When open cart box
    Then should see total value in the cart screen
    And should see choosen products in cart screen

  Scenario: verify cart after choose two products and refresh the screen
    Given the user search dress and choose the products
    When refresh the web page
    And open cart box
    Then should see total value in the cart screen
    And should see choosen products in cart screen



