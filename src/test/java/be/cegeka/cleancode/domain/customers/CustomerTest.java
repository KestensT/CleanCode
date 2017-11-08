package be.cegeka.cleancode.domain.customers;

import org.junit.Before;
import org.junit.Test;

import static be.cegeka.cleancode.domain.customers.CustomerTestBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = aCustomer()
                .withName("Seppe Gielen")
                .withInss("123")
                .withId(10)
                .build();
    }

    @Test
    public void whenGetId_shouldReturnId() throws Exception {
        assertThat(customer.getId()).isEqualTo(10);
    }

    @Test
    public void whenGetName_shouldReturnName() throws Exception {
        assertThat(customer.getName()).isEqualTo("Seppe Gielen");
    }

    @Test
    public void whenGetInss_shouldReturnInss() throws Exception {
        assertThat(customer.getInss()).isEqualTo("123");
    }

    @Test
    public void equals_SameObject_IsTrue() throws Exception {
        assertThat(customer).isEqualTo(customer);
    }

    @Test
    public void equals_ObjectWithSameIdAndName_isTrue() throws Exception {
        assertThat(customer).isEqualTo(aCustomer()
                .withId(10)
                .withName("Seppe Gielen")
                .build());
    }

    @Test
    public void equals_NullObject_IsFale() throws Exception {
        assertThat(customer).isNotEqualTo(null);
    }

    @Test
    public void equals_OtherClass_ISFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Object());
    }

    @Test
    public void equals_ObjectWithOtherID_IsFalse() throws Exception {
        assertThat(customer).isNotEqualTo(aCustomer()
                .withId(5)
                .withName("Seppe Gielen")
                .build());
    }
}