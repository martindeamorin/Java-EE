package org.mdeamorin.webapp.headers.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mdeamorin.webapp.headers.models.Product;

public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> retrieve() {
        return Arrays.asList(new Product(1L, "Notebook", "Computacion", 175000),
            new Product(2L, "Mesa", "Oficina", 10000),
            new Product(3L, "Teclado", "Computacion", 40000));
    }

    @Override
    public Optional<Product> search(String name) {
        return retrieve().stream().filter(p -> p.getName().contains(name)).findFirst();
    }
}
