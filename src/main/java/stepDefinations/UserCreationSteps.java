package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

public class UserCreationSteps {

    Response response;

    @Given("API url is given")
    public void api_url_is_given() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @When("user makes request to API to create user using following data")
    public void user_makes_request_to_API_to_create_user_using_following_data(String docString) {
        response = given().accept(ContentType.JSON).body(docString).when().post("/api/users");
    }

    @Then("^response code should be (\\d+)$")
    public void response_code_should_be(Integer int1) {
        response.then().statusCode(int1);
    }

    @Then("response body should be as following")
    public void response_body_should_be_as_following(String docString) {
        assertEquals(docString, response.asString());
    }

    @And("^response body should contains following$")
    public void responseBodyShouldContainsFollowing(DataTable table) throws Throwable {
        List<List<String>> list = table.raw();
        response.then().body("name", equalTo(list.get(0)));
        response.then().body("job", equalTo(list.get(0)));
        response.then().body("id", equalTo(list.get(0)));
    }
}
