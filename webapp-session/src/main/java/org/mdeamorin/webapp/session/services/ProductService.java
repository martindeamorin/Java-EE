package org.mdeamorin.webapp.session.services;

import java.util.List;
import java.util.Optional;

import org.mdeamorin.webapp.session.models.Product;


public interface ProductService {
    List<Product> retrieve();
    Optional<Product> search(String name);
}
