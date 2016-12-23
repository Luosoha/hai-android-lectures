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

    public ToDoResponseBody(String title, String color, String content) {
        this.title = title;
        this.color = color;
        this.content = content;
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

    public static List<ToDoResponseBody> toDoList = new ArrayList<>();

    @Override
    public String toString() {
        return "ToDoResponseBody{" +
                "title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
