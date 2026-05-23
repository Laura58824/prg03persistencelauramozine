package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public class GenericDao<Entity extends PersistenceEntity>
        implements GenericIDao<Entity> {

    /**
     * EntityManager gerenciado pelo Spring.
     */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Salva uma entidade no banco.
     */
    @Override
    public Entity save(Entity entity) {

        entityManager.persist(entity);

        return entity;
    }

    /**
     * Atualiza uma entidade existente.
     */
    @Override
    public Entity update(Entity entity) {

        return entityManager.merge(entity);
    }

    /**
     * Remove uma entidade do banco.
     */
    @Override
    public void delete(Entity entity) {

        entity = findById(entity.getId());

        entityManager.remove(entity);
    }

    /**
     * Busca entidade pelo ID.
     */
    @Override
    public Entity findById(Long id) {

        return (Entity) entityManager.find(
                getTypeClass(),
                id
        );
    }

    /**
     * Lista todas as entidades.
     */
    @Override
    public List<Entity> findAll() {

        return entityManager
                .createQuery(
                        "from " + getTypeClass().getSimpleName()
                )
                .getResultList();
    }

    /**
     * Descobre automaticamente
     * qual entidade está usando o DAO.
     */
    protected Class<?> getTypeClass() {

        return (Class<?>)
                ((ParameterizedType)
                this.getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }
}