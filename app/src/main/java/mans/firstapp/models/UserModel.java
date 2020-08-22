package mans.firstapp.models;

import java.io.Serializable;

public class UserModel implements Serializable
{
    private String name,email,number;

    public UserModel(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}