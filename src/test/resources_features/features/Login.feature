Feature: Login feature

  Scenario: As a user I should be able to login successfully with valid credentials
    Given user is on the login page
    When user enters username "vpak2255@gmail.com" and password "Test1!"
    Then favorite button is displayed