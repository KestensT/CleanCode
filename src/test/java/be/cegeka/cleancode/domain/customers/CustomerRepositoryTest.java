package be.cegeka.cleancode.domain.customers;

import be.cegeka.cleancode.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static be.cegeka.cleancode.domain.customers.CustomerTestBuilder.aCustomer;
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
                .withLastName("Gielen")
                .withFirstName("Seppe")
                .withInss("123456")
                .withCity("Hasselt")
                .withPostalCode("3500")
                .build();
    }
}