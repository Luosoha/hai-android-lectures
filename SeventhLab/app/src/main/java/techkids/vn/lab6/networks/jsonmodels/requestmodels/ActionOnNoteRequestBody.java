package techkids.vn.lab6.networks.jsonmodels.requestmodels;

/**
 * Created by Lush on 12/20/2016.
 */

public class ActionOnNoteRequestBody {

    private String title;
    private String content;
    private String color;
    private boolean completed;

    public ActionOnNoteRequestBody(String title, String content, String color) {
        this.title = title;
        this.content = content;
        this.color = color;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getColor() {
        return color;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "ActionOnNoteRequestBody{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", color='" + color + '\'' +
                ", completed=" + completed +
                '}';
    }

}
