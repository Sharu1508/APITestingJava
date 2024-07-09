Feature: Insert products using POST API

 Scenario Outline: Validate post product api status code works correctly
    Given I hit the url of post products api endpoint
    When I pass the url of products in the request
    And I pass the request body of the <ProductTitle>
    Then I receive the response code as 200
   Examples:
     | ProductTitle |
     | Shoes        |


  Scenario Outline: Validate post product api response body works correctly
    Given I hit the url of post products api endpoint
    When I pass the url of products in the request
    And I pass the request body of the <ProductTitle>
    Then I receive the response body with id as <id>
    Examples:
      | ProductTitle | id |
      | Shoes        | 27 |





