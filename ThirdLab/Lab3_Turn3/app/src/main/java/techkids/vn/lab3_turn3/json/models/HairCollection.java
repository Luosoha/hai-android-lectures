package techkids.vn.lab3_turn3.json.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Lush on 11/27/2016.
 */

public class HairCollection {

    @SerializedName("d")
    private HairStyle[] hairStyles;

    public HairCollection(HairStyle[] hairStyles) {
        this.hairStyles = hairStyles;
    }

    public HairStyle[] getHairs() {
        return hairStyles;
    }

    @Override
    public String toString() {
        return "HairCollection{" +
                "hairStyles=" + Arrays.toString(hairStyles) +
                '}';
    }

}
