package com.divakar.productcatalog.controllers;


import com.divakar.productcatalog.dtos.GenericProductDto;
import com.divakar.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //field injection
    //@Autowired
    private ProductService productService;

    //constructor injection
    //@Autowired  -> not needed in constructor injection
    public ProductController(@Qualifier("fakeStoreProductService")ProductService productService){
        this.productService=productService;

    }

    // setter injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping
    public void getAllProducts() {

    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById() {

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
//        System.out.println(product.name);
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById() {

    }



}
