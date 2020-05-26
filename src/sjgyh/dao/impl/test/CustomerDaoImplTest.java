package sjgyh.dao.impl.test;

import org.junit.jupiter.api.Test;
import sjgyh.dao.impl.CustomerDaoImpl;
import sjgyh.domain.Customer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    @Test
    void findAll() {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        List<Customer> customers = dao.findAll();
        if (customers!= null && customers.size() > 0) {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i));
            }
        }
    }
}