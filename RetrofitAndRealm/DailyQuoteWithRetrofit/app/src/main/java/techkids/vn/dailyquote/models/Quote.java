package techkids.vn.dailyquote.models;

/**
 * Created by Lush on 12/3/2016.
 */

public class Quote {

    private String title;
    private String content;

    public Quote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content.replace("\n", "");
    }

    @Override
    public String toString() {
        return "Quote{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
