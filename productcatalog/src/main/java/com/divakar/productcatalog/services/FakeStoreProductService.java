package com.divakar.productcatalog.services;

import com.divakar.productcatalog.dtos.FakeStoreProductDto;
import com.divakar.productcatalog.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public   class FakeStoreProductService implements ProductService{

    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response=restTemplate.postForEntity(
                createProductRequestUrl,product, GenericProductDto.class
        );

        return response.getBody();
    }

    public GenericProductDto getProductById(Long id){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(
                getProductRequestUrl, FakeStoreProductDto.class,id
        );
        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        GenericProductDto product=new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;

    }




}
