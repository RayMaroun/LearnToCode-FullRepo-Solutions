package com.yearup.NorthwindTraders.dao.interfaces;

import com.yearup.NorthwindTraders.models.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAll();
    Product getById(int id);
    Product insert(Product product);
    void update(int id, Product product);
    void delete(int id);
}
