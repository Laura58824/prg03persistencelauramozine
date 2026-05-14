/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author m
 */
public class CursoService implements CursoIService { //Classe responsável pelas regras de negócio da entidade Curso.
//O Service:
 //* - valida dados
 //* - aplica regras de negócio
 //* - chama o DAO
 //* A View nunca deve acessar o DAO diretamente
      private final CursoIDao cursoDao;
      
      public CursoService() {
          
        this.cursoDao = new CursoDao();
    }
    
    @Override
    public Curso save(Curso curso) {
        validarCurso(curso);

        return cursoDao.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
         validarCurso(curso);

        return cursoDao.update(curso);
    }
   

    @Override
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
         return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoDao.findById(id);
    }

    private void validarCurso(Curso curso) {
      if(StringUtil.isNullOrEmpty(curso.getNome())) { // Verifica se o nome está vazio ou nulo
            throw new RuntimeException("Nome obrigatório.");
        }

        if(curso.getQuantidade() == null || curso.getQuantidade() <= 0) {// Verifica se a quantidade é inválida
            throw new RuntimeException("Quantidade inválida.");
        }
    }
    
}
