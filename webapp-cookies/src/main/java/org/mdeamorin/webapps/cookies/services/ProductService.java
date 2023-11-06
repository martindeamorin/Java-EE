package org.mdeamorin.webapps.cookies.services;

import java.util.List;
import java.util.Optional;

import org.mdeamorin.webapps.cookies.models.Product;


public interface ProductService {
    List<Product> retrieve();
    Optional<Product> search(String name);
}
