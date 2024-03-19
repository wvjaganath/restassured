import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
