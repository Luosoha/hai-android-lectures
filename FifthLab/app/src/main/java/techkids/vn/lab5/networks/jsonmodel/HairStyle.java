package techkids.vn.lab5.networks.jsonmodel;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Lush on 12/11/2016.
 */

public class HairStyle extends RealmObject {

    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("Thumb")
    private HairThumb hairThumb;

    public HairStyle() {
    }

    public HairStyle(int id, String name, String description, HairThumb hairThumb) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hairThumb = hairThumb;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HairThumb getHairThumb() {
        return hairThumb;
    }

    @Override
    public String toString() {
        return "HairStyle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hairThumb=" + hairThumb +
                '}';
    }

}
