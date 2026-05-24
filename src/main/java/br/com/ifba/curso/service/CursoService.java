package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements CursoIService {

    private static final Logger LOG = Logger.getLogger(CursoService.class.getName());

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        LOG.info("Salvando curso: " + curso.getNome());
        validarCurso(curso);
        Curso salvo = cursoRepository.save(curso);
        LOG.info("Curso salvo com ID: " + salvo.getId());
        return salvo;
    }

    @Override
    public Curso update(Curso curso) {
        LOG.info("Atualizando curso ID: " + curso.getId());
        validarCurso(curso);
        Curso atualizado = cursoRepository.save(curso);
        LOG.info("Curso atualizado com sucesso.");
        return atualizado;
    }

    @Override
    public void delete(Curso curso) {
        LOG.info("Excluindo curso ID: " + curso.getId());
        cursoRepository.delete(curso);
        LOG.info("Curso excluído com sucesso.");
    }

    @Override
    public List<Curso> findAll() {
        LOG.info("Buscando todos os cursos.");
        List<Curso> cursos = cursoRepository.findAll();
        LOG.info("Total de cursos encontrados: " + cursos.size());
        return cursos;
    }

    @Override
    public Curso findById(Long id) {
        LOG.info("Buscando curso por ID: " + id);
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            LOG.warning("Curso não encontrado para ID: " + id);
        }
        return curso;
    }

    private void validarCurso(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            LOG.warning("Tentativa de salvar curso sem nome.");
            throw new RuntimeException("Nome obrigatório.");
        }
        if (curso.getQuantidade() == null || curso.getQuantidade() <= 0) {
            LOG.warning("Tentativa de salvar curso com quantidade inválida.");
            throw new RuntimeException("Quantidade inválida.");
        }
    }
}