package Restfulwebservices.Restfulwebservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import  java.util.Date;

public class User {

    private Integer id;

    @Size(min=2, message = "Name should have atleast two charactors")
    private String name;

    @Past(message = "Invalid future Birthday ")
    private Date Birthdate;

    private User(){
    }

    public User(final Integer id, final String name, final Date birthdate) {
        this.id = id;
        this.name = name;
        Birthdate = birthdate;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", Birthdate=" + Birthdate + '}';
    }

    public void setBirthdate(final Date birthdate) {
        Birthdate = birthdate;


    }


}
