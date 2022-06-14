package mk.ukim.finki.wbaud.service.impl;

import mk.ukim.finki.wbaud.model.Category;
import mk.ukim.finki.wbaud.model.Manufacturer;
import mk.ukim.finki.wbaud.model.Product;
import mk.ukim.finki.wbaud.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wbaud.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wbaud.repository.impl.InMemoryCategoryRepository;
import mk.ukim.finki.wbaud.repository.impl.InMemoryManufacturerRepository;
import mk.ukim.finki.wbaud.repository.impl.InMemoryProductRepository;
import mk.ukim.finki.wbaud.repository.jpa.CategoryRepository;
import mk.ukim.finki.wbaud.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wbaud.repository.jpa.ProductRepository;
import mk.ukim.finki.wbaud.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository memoryManufacturerRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.memoryManufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(String name, Double price, Integer quantity,
                                  Long categoryId, Long manufacturerId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
        Manufacturer manufacturer = this.memoryManufacturerRepository.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));

        this.productRepository.deleteByName(name);

        return Optional.of(this.productRepository.save(new Product(name, price, quantity, category, manufacturer)));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
