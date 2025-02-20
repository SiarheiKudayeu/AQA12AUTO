package restassured;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryGetRequest {
    @Test
    public void getRequest() {
        RestAssured.baseURI = "https://reqres.in/";
        given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void getRequestV2() {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.get("/api/users?page=2");
        //Получили туло ответа в виде строки
        String responseString = response.getBody().asString();
        System.out.println(responseString);

        //Получаем ответ в виде JsonObject
        JsonObject jsonObjectResponse = JsonParser.parseString(responseString).getAsJsonObject();
        JsonArray listOfUsers = jsonObjectResponse.getAsJsonArray("data");
        System.out.println("Size of array is: " + listOfUsers.size());
        JsonObject user7 = listOfUsers.get(0).getAsJsonObject();
        String firstName = user7.get("first_name").getAsString();
        String id = user7.get("id").getAsString();
        System.out.println("Id : " + id + "\nfirst Name: " + firstName);
    }

    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://reqres.in/";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/users");

        System.out.println(response.getBody().asString());
    }

    @Test
    public void getToken() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        String body = "{\n" +
                "\n" +
                "\"clientName\": \"use12r\",\n" +
                "\n" +
                "\"clientEmail\": \"test@testwdw32.com\"\n" +
                "\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api-clients/");

        System.out.println(response.getBody().asString());
    }


    @Test
    public void getAllOrders() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        Response response = given()
                .header("Authorization", "Bearer 445bd0fa6029b75d094a1c5c06624830ef38c31ac192ddf0f0f3d0b4e5631af5")
                .when()
                .get("/orders");

        System.out.println(response.getBody().asString());
    }
}
