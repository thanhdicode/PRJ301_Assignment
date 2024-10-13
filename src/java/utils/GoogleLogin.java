package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import java.io.IOException;
import model.Constants;
import model.UserGoogle;

/**
 * Utility class for handling Google login and token retrieval.
 * 
 * @author ADMIN
 */
public class GoogleLogin {

    
    public static String getToken(String code) throws ClientProtocolException, IOException {
        // Build and execute the HTTP POST request to get the token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form()
                        .add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI)
                        .add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE)
                        .build())
                .execute()
                .returnContent()
                .asString();

        // Parse the JSON response to extract the access token
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").getAsString();

        return accessToken;
    }
    
    public static UserGoogle getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogle googlePojo = new Gson().fromJson(response, UserGoogle.class);

        return googlePojo;
    }

}
