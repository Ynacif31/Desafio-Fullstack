package com.ygornacif.CadastroEListagem.dtos;

import com.ygornacif.CadastroEListagem.enums.Disponibilidade;
import com.ygornacif.CadastroEListagem.models.ProductModel;

import java.util.UUID;

public class ProductDto {

    private UUID id;

    private String name;
    private String description;
    private Double price;

    private Disponibilidade disponibilidade;

    public ProductDto() {}

    public ProductDto(String name, String description, Double price, Disponibilidade disponibilidade, UUID id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.disponibilidade = disponibilidade;
        this.id = id;
    }

    public ProductDto(ProductModel entity){
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.disponibilidade = entity.getDisponibilidade();
        this.id = entity.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
