import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.internal.scripts.JO;
import org.hamcrest.CoreMatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;



public class TestClass {
    @Test
    public void petTestGet() {
        String getUrl = "https://petstore.swagger.io/v2/pet/findByStatus?status={status}";
        String[] array = {"available","pending","sold"};
        for (String param:array) {
            RestAssured
                    .when()
                    .get(getUrl, param)
                    .then()
                    .assertThat().statusCode(200)
                    .extract().response().prettyPrint();
            //.body("status", CoreMatchers.equalTo("sold"));
        }
    }

    @Test
    public void petTestPost(){
        String urlPost = "https://petstore.swagger.io/v2/pet/";
        BodyClass body = new BodyClass();

        System.out.println(body.requestBody.toString());

        //Post запрос
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("api_key", "123456")
                    .body(body.requestBody.toString())
                .when()
                    .post(urlPost)
                .then()
                    .assertThat().statusCode(200)
                    .extract().response().prettyPrint();
    }

    @Test
    public void petTestPut(){
        String urlPut = "https://petstore.swagger.io/v2/pet/";
        BodyClass body = new BodyClass();

        System.out.println(body.requestBody.toString());

        //Post запрос
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("api_key", "123456")
                .body(body.requestBody.toString())
                .when()
                .put(urlPut)
                .then()
                .assertThat().statusCode(200)
                .extract().response().prettyPrint();
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
    }
}
