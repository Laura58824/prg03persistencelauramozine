/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity  // Indica que essa classe é uma entidade JPA (vira tabela no banco)
@Table(name = "cursos")
public class Curso extends PersistenceEntity implements Serializable {
    /**
     * Nome do curso.
     * Não pode ser nulo.
     */
    @Column(name = "nome", nullable = false)
    private String nome;

    /**
     * Quantidade de vagas ou itens do curso.
     */
    @Column(name = "quantidade")
    private Integer quantidade;

    /**
     * Descrição do curso.
     */
    @Column(name = "descricao")
    private String descricao;

    /**
     * Nome do fornecedor do curso.
     */
    @Column(name = "fornecedor")
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
    

}
