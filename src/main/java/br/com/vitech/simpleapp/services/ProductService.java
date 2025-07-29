package br.com.vitech.simpleapp.services;

import br.com.vitech.simpleapp.model.dtos.ProductReceivedDTO;
import br.com.vitech.simpleapp.model.entities.Product;
import br.com.vitech.simpleapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(ProductReceivedDTO productReceivedDTO) {
        Product product = new Product();
        product.setName(productReceivedDTO.name());
        product.setPrice(productReceivedDTO.price());
        product.setQuantity(productReceivedDTO.quantity());
        return repository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }
}
