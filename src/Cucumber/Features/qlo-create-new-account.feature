@quick
Feature: Account creation
  Scenario Outline: : Create an account

    Given user is on the authentication page
    When user inputs <email> into email address field
    And user clicks Create an account button
    When user fills Stanislaw, Kowalski and admin1
    And user clicks Register button
    Then success message appears

    Examples:
    |email            |
    |janek22@mail.com |