package com.example.mahesh.delenassignment;

public class Bill {

    Bill(){}

    private int id;
    private String date;
    private int bill_no;
    private String job_status;
    private String name;
    private String payment_status;
    private String rate;
    private String required_for;
    private String required_where;
    private String service;
    private String status;

    private Address Address;
    private Tax tax;
    private String imageUrl;



    private String start_time;
    private String end_time;
    private String total_time;
    private double grand_total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRequired_for() {
        return required_for;
    }

    public void setRequired_for(String required_for) {
        this.required_for = required_for;
    }

    public String getRequired_where() {
        return required_where;
    }

    public void setRequired_where(String required_where) {
        this.required_where = required_where;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        this.Address = address;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public double getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", bill_no=" + bill_no +
                ", job_status='" + job_status + '\'' +
                ", name='" + name + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", rate='" + rate + '\'' +
                ", required_for='" + required_for + '\'' +
                ", required_where='" + required_where + '\'' +
                ", service='" + service + '\'' +
                ", status='" + status + '\'' +
                ", Address=" + Address +
                ", tax=" + tax +
                ", imageUrl='" + imageUrl + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", total_time='" + total_time + '\'' +
                ", grand_total=" + grand_total +
                '}';
    }


}
