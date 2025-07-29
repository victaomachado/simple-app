package br.com.vitech.simpleapp.repositories;

import br.com.vitech.simpleapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
