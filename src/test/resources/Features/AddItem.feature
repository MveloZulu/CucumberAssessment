
Feature: Product Store

  Scenario Outline: As a User I want to purchase a laptop from the product store
    Given I am on the product store page
    When I click on the laptops
    And I click on first laptop
    And I click on add to cart button
    Then I should see the pop up message
    When I click ok button
    And I click on add to cart link
    Then I should see the item in my cart
    When I click on the place order button
    And I click on purchase button without entering any details
    And I click on ok button
    And I enter my name <name>
    And I enter country <country>
    And I enter city <city>
    And I enter credit card number <creditCardNumber>
    And I enter month <month>
    And I enter year <year>
    And I click on purchase button
    Then I should see the purchase confirmation message
    And I click okay button
    Then I should see the product store page
    Examples:
      | name  | country | city      | creditCardNumber | month | year |
      | Mvelo | South Africa | Cape Town | 1234567890123456 | 12    | 2025 |



