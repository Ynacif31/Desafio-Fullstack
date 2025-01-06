package com.ygornacif.CadastroEListagem.services;

import com.ygornacif.CadastroEListagem.dtos.ProductDto;
import com.ygornacif.CadastroEListagem.models.ProductModel;
import com.ygornacif.CadastroEListagem.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAllSortedByPrice() {
        List<ProductModel> products = productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ProductDto save(ProductDto dto) {
        ProductModel entity = new ProductModel();
        copyDtoToEntity(dto, entity);
        productRepository.save(entity);
        return new ProductDto(entity);
    }


    public void copyDtoToEntity(ProductDto dto, ProductModel entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setDisponibilidade(dto.getDisponibilidade());
    }

}
