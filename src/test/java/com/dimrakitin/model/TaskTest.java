package com.dimrakitin.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
    
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
    public void shouldPersistTask() {
        Task task = new Task();
        task.setText("new task");
        em.persist(task);
    }

}
