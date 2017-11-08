package be.cegeka.cleancode.domain.customers;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("Select u from Customer u", Customer.class).getResultList();
    }

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerByName(String name) {
        return entityManager.createQuery("select u from Customer u where u.name like :name", Customer.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }

}
