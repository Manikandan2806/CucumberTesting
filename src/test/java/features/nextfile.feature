Feature: Get the house details from NoBroker.in

  Scenario: Go to NoBroker site and get the house details
    Given User should open the Site
    When User should select the city
    Then User should select the First area and check the text Add more...
    And User should select the Second area and check the text Add more...
    And User should select the Third area and check the text Add more...
    Then User click the search button and click Got it button
    And User select the price range and get the house details
    And User scroll the price range and get the house details
