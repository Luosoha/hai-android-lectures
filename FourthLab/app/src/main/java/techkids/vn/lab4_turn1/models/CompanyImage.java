package techkids.vn.lab4_turn1.models;

import java.io.Serializable;

/**
 * Created by Lush on 12/4/2016.
 */

public class CompanyImage implements Serializable {

    private String type;
    private String url;

    public CompanyImage(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

}

