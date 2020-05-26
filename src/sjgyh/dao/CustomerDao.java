package sjgyh.dao;

import sjgyh.domain.Customer;

import java.util.List;

/**
 * 客户信息DAO
 */
@SuppressWarnings("all")
public interface CustomerDao {
    public List<Customer> findAll();
}
