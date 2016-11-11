package techkids.vn.simplenote.models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lush on 11/11/2016.
 */

public class SimpleNote {

    public static final int OP_ADD = 0;
    public static final int OP_UPDATE = 1;

    private String title;
    private String note;

    public SimpleNote(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return title;
    }

    private static final SimpleNote[] SIMPLE_NOTEs = {
        new SimpleNote("Tools for learning Android"),
        new SimpleNote("Views"),
        new SimpleNote("Activities"),
        new SimpleNote("Fragments")
    };

    public static ArrayList<SimpleNote> list = new ArrayList<>(Arrays.asList(SIMPLE_NOTEs));
}
