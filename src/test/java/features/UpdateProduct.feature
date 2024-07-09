Feature: Update products using PUT API

 Scenario Outline: Validate put product api status code works correctly
    Given I hit the url of put products api endpoint
    When I pass the url of products in the request with <Productnumber>
    Then I receive the response code as 200
   Examples:
     | Productnumber |
     | 6             |


