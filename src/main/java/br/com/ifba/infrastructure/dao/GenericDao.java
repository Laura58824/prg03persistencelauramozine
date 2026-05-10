/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author m
 * @param <Entity>
 */
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    
       /**
     * Responsável pela comunicação com o banco.
     */
    protected static EntityManager entityManager;

    /**
     * Bloco estático executado uma única vez
     * quando a aplicação inicia.
     *
     * Aqui é criada a conexão com a unidade
     * de persistência configurada no persistence.xml
     */
    static {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("poo_dao");

        entityManager = factory.createEntityManager();
    }

    // Salva uma entidade no banco.
     
    @Override
    public Entity save(Entity entity) {

        entityManager.getTransaction().begin();

        entityManager.persist(entity);

        entityManager.getTransaction().commit();

        return entity;
    }

    // Atualiza uma entidade existente no banco.
    
    @Override
    public Entity update(Entity entity) {

        entityManager.getTransaction().begin();

        entity = entityManager.merge(entity);

        entityManager.getTransaction().commit();

        return entity;
    }

    // Remove uma entidade do banco.
    
    @Override
    public void delete(Entity entity) {

        entity = findById(entity.getId());

        entityManager.getTransaction().begin();

        entityManager.remove(entity);

        entityManager.getTransaction().commit();
    }

    
    @Override
    public Entity findById(Long id) {
          return (Entity) entityManager.find(getTypeClass(), id);
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("from " + getTypeClass().getSimpleName() ).getResultList();
    }
    
    protected Class<?> getTypeClass() {

    return (Class<?>) ((ParameterizedType) this.getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
/**/