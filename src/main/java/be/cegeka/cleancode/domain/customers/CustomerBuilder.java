package be.cegeka.cleancode.domain.customers;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private String inss;
    private String city;
    private String postalCode;


    public Customer buildFull() {
        Customer customer = new Customer(firstName, lastName, inss, city, postalCode);
        return customer;
    }

    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
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
