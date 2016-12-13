package techkids.vn.lab5.networks.jsonmodel;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Lush on 12/11/2016.
 */

public class HairThumb extends RealmObject {

    @SerializedName("url")
    private String url;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public HairThumb() {
    }

    public HairThumb(String url, String thumb, String title, String description) {
        this.url = url;
        this.thumb = thumb;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "HairThumb{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
