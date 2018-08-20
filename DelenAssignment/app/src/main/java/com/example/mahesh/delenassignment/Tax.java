package com.example.mahesh.delenassignment;

public class Tax{

    private double cgst;
    private double sgst;

    public double getCgst() {
        return cgst;
    }

    public void setCgst(double cgst) {
        this.cgst = cgst;
    }

    public double getSgst() {
        return sgst;
    }

    public void setSgst(double sgst) {
        this.sgst = sgst;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "cgst='" + cgst + '\'' +
                ", sgst='" + sgst + '\'' +
                '}';
    }
}