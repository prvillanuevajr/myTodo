package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.Todo;
import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.HibConfiguration;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class TodoDao {
    public boolean persist(Todo todo) {
        try(Session session = HibConfiguration.getSessionFactory().openSession()){
            session.getTransaction().begin();
            session.persist(todo);
            session.getTransaction().commit();
            return true;
        }
    }

    public List<Todo> findAll(User user) {
        if (user != null) {
            try(Session session = HibConfiguration.getSessionFactory().openSession()){
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Todo> select = cb.createQuery(Todo.class);
                Root<Todo> root = select.from(Todo.class);
                return session.createQuery(select.where(cb.equal(root.get("user").get("id"),user.getId()))).getResultList();
            }
        }
        return null;
    }

    public boolean delete(long todoId) {
        try (Session session = HibConfiguration.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaDelete<Todo> delete = cb.createCriteriaDelete(Todo.class);
            Root<Todo> root = delete.getRoot();
            delete.where(cb.equal(root.get("id"),todoId));
            session.getTransaction().begin();
            boolean deleted = session.createQuery(delete).executeUpdate() == 1;
            session.getTransaction().commit();
            return deleted;
        }
    }

    public boolean markAsComplete(long todoId) {
        try (Session session = HibConfiguration.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<Todo> cq = cb.createCriteriaUpdate(Todo.class);
            Root<Todo> root = cq.getRoot();
            cq = cq.where(cb.equal(root.get("id"), todoId));
            session.getTransaction().begin();
            cq = cq.set(root.get("completedAt"), Timestamp.valueOf(LocalDateTime.now())).where(cb.equal(root.get("id"), todoId));
            boolean updated = session.createQuery(cq).executeUpdate() == 1;
            session.getTransaction().commit();
            return updated;
        }
    }
}
