package techkids.vn.lab6.networks.jsonmodels.requestmodels;

/**
 * Created by Lush on 12/18/2016.
 */

public class RegisterRequestBody {

    private String username;
    private String password;

    public RegisterRequestBody(String username, String password) {
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
