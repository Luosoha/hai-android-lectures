package techkids.vn.lab6.networks.jsonmodels.responsemodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lush on 12/18/2016.
 */

public class ToDoResponseBody {

    @SerializedName("title")
    private String title;

    @SerializedName("color")
    private String color;

    @SerializedName("content")
    private String content;

    @SerializedName("completed")
    private boolean completed;

    @SerializedName("_id")
    private Id id;

    public ToDoResponseBody(String title, String color, String content, boolean completed, Id id) {
        this.title = title;
        this.color = color;
        this.content = content;
        this.completed = completed;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getId() {
        return id.getId();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public static List<ToDoResponseBody> toDoList = new ArrayList<>();
    public static List<ToDoResponseBody> completedToDoList = new ArrayList<>();

    @Override
    public String toString() {
        return "ToDoResponseBody{" +
                "title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    class Id{
        @SerializedName("$oid")
        private String id;

        public Id(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}
