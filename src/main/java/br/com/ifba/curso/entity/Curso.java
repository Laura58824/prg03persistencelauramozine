/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;




/**
 *
 * @author m
 */

/**
 * Entidade que representa a tabela "Curso" no banco de dados.
 * Cada objeto dessa classe é um registro na tabela.
 */

@Entity  // Indica que essa classe é uma entidade JPA (vira tabela no banco)
public class Curso implements Serializable {
    @Id // define que este atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     // o banco gera o ID automaticamente (auto incremento)
    private Long id;
    
    private String nome;
    private Integer quantidade;
    private String descricao;
    private String fornecedor;
   
    
    /**
     * Construtor vazio obrigatório para o JPA
     * O Hibernate usa ele para instanciar objetos automaticamente
     */

    public Curso() {
    }

    public Curso(String nome, Integer quantidade, String descricao, String fornecedor) {
    this.nome = nome;
    this.quantidade = quantidade;
    this.descricao = descricao;
    this.fornecedor = fornecedor;
    
      }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public Long getId() {
    return id;
    }

}
