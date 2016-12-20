package techkids.vn.lab6.networks.jsonmodels;

/**
 * Created by Lush on 12/18/2016.
 */

public class LoginRequestBody {
    private String username;
    private String password;

    public LoginRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
