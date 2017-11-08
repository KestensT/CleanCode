package be.cegeka.cleancode.domain.loyaltyCards;

import be.cegeka.cleancode.domain.customers.Customer;
        import org.hibernate.Query;
        import javax.inject.Named;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;

@Named
public class LoyaltyCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void assignLoyaltyCardToMember(Customer customer, LoyaltyCard loyaltyCard) {
        entityManager.persist(loyaltyCard);
    }
}