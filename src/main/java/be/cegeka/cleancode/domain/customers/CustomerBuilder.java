package be.cegeka.cleancode.domain.customers;

public class CustomerBuilder {

    private String name;
    private String inss;
    private String city;
    private String postalCode;


    public Customer buildFull() {
        Customer customer = new Customer(name, inss, city, postalCode);
        return customer;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public CustomerBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

}
