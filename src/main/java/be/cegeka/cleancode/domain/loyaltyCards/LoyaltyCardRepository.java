package be.cegeka.cleancode.domain.loyaltyCards;

import be.cegeka.cleancode.domain.customers.Customer;
        import org.hibernate.Query;
        import javax.inject.Named;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Named
public class LoyaltyCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void assignLoyaltyCardToMember(Customer customer, LoyaltyCard loyaltyCard) {
        entityManager.persist(loyaltyCard);
    }

    public List<LoyaltyCard> getAllLoyaltyCards(){
        return entityManager.createQuery("select o from LoyaltyCard o", LoyaltyCard.class).getResultList();

    }
}