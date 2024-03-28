import Utilities.APIEndpoints;
import Utilities.Base;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class Applications {
    String jsonData;

    {
        try {
            jsonData = new String(Files.readAllBytes(Paths.get("src/main/java/Data/appsecdashcreate.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    JSONObject jsonObject = new JSONObject(jsonData);
    Map<String, String> pathParam = new HashMap<>();

    @Test(description = "List all applications")
    public void listApplication() {
        Response listApplications = Base.get(APIEndpoints.listApplications.getResource());
        assertEquals(listApplications.getStatusCode(), 200);
        MatcherAssert.assertThat(
                listApplications.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("AppsecApplications.json"));
    }

    @Test(description = "CRUD application")
    public void crudApplication() {
        //Create Application
        Response createApplication = Base.post(jsonObject.getJSONObject("createApplication").toString(),
                APIEndpoints.createApplication.getResource());
        String applicationID = createApplication.jsonPath().getString("application.id");
        Assert.assertEquals(createApplication.getStatusCode(), 200);
        MatcherAssert.assertThat(
                createApplication.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateApplications.json"));
        assertEquals(createApplication.jsonPath().getString("application.owner"),
                jsonObject.getJSONObject("createApplication").getJSONObject("application").getString("owner"));

        pathParam.put("id", applicationID);

        //Update Application
        Response updateApplication = Base.put(jsonObject.getJSONObject("updateApplication").toString(),
                APIEndpoints.updateApplication.getResource(), pathParam);
        Assert.assertEquals(updateApplication.getStatusCode(), 200);
        MatcherAssert.assertThat(
                updateApplication.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateApplications.json"));
        Assert.assertEquals(updateApplication.jsonPath().getString("application.name"),
                jsonObject.getJSONObject("updateApplication").getString("name"));
        Assert.assertEquals(updateApplication.jsonPath().getString("application.priority"),
                jsonObject.getJSONObject("updateApplication").getString("priority"));

        //Delete Application
        Response deleteApplication = Base.delete(APIEndpoints.updateApplication.getResource(), pathParam);
        Assert.assertEquals(updateApplication.getStatusCode(), 200);

    }
}
