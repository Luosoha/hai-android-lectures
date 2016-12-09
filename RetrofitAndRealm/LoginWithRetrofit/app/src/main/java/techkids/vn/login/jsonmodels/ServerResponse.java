package techkids.vn.login.jsonmodels;

/**
 * Created by Lush on 12/9/2016.
 */

public class ServerResponse {
    private String code;
    private String message;

    public ServerResponse() {
    }

    public ServerResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
