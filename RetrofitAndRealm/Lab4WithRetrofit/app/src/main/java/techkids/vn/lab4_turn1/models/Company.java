package techkids.vn.lab4_turn1.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lush on 12/4/2016.
 */

public class Company implements Serializable {

    private String name;
    private String phone;
    private String website;
    @SerializedName("images")
    private ArrayList<CompanyImage> companyImages;

    public Company(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getLogo() {
        return companyImages.get(0).getUrl();
    }

    public String getPicture() {
        return companyImages.get(1).getUrl();
    }

    public ArrayList<CompanyImage> getCompanyImages() {
        return companyImages;
    }

    @Override
    public String toString() {
        return name;
    }

    private static final Company[] COMPANIES = {
            new Company("FPT Software", "0473007575", "https://www.fpt-software.com"),
            new Company("EWay", "+84432595450", "https://eway.vn"),
            new Company("KMS", "+84838486888", "http://www.kms-technology.com"),
            new Company("BraveBits", " +84463260066", "http://www.bravebits.vn"),
            new Company("TechKids", "+841653005670", "http://techkids.vn")
    };

    public static ArrayList<Company> list = new ArrayList<>(Arrays.asList(COMPANIES));
}
