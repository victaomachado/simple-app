package br.com.vitech.simpleapp.controllers;

import br.com.vitech.simpleapp.model.dtos.ProductReceivedDTO;
import br.com.vitech.simpleapp.model.entities.Product;
import br.com.vitech.simpleapp.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductReceivedDTO productReceivedDTO) {
        Product product = service.createProduct(productReceivedDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = service.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
