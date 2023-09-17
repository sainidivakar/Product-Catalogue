package com.divakar.productcatalog.services;

import com.divakar.productcatalog.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

}
