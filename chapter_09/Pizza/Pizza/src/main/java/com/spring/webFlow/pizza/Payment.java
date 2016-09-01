package com.spring.webFlow.pizza;

import java.io.Serializable;

public class Payment implements Serializable {

    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
