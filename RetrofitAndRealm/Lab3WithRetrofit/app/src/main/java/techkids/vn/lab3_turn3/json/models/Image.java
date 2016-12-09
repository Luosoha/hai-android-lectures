package techkids.vn.lab3_turn3.json.models;

/**
 * Created by Lush on 11/27/2016.
 */

public class Image {

    private String url;
    private String thumb;
    private String title;
    private String description;

    public Image(String url, String thumb, String title, String description) {
        this.url = url;
        this.thumb = thumb;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
