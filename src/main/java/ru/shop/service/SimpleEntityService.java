package ru.shop.service;

import ru.shop.model.Product;
import ru.shop.model.ProductType;

import java.util.List;

public interface SimpleEntityService<T> {
    void save(T product);

    List<T> findAll();
}
