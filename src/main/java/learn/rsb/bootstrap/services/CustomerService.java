package learn.rsb.bootstrap.services;

import learn.rsb.bootstrap.models.Customer;

import java.util.Collection;

public interface CustomerService {
    Collection<Customer> save (String... names);
    Customer findById(Long id);
    Collection<Customer> findAll();
}
