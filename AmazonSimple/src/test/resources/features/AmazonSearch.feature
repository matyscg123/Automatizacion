@Amazon
Feature: Test Amazon search functionality


  @Cart
  Scenario Outline: As Customer when I search for alexa, I want to see if the third option on the second page is available for purchase and can be added to the card.
    Given the user navigates to www.amazon.com
    And searches for <Product>
    And navigates to the second page
    And selects the third item
    Then the user is able to add it to the card

    Examples:
            |Product    |
            |Alexa      |
            |PLaystation|

