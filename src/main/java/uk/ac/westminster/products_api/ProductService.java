package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 3L;

    public ProductService() {
        products.add(new DigitalProduct(
                1L, "E book", 9.99, "/dl/1", 4.2
        ));

        products.add(new PhysicalProduct(
                2L, "Monitor", 249.99, 5.4, "60x40"
        ));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Get a product by ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Add a new product
    public Product addProduct(Product product) {
        product.setId(nextId);
        products.add(product);
        nextId++;

        return product;
    }

    // Delete a product by ID
    public String deleteProductById(Long id) {
        boolean isDeleted = products.removeIf(
                p -> p.getId().equals(id)
        );

        if (isDeleted) {
            return "Deleted successfully";
        } else {
            return "ID not found";
        }
    }

    // Search products by name
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();
    }
}