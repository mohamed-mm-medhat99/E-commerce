@smoke
Feature: F01_Register | users could register with new accounts

  Scenario:user could register with valid data successfully

    Given user go to register page
    And user select gender type and enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter email "test@example.com" field and password fields "P@ssw0rd" "P@ssw0rd"
    Then user clicks on register button
    And success message is displayed




