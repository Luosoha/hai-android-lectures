package techkids.vn.lab4_turn1.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lush on 12/4/2016.
 */

public class CompanyList implements Serializable {

    @SerializedName("items")
    private ArrayList<Company> companies;

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public int getCompaniesSize() {
        return companies.size();
    }

}
