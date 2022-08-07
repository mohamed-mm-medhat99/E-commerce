@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user press facebook link
  When  user opens facebook link
  Then  "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user open twitter link
  When user opens twitter link
  Then "https://twitter.com/nopCommerce" is opened in a new tab

  Scenario: user open rss link
  When user opens rss link
  And "https://demo.nopcommerce.com/new-online-store-is-open" is opened

  Scenario: user open youtube link
  When user opens youtube link
  Then "https://www.youtube.com/user/nopCommerce" is opened successfully