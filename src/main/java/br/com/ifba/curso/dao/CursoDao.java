package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author m
 */

@Repository
public class CursoDao extends GenericDao<Curso>implements CursoIDao {

}