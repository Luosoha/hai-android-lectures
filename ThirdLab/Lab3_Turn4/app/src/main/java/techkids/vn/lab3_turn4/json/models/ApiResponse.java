package techkids.vn.lab3_turn4.json.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lush on 11/28/2016.
 */

public class ApiResponse {

    @SerializedName("d")
    private User user;

    public ApiResponse(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                user.toString() +
                '}';
    }
}
