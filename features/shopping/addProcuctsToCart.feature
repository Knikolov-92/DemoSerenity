# new feature
# Tags: optional
#@driver:chrome
Feature: Add products to shopping cart

#Background: John has navigated to the shopping page for dresses


  Scenario: John sees the empty cart on page load
    Given John is on the dresses-shopping page
    Then John should see the empty cart on page


  Scenario: Adding first 3 products to cart(dresses)
    Given John is on the dresses-shopping page
    When John adds the first 3 products to cart
    Then John should see the 3 added products in cart


  Scenario: Adding first 3 products to cart(women)
    Given John is on the women-shopping page
    When John adds the first 3 products to cart
    Then John should see the 3 added products in cart


  Scenario Outline: Successful adding of a product(women)
  Given John is on the women-shopping page
  When John selects a product:
    | name   | price   |
    | <name> | <price> |
  And John adds the product to the cart:
    | color   | quantity   | size   |
    | <color> | <quantity> | <size> |
  Then The successful adding-product-to-cart-message "<message>" is displayed
  When John proceeds to the Cart page
  Then The selected item should be displayed in the cart:
    | name   | price   | color   | quantity   | size   |
    | <name> | <price> | <color> | <quantity> | <size> |

  Examples:
    | name   | price | color | quantity | size | message |
    | Blouse | 27.00 | White | 2        | M    | Product successfully added to your shopping cart |

  @debug
  Scenario Outline: Successful adding of a product(dresses)
    Given John is on the dresses-shopping page
    When John selects a product:
      | name   | price   |
      | <name> | <price> |
    And John adds the product to the cart:
      | color   | quantity   | size   |
      | <color> | <quantity> | <size> |
    Then The successful adding-product-to-cart-message "<message>" is displayed
    When John proceeds to the Cart page
    Then The selected item should be displayed in the cart:
      | name   | price   | color   | quantity   | size   |
      | <name> | <price> | <color> | <quantity> | <size> |

    Examples:
      | name                 | price | color | quantity | size | message |
      | Printed Summer Dress | 30.50 | White | 5        | L    | Product successfully added to your shopping cart |
  #Scenario Outline: Adding products to cart
    #When John adds first <amount> product(s) to cart
    #Then John should see the added products in cart
    #
    # Examples:
    #  | amount |
     # | 3      |