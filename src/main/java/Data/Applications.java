package Data;

import org.json.JSONArray;
import org.json.JSONObject;

public class Applications {
    public JSONObject createApplications(){

        JSONObject createApp = new JSONObject();
        JSONObject appDetails = new JSONObject();
        JSONArray identifier = new JSONArray();
        appDetails.put("host_name", "API automation application");
        appDetails.put("name", "API");
        appDetails.put("notes", "localhost");
        appDetails.put("priority", "10");
        appDetails.put("owner", "Venkata");
        appDetails.put("repo_url", "http://127.0.0.0");
        appDetails.put("team_name", "API Team");
        appDetails.put("business_units", "API business unit");
        appDetails.put("external_facing", false);

        identifier.put("hello");
        identifier.put("it");
        identifier.put("is");
        identifier.put("me");

        appDetails.put("identifiers", identifier);
        createApp.put("application", appDetails);

        return createApp;
    }
}
