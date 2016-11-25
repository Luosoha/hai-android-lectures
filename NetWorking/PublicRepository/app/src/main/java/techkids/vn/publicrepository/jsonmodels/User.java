package techkids.vn.publicrepository.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lush on 11/25/2016.
 */

public class User {

    @SerializedName("name")
    private String userName;

    @SerializedName("owner")
    private Owner userOwner;

    public User(String userName, Owner userOwner) {
        this.userName = userName;
        this.userOwner = userOwner;
    }

    public String getUserName() {
        return userName;
    }

    public Owner getUserOwner() {
        return userOwner;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + userName + '\'' +
                ", " + userOwner +
                '}';
    }
}
