package techkids.vn.lab3_turn3.json.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Lush on 11/27/2016.
 */

public class HairStyle {

    @SerializedName("Description")
    private String description;

    @SerializedName("Id")
    private int id;

    @SerializedName("Images")
    private Image[] images;

    @SerializedName("Title")
    private String title;

    public HairStyle(String description, int id, Image[] images, String title) {
        this.description = description;
        this.id = id;
        this.images = images;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Image[] getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        Image image = images[0];
        return image.getUrl();
    }

    @Override
    public String toString() {
        return "HairStyle{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", images=" + Arrays.toString(images) +
                ", title='" + title + '\'' +
                '}';
    }
}
