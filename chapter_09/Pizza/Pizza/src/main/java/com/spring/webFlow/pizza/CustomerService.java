package com.spring.webFlow.pizza;


import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> customers = new ArrayList<Customer>();
    private List<Order> orders = new ArrayList<Order>();

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {

        for (Customer user: customers) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        throw new CustomerNotFoundException();
    }

    public boolean checkDeliveryArea(String zipCode) {
        if (zipCode.equals("0000")) {
            return true;
        }
        return false;
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public void verifyPayment(PaymentDetails details) {
        //Something verify
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }
}
