package be.cegeka.cleancode.domain.customers;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;


    public void addCustomer(String name, String inss, String city, String postalCode) {
        CustomerBuilder customerBuilder = new CustomerBuilder();
        customerRepository.addCustomer(customerBuilder
                .withName(name)
                .withInss(inss)
                .withCity(city)
                .withPostalCode(postalCode)
                .buildFull());
    }

    public List<Customer> getAllCustomers(){return customerRepository.getAllCustomers();}























}
