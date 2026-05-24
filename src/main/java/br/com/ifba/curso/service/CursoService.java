package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements CursoIService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {

        validarCurso(curso);

        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {

        validarCurso(curso);

        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Curso curso) {

        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> findAll() {

        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {

        return cursoRepository.findById(id).orElse(null);
    }

    private void validarCurso(Curso curso) {

        if (StringUtil.isNullOrEmpty(curso.getNome())) {

            throw new RuntimeException("Nome obrigatório.");
        }

        if (curso.getQuantidade() == null
                || curso.getQuantidade() <= 0) {

            throw new RuntimeException("Quantidade inválida.");
        }
    }
}