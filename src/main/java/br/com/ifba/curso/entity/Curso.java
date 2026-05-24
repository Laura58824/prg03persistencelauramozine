package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@NoArgsConstructor
@Entity
@Table(name = "cursos")

public class Curso extends PersistenceEntity implements Serializable {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fornecedor")
    private String fornecedor;

    // Getters e Setters manuais (até o Lombok funcionar)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    
     public Curso(String nome, Integer quantidade, String descricao, String fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }
}