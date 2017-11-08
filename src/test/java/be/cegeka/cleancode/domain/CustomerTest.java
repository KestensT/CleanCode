package be.cegeka.cleancode.domain;

import org.junit.Before;
import org.junit.Test;

import static be.cegeka.cleancode.domain.CustomerTestBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = aCustomer()
                        .withFirstName("Seppe")
                        .withLastName("Gielen")
                        .withInss("123")
                        .withId(10)
                        .build();
    }

    @Test
    public void whenGetId_shouldReturnId() throws Exception {
        assertThat(customer.getId()).isEqualTo(10);
    }

    @Test
    public void whenGetFirstName_shouldReturnFirstName() throws Exception {
        assertThat(customer.getFirstName()).isEqualTo("Seppe");
    }

    @Test
    public void whenGetLastName_shouldReturnLastName() throws Exception {
        assertThat(customer.getLastName()).isEqualTo("Gielen");
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
    public void equals_ObjectWithSameIdAndFirstName_isTrue() throws Exception {
        assertThat(customer).isEqualTo(aCustomer()
                .withId(10)
                .withFirstName("Seppe")
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
            .withFirstName("Seppe")
            .build());
    }
}