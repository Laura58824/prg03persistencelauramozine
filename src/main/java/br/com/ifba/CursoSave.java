package br.com.ifba;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável pelas operações CRUD da entidade Curso.
 * Aqui é feita toda a comunicação com o banco usando JPA/Hibernate.
 */
public class CursoSave {
/**
     * Factory responsável por criar EntityManagers.
     * Ela é única (static) para evitar múltiplas conexões desnecessárias.
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoPU");

    public void create(Curso curso) { //CREATE - Insere um novo curso no banco de dados.

        EntityManager em = emf.createEntityManager(); // abre conexão
        em.getTransaction().begin();// inicia transação
        em.persist(curso);// salva o objeto no banco

        em.getTransaction().commit(); // confirma a operação
        em.close();// fecha conexão
    }

    public List<Curso> findAll() { //Busca todos os cursos cadastrados.

        EntityManager em = emf.createEntityManager();// abre conexão

        // busca todos os registros da entidade Curso

        List<Curso> lista = em.createQuery("FROM Curso", Curso.class).getResultList();
        em.close();// fecha conexão

        return lista;// retorna lista de curso
    }

    public void delete(Long id) { //DELETE - Remove um curso pelo ID.

        EntityManager em = emf.createEntityManager(); // abre conexão
        em.getTransaction().begin();// inicia transação

        Curso curso = em.find(Curso.class, id);// procura o curso no banco pelo ID

        if (curso != null) {  // só remove se existir
            em.remove(curso);
        }

        em.getTransaction().commit();// confirma exclusão
        em.close();// fecha conexão
    }

    public void update(Curso curso) { //UPDATE - Atualiza um curso existente no banco.

        EntityManager em = emf.createEntityManager(); // abre conexão
        em.getTransaction().begin();// inicia transação

        em.merge(curso); // merge atualiza o registro existente

        em.getTransaction().commit();// confirma atualização
        em.close();// fecha conexão
    }
}