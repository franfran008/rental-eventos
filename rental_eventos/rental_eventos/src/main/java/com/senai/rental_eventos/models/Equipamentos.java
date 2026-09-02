package com.senai.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipamentos")
public class Equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "equipamento_id", nullable = false)
    private Integer id;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "potencia", nullable = false)
    private Integer potencia;
    @Column(name = "material", nullable = false)
    private String material;
    @Column(name = "peso", nullable = false)
    private Double peso;
    @Column(name = "dimensoes", nullable = false)
    private String dimensoes;
    @Column(name = "cor", nullable = false)
    private String cor;
    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "aluguel_id", referencedColumnName = "aluguel_id")
    private Aluguel aluguel;

    public Equipamentos(String marca, String modelo, String categoria, Integer potencia, String material, Double peso, String dimensoes, String cor, Integer estoque) {
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.cor = cor;
        this.estoque = estoque;
    }

    public Equipamentos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    
}
