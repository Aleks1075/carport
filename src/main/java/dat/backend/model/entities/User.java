package dat.backend.model.entities;

import java.util.Objects;

public class User
{
    private String username;
    private String email;
    private String password;
    private String address;
    private String role;
    private int postcode;
    private int phoneNumber;

    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String email, String password, String address, String role, int postcode, int phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String email, String address, int postcode, int phone_number)
    {
        this.username = username;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) &&
                getAddress().equals(user.getAddress()) && getRole().equals(user.getRole()) && getPostcode() == user.getPostcode() &&
                getPhoneNumber() == user.getPhoneNumber();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getEmail(), getPassword(), getAddress(), getRole(), getPostcode(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", postcode=" + postcode +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
