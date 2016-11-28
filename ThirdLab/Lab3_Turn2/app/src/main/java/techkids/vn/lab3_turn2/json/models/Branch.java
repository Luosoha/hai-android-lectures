package techkids.vn.lab3_turn2.json.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Lush on 11/27/2016.
 */

public class Branch {

    @SerializedName("d")
    private Salon[] salons;

    public Branch(Salon[] salons) {
        this.salons = salons;
    }

    @Override
    public String toString() {
        String res = "";
        for (Salon salon : salons) {
            res += salon.toString() + "\n";
        }

        return res;
    }
}
