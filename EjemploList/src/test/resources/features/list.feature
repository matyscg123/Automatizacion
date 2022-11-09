Feature: I can a city inside a state.

  @List
  Scenario Outline: Scenario Outline name: as a Test Engineer, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search <state>  in the list
    Then I can find the <city> in the list

    #Para correr diferentes variables
    Examples:
      | state      | city                |
      | Washington | Seattle, Washington |
      | Chicago    | Chicago, Illinois   |