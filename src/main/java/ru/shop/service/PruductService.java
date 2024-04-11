package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.IRepository;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class PruductService implements SimpleEntityService<Product> {
    private final IRepository<Product> repository;

    public PruductService(ProductRepository repository) {

        this.repository = repository;
    }

    @Override
    public void save(Product product){

        repository.save(product);
    }

    @Override
    public List<Product> findAll(){

        return repository.findAll();
    }

    public  List<Product> findByProductType(ProductType productType){
        List<Product> result = new ArrayList<>();
        for(Product product : repository.findAll()){
            if(product.getProductType() == productType){
                result.add(product);

            }
        }
        return result;
    }
}
