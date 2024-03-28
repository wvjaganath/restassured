package Utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Base {
    static RequestSpecification Request;
    static RequestSpecBuilder builder;
    public static Properties config = new Properties();
    static File configFile = new File("config.properties");

    public static RequestSpecification getRequestSpecification() {
        try {

            config.load(Files.newInputStream(configFile.toPath()));
            String baseUrl = config.getProperty("url");
            String token = config.getProperty("apikey");
            builder = new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .setContentType(ContentType.JSON)
                    .setRelaxedHTTPSValidation()
                    .addHeader("X-Risk-Token", token);
            Request = given()
                    //.filter(new AllureRestAssured())
//                    .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                    .spec(builder.build());

            return Request;
        } catch (IOException e) {
            return null;
        }
    }


    public static Response get(String endpoint) {
        Request = getRequestSpecification();
        return Request.get(endpoint);
    }

    public static Response get(Map<String, String> pathParams, String endpoint) {
        Request = getRequestSpecification();
        Request.pathParams(pathParams);
        return Request.get(endpoint);
    }


    public static Response get(Map<String, String> Params, String endpoint, String paramType) {
        Request = getRequestSpecification();
        if (paramType.equalsIgnoreCase("query")) Request.queryParams(Params);
        else if (paramType.equalsIgnoreCase("path")) Request.pathParams(Params);
        return Request.get(endpoint);
    }

    public static Response put(String endpoint) {
        Request = getRequestSpecification();
        return Request.put(endpoint);
    }

    public static Response post(String endpoint) {
        Request = getRequestSpecification();
        return Request.post(endpoint);
    }

    public static Response post(String RequestBody, String endpoint) {
        Request = getRequestSpecification();
        Request.body(RequestBody);
        Request.contentType("application/json");
        return Request.post(endpoint);
    }

    public static Response put(String RequestBody, String endpoint, Map<String, String> Params) {
        Request = getRequestSpecification();
        Request.pathParams(Params);
        Request.body(RequestBody);
        Request.contentType("application/json");
        Request.accept("application/json");
        return Request.put(endpoint);
    }

    public static Response post(Map<String, String> pathParams, File file, String endpoint) {
        Request = getRequestSpecification();
        Request.contentType("multipart/form-data");
        Request.multiPart("file", file);
        Request.multiPart("run", true);
        Request.pathParams(pathParams);
        return Request.post(endpoint);
    }

    public static Response delete(String endpoint, Map<String, String> Params) {
        Request = getRequestSpecification();
        Request.pathParams(Params);
        return Request.delete(endpoint);
    }

}
