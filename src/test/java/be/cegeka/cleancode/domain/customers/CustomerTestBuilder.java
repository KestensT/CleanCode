package be.cegeka.cleancode.domain.customers;

import org.springframework.test.util.ReflectionTestUtils;

public class CustomerTestBuilder {

    private String name;
    private int id;
    private String inss;
    private String city;
    private String postalCode;


    public static CustomerTestBuilder aCustomer() {
        return new CustomerTestBuilder()
                .withName("Seppe Gielen")
                .withInss("123")
                .withCity("Leuven")
                ;
    }

    public Customer build() {
        Customer customer = new Customer(name, inss, city, postalCode);
        ReflectionTestUtils.setField(customer, "id", id);
        return customer;
    }

    public CustomerTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CustomerTestBuilder withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public CustomerTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerTestBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerTestBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }


}