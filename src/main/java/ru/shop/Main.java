package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.PruductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PruductService pruductService = new PruductService(
                new ProductRepository()
        );
        CustomerService customerService = new CustomerService(
                new CustomerRepository()
        );

        OrderService orderService = new OrderService(
                new OrderRepository()
        );


        System.out.println(ProductType.SERVICE.name());

        Product ladaKalina = new Product(UUID.randomUUID(),"Lada kalina",100,ProductType.GOOD);
        pruductService.save(ladaKalina);

        Product forMustang = new Product(UUID.randomUUID(),"Ford Mustang", 10000,ProductType.GOOD);
        pruductService.save(forMustang);

        Product carWashing = new Product(UUID.randomUUID(),"Car Washing", 100000,ProductType.SERVICE);
        pruductService.save(carWashing);

        Customer cust = new Customer(UUID.randomUUID(),"Ivanushka","123456",16);
        customerService.save(cust);

        Customer king = new Customer(UUID.randomUUID(),"King","999999",42);
        customerService.save(king);



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

        System.out.println("-- ALL Customer --");
        for(Customer customer : customerService.findAll()){
            System.out.println(customer);
        }




        orderService.add(cust,ladaKalina,2);
        orderService.add(cust,forMustang,2);

        try {
            orderService.add(king, forMustang, 0);
        } catch (BadOrderCountException ex){
            System.out.println("BadOrderCountException");
        }

        System.out.println("-- CustOrder --");
        for(Order order : orderService.findByCustomer(cust)){
            System.out.println(order);
        }

        System.out.println("Стоймость всех заказов: " + orderService.getTotalCustomerAmount(cust));


    }

}