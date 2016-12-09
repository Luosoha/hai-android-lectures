package techkids.vn.lab4_turn1.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Lush on 12/4/2016.
 */

public class TechkidsConnectList implements Serializable {

    @SerializedName("content")
    private CompanyList companyList;

    public TechkidsConnectList(CompanyList companyList) {
        this.companyList = companyList;
    }

    public CompanyList getCompanyList() {
        return companyList;
    }

}
