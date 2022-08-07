@smoke
Feature: F04_search | user could search using product name or sku name
  Scenario Outline: search with different key words
  When writes the search word <name>
  And click on the search button
  Then the url should be changed
  And search show relevant results <name>
  Examples:
            |name|
            |"book"|
            |"laptop"|
            |"nike"|


  Scenario Outline: search with different sku
  When write the search sku <number>
  And click on the search button.
  And navigate to the product details screen
  Then check that the search number equals the number appears on the page <number>
  Examples:
            |number|
            |"SCI_FAITH"|
            |"APPLE_CAM"|
            |"SF_PRO_11"|
