package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.IRepository;

import java.util.List;

public class CustomerService implements SimpleEntityService<Customer>  {
    private final IRepository<Customer> repository;


    public CustomerService(IRepository<Customer> repository) {

        this.repository = repository;
    }

    public void save(Customer customer) {
        if (customer.getId() == null){
            throw  new RuntimeException("ID is null");
        }
        repository.save(customer);
    }

    public List<Customer> findAll() {

        return repository.findAll();
    }


}
