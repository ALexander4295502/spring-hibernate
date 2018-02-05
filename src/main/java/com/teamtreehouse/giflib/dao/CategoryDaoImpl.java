package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Get all categories with a Hibernate criteria
        List<Category> categories = session.createCriteria(Category.class)
                .list();

        // Close session
        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        // Open a session
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, id);

        // Make sure we get the mapped collections before session close
        Hibernate.initialize(category.getGifs());

        // Close the session
        session.close();

        return category;
    }

    @Override
    public void save(Category category) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the category
        session.save(category);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

    }

    @Override
    public void delete(Category category) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Delete the category
        session.delete(category);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

    @Override
    public void update(Category category) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Update the category
        session.update(category);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}
