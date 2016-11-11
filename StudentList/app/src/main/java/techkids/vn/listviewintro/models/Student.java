package techkids.vn.listviewintro.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lush on 11/8/2016.
 */

public class Student implements Serializable {

    public static final int OP_ADD = 0;
    public static final int OP_UPDATE = 1;

    private String name;
    private String gender;
    private int age;

    public Student() {
        this.name = "";
        this.gender = "";
        this.age = 0;
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return (name);
    }

    private static final Student[] STUDENTS = {
            new Student("Luu", "female", 17),
            new Student("Tuan", "male", 15),
            new Student("Nghia", "male", 11),
            new Student("Duc", "male", 9),
            new Student("Cuong", "male", 15)
    };;

    public static  ArrayList<Student> list = new ArrayList<>(Arrays.asList(STUDENTS));
}
