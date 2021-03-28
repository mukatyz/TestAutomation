@automationPractice:checkoutScreen
Feature: As certification analyst
  I need to validate the functionality add to the automationpractice application cart

  Background:
    Given that the user open the web page

  Scenario: verify checkout screen after choose two products
    Given the user search dress and choose the products
    When open screen checkout
    Then should see choosen products in checkout screen
    And should see total value in the checkout screen

  Scenario: verify checkout screen after choose two products and refresh the web page
    Given the user open checkout screen to see the products for dress choosen
    When refresh the web page
    Then should see total value in the checkout screen
    And should see choosen products in checkout screen

