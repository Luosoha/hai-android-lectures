package techkids.vn.lab6.models;

/**
 * Created by Lush on 12/20/2016.
 */

public class ColorChoosen {

    private String colorSrc;

    private String color;

    public ColorChoosen(String colorSrc, String color) {
        this.colorSrc = colorSrc;
        this.color = color;
    }

    public String getColorSrc() {
        return colorSrc;
    }

    public String getColorName() {
        return color;
    }

    public static final ColorChoosen[] COLORS = new ColorChoosen[] {
            new ColorChoosen("#F44336", "Red"),
            new ColorChoosen("#AB47BC", "Violet"),
            new ColorChoosen("#42A5F5", "Blue"),
            new ColorChoosen("#4CAF50", "Green"),
            new ColorChoosen("#EEFF41", "Yellow")
    };

}
