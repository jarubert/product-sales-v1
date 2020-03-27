package com.jarubert.api.service;

import com.jarubert.api.model.entity.Product;
import com.jarubert.api.model.dto.ProductDto;
import com.jarubert.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jarubert on 2020-03-24.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDto getOneById(Long id) {
        return productRepository.findById(id)
                .map(product -> new ProductDto(product))
                .orElse(null);
    }

    public ProductDto getOneByName(String name) {
        return productRepository.findOneByName(name)
                .map(product -> new ProductDto(product))
                .orElse(null);
    }

    public List<ProductDto> getAll() {
        return productRepository.findAllByOrderByIdDesc().stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
    }

    public ProductDto insertOrUpdateProduct(ProductDto newProduct) {
        if (newProduct.getId().isPresent()) {
            return updateProduct(newProduct);
        }
        return new ProductDto(productRepository.save(new Product(newProduct)));
    }

    private ProductDto updateProduct(ProductDto newProduct) {
        Product existingProduct = productRepository.findById(newProduct.getId().get()).get();
        newProduct.getName().ifPresent(name -> existingProduct.setName(name));
        newProduct.getDescription().ifPresent(description -> existingProduct.setDescription(description));
        newProduct.getPrice().ifPresent(price -> existingProduct.setPrice(price));

        return new ProductDto(productRepository.save(existingProduct));
    }
}
