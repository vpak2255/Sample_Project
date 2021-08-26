Feature: Login Page

  Background: user is on the login page
    Given user is on the login page


  Scenario: As a user I should be able to see 6 shopping windows on Login Page
    Then user sees num 6 shopping windows displayed
  @shopping_windows
  Scenario: As a user I should be able to search any item
    When user enters item name "apple" and clicks enter
    Then user sees title contains "Apple"