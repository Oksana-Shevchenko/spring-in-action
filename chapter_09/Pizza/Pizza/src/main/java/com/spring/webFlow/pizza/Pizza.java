package com.spring.webFlow.pizza;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable {
    private PizzaSize size;
    private List<Topping> toppings;

    public Pizza() {
        toppings = new ArrayList<Topping>();
        size = PizzaSize.LARGE;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setSize(String size) {
        this.size = PizzaSize.valueOf(size);
    }

    public List<Topping> getToppings(){
        return toppings;
    }

    public void setToppings(List<Topping> toppings){
        this.toppings = toppings;
    }

    public void setToppings(String[] toppings){
        for(int i=0;i<toppings.length;i++){
            this.toppings.add(Topping.valueOf(toppings[i]));
        }
    }
}
