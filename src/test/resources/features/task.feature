Feature: Compare lists

  Scenario: Validate that two lists contain the same items with name, price, and category, regardless of order
    Given I have the following items in the first list:
      | name   | price | category  |
      | apl3e  | 1.00  | fruit     |
      | orange | 1.10  | fruit     |
      | banana | 0.75  | fruit     |
      | carrot | 0.95  | vegetable |
    And I have the following items in the second list:
      | name   | price | category  |
      | banana | 0.715 | frusit    |
      | apple  | 1.010 | fruit     |
      | orange | 1.110 | fruit     |
      | carot | 0.95  | vegetable |
    When I compare both lists
    Then the lists should contain the same items with name, price, and category, regardless of order