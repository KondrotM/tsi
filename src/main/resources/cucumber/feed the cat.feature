Feature: Is the cat hungry?
  The cat requires food to survive
  Scenario: The cat requires food to survive
    Given The cat is hungry
    When The bowl is empty
    Then The cat should "meow"
