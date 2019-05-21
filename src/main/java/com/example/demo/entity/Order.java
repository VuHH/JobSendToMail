package com.example.demo.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private String idOrder;
    private String nameOrder;

    public Order() {
    }

    public Order(String idOrder, String nameOrder) {
        this.idOrder = idOrder;
        this.nameOrder = nameOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }
}
