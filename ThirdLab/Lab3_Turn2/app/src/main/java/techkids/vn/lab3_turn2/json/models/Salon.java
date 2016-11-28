package techkids.vn.lab3_turn2.json.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Lush on 11/27/2016.
 */

public class Salon {

    @SerializedName("Fanpage")
    private String fanpage;

    @SerializedName("Name")
    private String name;

    @SerializedName("FanpageId")
    private String fanpageId;

    @SerializedName("ManagerName")
    private String managerName;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Images")
    private Image[] images;

    @SerializedName("Id")
    private int id;

    public Salon(String fanpage, String name, String fanpageId, String managerName, String phone, Image[] images, int id) {
        this.fanpage = fanpage;
        this.name = name;
        this.fanpageId = fanpageId;
        this.managerName = managerName;
        this.phone = phone;
        this.images = images;
        this.id = id;
    }

    @Override
    public String toString() {
        String res =  "Salon{" +
                "Fanpage:'" + fanpage + "\n" +
                ", Name:'" + name + "\n" +
                ", FanpageId:'" + fanpageId + "\n" +
                ", ManagerName:'" + managerName + "\n" +
                ", Phone:'" + phone + "\n" +
                ", Images:" + Arrays.toString(images) + "\n" +
                ", Id: " + id +
                '}' + "\n";
        res = res + "\n";
        return res;
    }
}
