package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.IRepository;
import ru.shop.repository.OrderRepository;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private  final IRepository<Order> repository;

    public  OrderService(IRepository<Order> repository){
        this.repository = repository;
    }

    public  void add(Customer customer, Product product, long count){

        if(count <= 0){
            throw new BadOrderCountException();
        }

        Order order = new Order(UUID.randomUUID(),customer.getId(),product.getId(),count,product.getCost()*count);
        repository.save(order);
    }

    public List<Order> findAll(){return repository.findAll();}

    public List<Order> findByCustomer(Customer customer){
        List<Order> result = new ArrayList<>();

        for(Order order: repository.findAll()){
            if(order.getCustimerId() == customer.getId()){
                result.add(order);
            }
        }
        return result;
    }

    public long getTotalCustomerAmount(Customer customer){
        long cost = 0;
        for(Order order: findByCustomer(customer)){
            cost += order.getAmount();
        }
        return cost;
    }

}
