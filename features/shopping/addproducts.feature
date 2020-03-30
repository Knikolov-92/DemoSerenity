# new feature
# Tags: optional
#@driver:chrome
Feature: Add products to shopping cart


  Scenario: John is redirected to Dresses page
    Given John is on the Base page
    When John clicks on "Dresses" button
    Then John should be on the Dresses-shopping page

  @debug
  Scenario: Adding products to cart
    Given John is on the dresses-shopping page
    When John clicks on a product to add
    Then John should see the products in cart
