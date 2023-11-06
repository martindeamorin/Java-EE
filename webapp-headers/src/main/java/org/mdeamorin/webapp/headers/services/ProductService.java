package org.mdeamorin.webapp.headers.services;

import java.util.List;
import java.util.Optional;

import org.mdeamorin.webapp.headers.models.Product;

public interface ProductService {
    List<Product> retrieve();
    Optional<Product> search(String name);
}
