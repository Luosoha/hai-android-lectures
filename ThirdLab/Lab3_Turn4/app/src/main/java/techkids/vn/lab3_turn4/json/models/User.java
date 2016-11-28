package techkids.vn.lab3_turn4.json.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lush on 11/28/2016.
 */

public class User {

    @SerializedName("Id")
    private int id;

    @SerializedName("AccessToken")
    private String accessToken;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("CustomerName")
    private String customerName;

    @SerializedName("Email")
    private String email;

    @SerializedName("Password")
    private String password;

    @SerializedName("DayOfBirth")
    private int dateOfBirth;

    @SerializedName("MonthOfBirth")
    private int monthOfBirth;

    @SerializedName("YearOfBirth")
    private int yearOfBirth;

    public User(String phone, String customerName, String email, String password, int dateOfBirth, int monthOfBirth, int yearOfBirth) {
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + "\n" +
                ", accessToken='" + accessToken + "\n" +
                ", phone='" + phone + "\n" +
                ", customerName='" + customerName + "\n" +
                ", email='" + email + "\n" +
                ", password='" + password + "\n" +
                ", dateOfBirth=" + dateOfBirth + "\n" +
                ", monthOfBirth=" + monthOfBirth + "\n" +
                ", yearOfBirth=" + yearOfBirth + "\n" +
                '}';
    }
}
