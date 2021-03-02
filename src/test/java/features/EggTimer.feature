Feature: EggTimer scenarios

  Scenario: To validate EggTimer countdown with valid input - no units
    Given I navigate to url "https://e.ggtimer.com/"
    When I enter time with "25"
    When I click on Start button
    Then I validate countdown timer



