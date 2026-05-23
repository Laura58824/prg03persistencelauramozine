package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author m
 */

@Service
public class CursoService implements CursoIService {

    /*
     * Classe responsável pelas regras de negócio da entidade Curso.
     *
     * O Service:
     * - valida dados
     * - aplica regras de negócio
     * - chama o DAO
     *
     * A View nunca deve acessar o DAO diretamente.
     */

    @Autowired
    private CursoIDao cursoDao;

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

        // Verifica se o nome está vazio ou nulo
        if (StringUtil.isNullOrEmpty(curso.getNome())) {

            throw new RuntimeException("Nome obrigatório.");
        }

        // Verifica se a quantidade é inválida
        if (curso.getQuantidade() == null
                || curso.getQuantidade() <= 0) {

            throw new RuntimeException("Quantidade inválida.");
        }
    }

}