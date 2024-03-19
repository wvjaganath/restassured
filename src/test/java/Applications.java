import Utilities.APIEndpoints;
import Utilities.Base;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Applications {

    @Test(description = "List all applications")
    public void listApplication() {
        Response listApplications = Base.get(APIEndpoints.listApplications.getResource());
        assertEquals(listApplications.getStatusCode(), 200);
//        System.out.println(listApplications.jsonPath().getString("applications[0]"));
        MatcherAssert.assertThat(
                listApplications.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("AppsecApplications.json"));
    }

    @Test(description = "Create applications")
    public void createApplication() {
        Data.Applications applications = new Data.Applications();
        Response createApplication = Base.post(applications.createApplications().toString(), APIEndpoints.createApplication.getResource());
        Assert.assertEquals(createApplication.getStatusCode(), 200);
        MatcherAssert.assertThat(
                createApplication.getBody().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateApplications.json"));
        assertEquals(createApplication.jsonPath().getString("application.owner"), applications.createApplications().getJSONObject("application").getString("owner"));
    }

}
