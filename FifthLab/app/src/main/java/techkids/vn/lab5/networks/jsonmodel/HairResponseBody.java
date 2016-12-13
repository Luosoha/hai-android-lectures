package techkids.vn.lab5.networks.jsonmodel;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Lush on 12/11/2016.
 */

public class HairResponseBody extends RealmObject {

    @SerializedName("d")
    private RealmList<HairStyle> hairStyles;

    public HairResponseBody() {

    }

    public HairResponseBody(RealmList<HairStyle> hairStyles) {
        this.hairStyles = hairStyles;
    }

    public RealmList<HairStyle> getHairStyles() {
        return hairStyles;
    }

    @Override
    public String toString() {
        return "HairResponseBody{" +
                "hairStyles=" + hairStyles +
                '}';
    }
}
