package com.dimrakitin.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
    
    private EntityManager em;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void close() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }

    @Test
    public void shouldPersistCategory() {
        Category cat = new Category();
        cat.setTitle("new category");
        em.persist(cat);
    }

    @Test
    public void shouldFindCategory() {
        Category cat = new Category();
        cat.setTitle("test");
        em.persist(cat);
        Category result = em.find(Category.class, 1L);
        assertNotNull(result);
    }

    @Test
    public void shouldNotFindCategory() {
        Category cat = new Category();
        cat.setTitle("test");
        em.persist(cat);
        Category result = em.find(Category.class, 2L);
        assertNull(result);
    }

    @Test
    public void shouldPersistCategoryAndTopics() {
        Category cat = new Category();
        cat.setTitle("test");
        Task task = new Task();
        task.setText("topic");
        task.setCategory(cat);
        em.persist(cat);
    }

}
