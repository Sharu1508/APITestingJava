package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jdk.security.jarsigner.JarSigner;
import org.json.simple.JSONObject;


import static org.junit.Assert.*;

public class Products {
    public  int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParams;
    public JsonPath jsonpath;
    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint(){
        RestAssured.baseURI="https://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest=RestAssured.given();
        response = httpRequest.get("products");

    }
    @Then("I receive the response code as {}")
    public void i_receive_the_response_code_as(Integer int1) {
        ResponseCode= response.getStatusCode();
        assertEquals(ResponseCode, 200);

    }
    @Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {
        body =  response.getBody();
        String responseBody=body.asString();
        JsonPath jsnpath =  response.jsonPath();

        String s = jsnpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate, s);
    }

    @Given("I hit the url of post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint() {
        RestAssured.baseURI= "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        requestParams= new JSONObject();
     }

    @And("I pass the request body of the {}")
    public void iPassTheRequestBodyOfThe(String title) {

        requestParams.put("title",title);
        requestParams.put("price","13.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        Response response =httpRequest.post("products");
        ResponseBody body = response.getBody();
        jsonpath = response.jsonPath();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @Then("I receive the response body with id as {}")
    public void iReceiveTheResponseBodyWith(String id) {
        String s = jsonpath.getJsonObject("id").toString();
        assertEquals(id,s);

    }


    @Given("I hit the url of put products api endpoint")
    public void iHitTheUrlOfPutProductsApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParams = new JSONObject();
        
    }

    @When("I pass the url of products in the request with {}")
    public void iPassTheUrlOfProductsInTheRequestWith(String productnumber) {
        httpRequest = RestAssured.given();

        requestParams.put("title","test product");
        requestParams.put("price","13.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.get("products/"+productnumber);
        ResponseBody body = response.getBody();
        jsonpath = response.jsonPath();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Given("I hit the url of delete products api endpoint")
    public void iHitTheUrlOfDeleteProductsApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url of delete products in the request with {}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productnumber) {
        httpRequest = RestAssured.given();

        requestParams.put("title","test product");
        requestParams.put("price","13.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.get("products/"+productnumber);
        ResponseBody body = response.getBody();
        jsonpath = response.jsonPath();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}
