package com.example.mahesh.delenassignment;


public class Address{

    public Address(){}

    private String address1;
    private String street;
    private String city;
    private String country;
    private String pin_no;
    private String state;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPin_no() {
        return pin_no;
    }

    public void setPin_no(String pin_no) {
        this.pin_no = pin_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", pin_no='" + pin_no + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String formatAddress(){
        return address1+",\n"+street+",\n"+city+", "+state+", "+pin_no+",\n"+country;
    }
}
