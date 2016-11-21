package techkids.vn.lab2_turn4;

/**
 * Created by Lush on 11/20/2016.
 */

public class NewsItem {

    private String content;
    private String time;
    private int imageResId;

    public NewsItem(String content, String time, int imageResId) {
        this.content = content;
        this.time = time;
        this.imageResId = imageResId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    @Override
    public String toString() {
        return this.content;
    }

    public static final NewsItem[] ARRAY = new NewsItem[] {
            new NewsItem("He may act like he wants a secretary but most of the time they’re looking for…", "10min", R.drawable.item1),
            new NewsItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face.", "13min", R.drawable.item2),
            new NewsItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head...", "16min", R.drawable.item3),
            new NewsItem("Get out of here and move forward. This never happened. It will shock you how much...", "19min", R.drawable.item4),
            new NewsItem("That poor girl. She doesn’t know that loving you is the worst way to get you.", "22min", R.drawable.item5),
    };
}
