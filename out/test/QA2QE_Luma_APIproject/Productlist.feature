Feature:Customer is able view the product list on all pages

/*As a User
I want to enter a product name in search field and click on search
So that i can view a list of search results*/

  Scenario:View the Product list results

    Given That the customer is on the Home page
    When  The customers Enter a Product name and clicks the search icon to search
    Then  The system should return a list of search results