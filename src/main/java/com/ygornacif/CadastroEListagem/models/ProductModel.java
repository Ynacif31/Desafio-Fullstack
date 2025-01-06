package com.ygornacif.CadastroEListagem.models;

import com.ygornacif.CadastroEListagem.enums.Disponibilidade;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private double price;

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    public ProductModel() {}

    public ProductModel(UUID id, String name, String description, double price, Disponibilidade disponibilidade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.disponibilidade = disponibilidade;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
