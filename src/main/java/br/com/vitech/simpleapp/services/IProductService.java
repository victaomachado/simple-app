package br.com.vitech.simpleapp.services;

import br.com.vitech.simpleapp.model.dtos.ProductReceivedDTO;
import br.com.vitech.simpleapp.model.entities.Product;

public interface IProductService {

    Product createProduct(ProductReceivedDTO productReceivedDTO);

    Product getProduct(Long id);
}
