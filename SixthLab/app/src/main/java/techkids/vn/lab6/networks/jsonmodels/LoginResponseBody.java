package techkids.vn.lab6.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lush on 12/18/2016.
 */

public class LoginResponseBody {
    @SerializedName("token")
    private String token;

    @SerializedName("result")
    private int result;

    @SerializedName("message")
    private String message;

    public LoginResponseBody(String token, int result, String message) {
        this.token = token;
        this.result = result;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
