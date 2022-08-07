@smoke

Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
  When user go to login page
  Then user login with valid "test0@example.com" and "P@ssw0rd"
  And user press on login button
  And user login to the system successfully


  Scenario: user could login with invalid email and password
  When user go to login page
  Then user login with invalid "wrong@example.com" and "P@ssw0rd"
  And user click on login button
  And user could not login to the system