@smoke
  Feature: F08 | wishlist message
    Scenario: check that wishlist message is displayed.
      Given press on the wishlist button.
      Then the wishlist message appears and its colo is green.

      Scenario: open the wishlist page and get the quantity value.
        Given press the wishlist button.
        And open wishlist screen and check the quantity
