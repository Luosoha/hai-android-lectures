package techkids.vn.foodlistview;

/**
 * Created by Lush on 11/24/2016.
 */

public class FoodItem {

    private String image;
    private String name;
    private String detail;
    private int price;

    public FoodItem(String image, String name, String detail, int price) {
        this.image = image;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}
