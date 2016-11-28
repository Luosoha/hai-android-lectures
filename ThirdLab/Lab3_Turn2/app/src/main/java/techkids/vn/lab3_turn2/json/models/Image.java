package techkids.vn.lab3_turn2.json.models;

/**
 * Created by Lush on 11/27/2016.
 */

public class Image {

    private String url;
    private String thumb;
    private String description;
    private String title;

    public Image(String url, String thumb, String description, String title) {
        this.url = url;
        this.thumb = thumb;
        this.description = description;
        this.title = title;
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
