package dat.backend.model.entities;

import java.util.Objects;

public class User
{
    private String password;
    private int userId;
    private String role;
    private String name;
    private String address;
    private int postalCode;
    private String phoneNo;
    private String email;

    public User() {
    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String name, String address, int postalCode, String phoneNo, String email) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public User(String name, String address, int postalCode, String phoneNo, String email, String password) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getName(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", userId=" + userId +
                ", roleId=" + role +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
