package com.senai.rental_eventos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "usuario_id", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "nascimento", nullable = false)
    private LocalDate nascimento;
    @Column(name = "email", nullable = false)
    private String email;

public Usuario () {}

public Usuario(Integer id, String nome, String senha, LocalDate nascimento, String email) {
    this.id = id;
    this.nome = nome;
    this.senha = senha;
    this.nascimento = nascimento;
    this.email = email;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getSenha() {
    return senha;
}

public void setSenha(String senha) {
    this.senha = senha;
}

public LocalDate getNascimento() {
    return nascimento;
}

public void setNascimento(LocalDate nascimento) {
    this.nascimento = nascimento;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}


}

