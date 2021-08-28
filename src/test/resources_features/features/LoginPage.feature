@login_page
Feature: Login Page

  Background: user is on the login page
    Given user is on the login page

  Scenario: As a user I should be able to see 6 shopping windows on Login Page
    Then user sees num 6 shopping windows displayed
  @shopping_windows
  Scenario: As a user I should be able to search any item
    When user enters item name "apple" and clicks enter
    Then user sees title contains "Apple"
  @Jewelry_&_Accessories
    Scenario: As a user I should be able to click on Jewelry & Accessories button and be navigated to its page
      When user clicks on Jewelry Accessories button
      Then user sees title contains "Jewelry & Accessories"