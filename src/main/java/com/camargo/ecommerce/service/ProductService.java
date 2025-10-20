package com.camargo.ecommerce.service;

import com.camargo.ecommerce.model.Product;
import com.camargo.ecommerce.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        // orElseThrow para obter o Produto se presente, ou lançar uma exceção se estiver vazio (404 Not Found)
        return productRepository
            .findById(id)
            .orElseThrow(() ->
                new NoSuchElementException(
                    "Produto não encontrado com ID: " + id
                )
            );
    }

    public void deleteById(Long id) {
        // Primeiro verifica se existe.
        this.findById(id);
        productRepository.deleteById(id);
    }
}
