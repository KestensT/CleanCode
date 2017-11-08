package be.cegeka.cleancode.domain.customers;

import be.cegeka.cleancode.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;

import static be.cegeka.cleancode.domain.customers.CustomerTestBuilder.aCustomer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class CustomerRepositoryTest {

    @Inject
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private CustomerBuilder customerBuilder = new CustomerBuilder();

    private Customer seppe, len, jeroen;

    @Before
    public void setUp() throws Exception {
        seppe = aCustomer()
                .withName("Seppe")
                .withInss("123456")
                .withCity("Hasselt")
                .withPostalCode("3500")
                .build();
        len = aCustomer()
                .withName("Len")
                .withInss("4569")
                .withCity("Rumst")
                .withPostalCode("2840")
                .build();
        jeroen = aCustomer()
                .withName("Jeroen")
                .withInss("987654")
                .withCity("Jette")
                .withPostalCode("1000")
                .build();

        entityManager.persist(seppe);
        entityManager.persist(len);
        entityManager.persist(jeroen);
    }

    @Test
    public void getAllCustomers() throws Exception {
        List<Customer> customers = customerRepository.getAllCustomers();
        Query query = entityManager.createQuery("select u from Customer u",Customer.class);

        assertThat(query.getResultList()).containsOnly(seppe, len, jeroen);
    }


    @Test
    public void getCustomerByName() throws Exception {
        Customer actual = customerRepository.getCustomerByName("Seppe");

        assertThat(actual).isEqualTo(seppe);
    }
}
