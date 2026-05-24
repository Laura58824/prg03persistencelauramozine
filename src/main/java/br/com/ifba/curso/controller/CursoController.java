package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CursoController implements CursoIController {

    private static final Logger LOG = Logger.getLogger(CursoController.class.getName());

    @Autowired
    private CursoIService cursoService;

    @Override
    public Curso save(Curso curso) {
        LOG.info("Controller: save chamado.");
        return cursoService.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        LOG.info("Controller: update chamado para ID: " + curso.getId());
        return cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        LOG.info("Controller: delete chamado para ID: " + curso.getId());
        cursoService.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        LOG.info("Controller: findAll chamado.");
        return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id) {
        LOG.info("Controller: findById chamado para ID: " + id);
        return cursoService.findById(id);
    }
}