package be.cegeka.cleancode.domain.customers;


import be.cegeka.cleancode.domain.loyaltyCards.LoyaltyCard;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INSS")
    private String inss;
    @Column(name = "CITY")
    private String city;
    @Column(name = "POSTALCODE")
    private String postalCode;
    private LoyaltyCard loyaltyCard;

    public Customer(){
    }

    public Customer(String name, String inss, String city, String postalCode){
        this.name = name;
        this.inss = inss;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public String getInss() {
        return inss;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (inss != null ? !inss.equals(customer.inss) : customer.inss != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        return postalCode != null ? postalCode.equals(customer.postalCode) : customer.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (inss != null ? inss.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}
