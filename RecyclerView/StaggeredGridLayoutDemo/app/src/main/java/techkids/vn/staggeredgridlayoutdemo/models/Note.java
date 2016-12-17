package techkids.vn.staggeredgridlayoutdemo.models;

import android.graphics.Color;

/**
 * Created by Lush on 12/16/2016.
 */

public class Note {

    private String title;
    private String content;
    private int color;

    public Note(String title, String content, int color) {
        this.title = title;
        this.content = content;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getColor() {
        return color;
    }

    public static final Note[] NOTES = new Note[] {
            new Note("Register \nscreen", "Work on \ndemo app", Color.LTGRAY),
            new Note("Note screen", "List all notes \nof user", Color.GREEN),
            new Note("Note screen", "List all notes \nof user \nBlahblahblah \nAhahahah \nAhuhuhuuh", Color.YELLOW),
            new Note("Note screen", "List all notes \nof user", Color.CYAN)
    };

}
