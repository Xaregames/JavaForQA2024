package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.PruductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PruductService pruductService = new PruductService(
                new ProductRepository()
        );

        CustomerRepository repository = new CustomerRepository();

        OrderRepository orderRepository = new OrderRepository();

        System.out.println(ProductType.SERVICE.name());

        Product ladaKalina = new Product(UUID.randomUUID(),"Lada kalina",100,ProductType.GOOD);
        pruductService.save(ladaKalina);

        Product forMustang = new Product(UUID.randomUUID(),"Ford Mustang", 10000,ProductType.GOOD);
        pruductService.save(forMustang);

        Product carWashing = new Product(UUID.randomUUID(),"Car Washing", 100000,ProductType.SERVICE);
        pruductService.save(carWashing);

        Customer cust = new Customer(UUID.randomUUID(),"Ivanushka","123456",16);
        repository.save(cust);

        Customer king = new Customer(UUID.randomUUID(),"King","999999",42);
        repository.save(king);



        System.out.println("-- ALL--");
        for(Product product : pruductService.findAll()){
            System.out.println(product);
        }
        System.out.println("-- GOOD --");
        for(Product product : pruductService.findByProductType(ProductType.GOOD)){
            System.out.println(product);
        }

        System.out.println("-- SERVICE --");
        for (Product product : pruductService.findByProductType(ProductType.SERVICE)){
            System.out.println(product);
        }

        System.out.println("-- Customer --");
        for(Customer customer : repository.findAll()){
            System.out.println(customer);
        }


        Order order = new Order(UUID.randomUUID(),cust.getId(),ladaKalina.getId(),2,200);


        orderRepository.save(order);

        System.out.println("-- Order --");
        for(Order order1 : orderRepository.findAll()){
            System.out.println(order1);
        }

    }

}