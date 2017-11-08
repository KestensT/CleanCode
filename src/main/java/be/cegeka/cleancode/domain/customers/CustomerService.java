package be.cegeka.cleancode.domain.customers;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;


    public void addCustomer(String firstName, String lastName, String inss, String city, String postalCode) {
        CustomerBuilder customerBuilder = new CustomerBuilder();
        customerRepository.addCustomer(customerBuilder
                .withLastName(lastName)
                .withFirstName(firstName)
                .withInss(inss)
                .withCity(city)
                .withPostalCode(postalCode)
                .buildFull());
    }

    public List<Customer> getAllCustomers(){return customerRepository.getAllCustomers();}























}
