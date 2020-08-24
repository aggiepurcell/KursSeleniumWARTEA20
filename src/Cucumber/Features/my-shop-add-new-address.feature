Feature: Add new address after login

  Scenario Outline: Add new address for logged user

    Given User is logged in to CodersLab shop - new address test
    When User goes to new address page
    When User fills alias "<alias>"
    And User fills Address "<address>"
    And User fills City "<city>"
    And User fills Zip "<zip>"
    And User clicks Save button
    Then User sees "Address successfully added!" - new address test

    Examples:
    |alias  |address      |city     |zip    |
    |alias1 |Poziomkowa 12|Warszawa |00-001 |
    |alias2 |Karolkowa 55 |Warszawa |00-111 |
    |alias3 |Poziomkowa 12|Poznań   |00-001 |