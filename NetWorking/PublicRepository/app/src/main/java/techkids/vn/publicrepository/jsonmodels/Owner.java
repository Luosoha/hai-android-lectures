package techkids.vn.publicrepository.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lush on 11/25/2016.
 */

public class Owner {

    @SerializedName("login")
    private String userLogin;

    @SerializedName("avatar_url")
    private String userAvatarUrl;

    public Owner(String userLogin, String userAvatarUrl) {
        this.userLogin = userLogin;
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    @Override
    public String toString() {
        return "owner={" +
                "login='" + userLogin + '\'' +
                ", avatar_url='" + userAvatarUrl + '\'' +
                '}';
    }
}
