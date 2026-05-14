/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;

/**
 *
 * @author m
 */
public class CursoController implements CursoIController {

    private final CursoIService cursoService;

    
    public CursoController() {
        this.cursoService = new CursoService();
    }
    
    @Override
    public Curso save(Curso curso) {
       return cursoService.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
         return cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso) {
         cursoService.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
         return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoService.findById(id);
    }
    
}
