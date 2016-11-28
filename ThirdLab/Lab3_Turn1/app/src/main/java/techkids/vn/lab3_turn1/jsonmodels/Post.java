package techkids.vn.lab3_turn1.jsonmodels;

/**
 * Created by Lush on 11/27/2016.
 */

public class Post {

    private String userId;
    private int id;
    private String title;
    private String body;

    public Post(String userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
