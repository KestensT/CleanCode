package be.cegeka.cleancode.domain.loyaltyCards;


import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LoyaltyCardService {

    @Inject
    private LoyaltyCardRepository loyaltyCardRepository;

    @Inject
    private CustomerRepository customerRepository;

    public void assignLoyaltyCardToMember(int customerId, String barcode) {
        Customer customer = customerRepository.getCustomerById(customerId);
        LoyaltyCard loyaltyCard = new LoyaltyCard(barcode, 0);
        loyaltyCardRepository.assignLoyaltyCardToMember(customer, loyaltyCard);
        customer.setLoyaltyCard(loyaltyCard);
    }
}