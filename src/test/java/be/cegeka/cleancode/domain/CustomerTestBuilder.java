package be.cegeka.cleancode.domain;

import org.springframework.test.util.ReflectionTestUtils;

public class CustomerTestBuilder {

    private String firstName;
    private String lastName;
    private int id;
    private String inss;
    private String city;
    private String postalCode;


    public static CustomerTestBuilder aCustomer(){
        return new CustomerTestBuilder()
                .withFirstName("Seppe")
                .withLastName("Gielen")
                .withInss("123")
                .withCity("Leuven");
    }

    public Customer build(){
        Customer customer = new Customer(firstName, lastName, inss, city, postalCode);
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
    public CustomerTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerTestBuilder withCity(String city) {
        this.city = city;
        return this;
    }
    public CustomerTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


}