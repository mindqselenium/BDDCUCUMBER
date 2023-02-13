@login
Feature: login feature file

  @positive
  Scenario: ohrms login_positive_scenarios
    Given user needs to be on login page
    When user enters "Admin" and "admin123"
    And user needs to click on login button
    Then user is landed on dashboard page
    And user is loggedout from application
    Then finally close the browser

   @negative
   Scenario: ohrms login_negative_scenarios
    Given user needs to be on login page
    When user enters "<username>" and "<password">
    And user needs to click on login button
    Then user is in the same login page
    Then finally close the browser
    
    Examples:
    |username|password|
    |admin   |admin123|
    |Admin   |Admin123|
    |Admin   |        |
    |        |admin123|
    |administrator|admin@123|