package Stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Bagliststepdefination<sessionToken> {
    private static String sessionToken="d7j89won2dj4ju34hhjhnqpat1kf2egj";
    public static  String baseUri = "https://magento.abox.co.za/rest/V1/";
    RequestSpecification request ;
    Response response;


    @Given("That the customer is on the Home page")
    public void that_the_customer_is_on_the_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", sessionToken);
        request =given()
                .headers(headers)
                .baseUri(baseUri)
                .basePath("search")
                .queryParam("searchCriteria[requestName]","quick_search_container")
                .queryParam("searchCriteria[filter_groups][0][filters][0][field]","search_term")
                .queryParam("searchCriteria[filter_groups][0][filters][0][value]","Bag");

    }

    @When("The customers Enter a Product name and clicks the search icon to search")
    public void the_customers_clicks_the_search_icon_to_search() {
        // Write code here that turns the phrase above into concrete actions

         response=request.when().get();

    }

    @Then("The system should return a list of search results")
    public void the_system_should_return_a_list_of_search_results() {
        // Write code here that turns the phrase above into concrete actions

        String responseString=response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .assertThat()
                .body("total_count",equalTo(10))
                .extract()
                .body().asString();
        System.out.println("Response String is :"+ responseString);


    }

}

