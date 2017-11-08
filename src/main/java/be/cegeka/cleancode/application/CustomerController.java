package be.cegeka.cleancode.application;


import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void addNewCustomer(
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "inss", required = true) String inss,
            @RequestParam(value = "city", required = true) String city,
            @RequestParam(value = "postalCode", required = true) String postalCode) {
        customerService.addCustomer(firstName, lastName, inss, city, postalCode);
    }

}
