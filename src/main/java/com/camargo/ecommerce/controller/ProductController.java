package com.camargo.ecommerce.controller;

import com.camargo.ecommerce.model.Product;
import com.camargo.ecommerce.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Buscar todos os produtos.
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    // Criar um produto.
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    // Buscar pelo id.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    // Atualizar um produto.
    @PutMapping("/{id}")
    public Product updateProduct(
        @PathVariable Long id,
        @RequestBody Product productDetails
    ) {
        // Buscar o produto existente.
        Product existingProduct = productService.findById(id);

        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setQuantityInStock(productDetails.getQuantityInStock());
        existingProduct.setDescription(productDetails.getDescription());

        return productService.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.findById(id);
        productService.deleteById(id);
    }
}
