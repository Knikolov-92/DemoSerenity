# new feature
# Tags: optional
#@driver:chrome
Feature: Add products to shopping cart

Background: John has navigated to the shopping page for dresses
  Given John is on the dresses-shopping page

  Scenario: John sees the empty cart on page
    Then John should see the empty cart on page

  @debug
  Scenario: Adding first 3 products to cart
    When John adds the first 3 products to cart
    Then John should see the 3 added products in cart

    #Scenario Outline: Adding products to cart
    #When John adds first <amount> product(s) to cart
    #Then John should see the added products in cart
    #
    # Examples:
    #  | amount |
     # | 3      |