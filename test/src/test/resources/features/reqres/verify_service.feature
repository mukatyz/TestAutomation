@reqres
Feature: As certification analyst
  I need to validate the functionalities of reqres service

  Scenario: Verify Create user funcionality
    Given The user Create an user whit the information
      | name | job     |
      | katy | gerente |
    Then should see the service response was 201
    And Should see the id was created

  Scenario: Validate create user funcionality by checking in users list
    Given The user Create an user whit the information
      | name | job     |
      | katy | gerente |
    Then should see the user information in the user list

  Scenario: Verify Delete funcionality
    Given The user delete an user
      | id |
      | 2  |
    Then should see the service response was 204
    And shouldn't see the user information in the user list

  Scenario: Verify List Users correspondence between the total users per page and users per page
    Given The user consult the Users List
    Then should see the service response was 200
    And should see the information correspondence

  Scenario: Verify List Users funcionality after Create an user
    Given The user Create an user whit the information
      | name | job     |
      | katy | gerente |
    And The user consult the Users List
    Then should see the user in users list

  Scenario: Verify List Users funcionality after delete an user
    Given The user delete an user
      | id |
      | 2  |
    And The user consult the Users List
    Then shouldn't see the user in users list

