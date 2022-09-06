package model;

public class Contact {
    private  String name;
    private  String surname;
    private  String phone;
    private  String email;
    private  String address;
    private  String description;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
